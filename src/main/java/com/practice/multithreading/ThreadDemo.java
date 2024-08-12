package com.practice.multithreading;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
//        td.myThread();
//        td.myExecutor();
//        td.myCallable();
        td.completableFutureRunAsync();
        td.completableFutureSupplyAsync();
    }

    public void myThread() {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Before Sleep: " + name);
                Thread.sleep(2000);
                System.out.println("After Sleep: " + name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(task);
        thread1.start();
        Thread thread2 = new Thread(task);
        thread2.start();
        Thread thread3 = new Thread(task);
        thread3.start();
    }

    public void myExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("Name: " + name);
        });
        executor.shutdown();
        boolean terminated = false;
        try {
            terminated = executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!terminated) {
            executor.shutdownNow();
        }
    }

    public void myCallable() {
        Callable<String> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return "Return from myCallable after 2 seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        };
        try {
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<String> future = executor.submit(task);
            System.out.println("Completed: " + future.isDone());
            String result = future.get();
            System.out.println("Completed: " + future.isDone());
            System.out.println(result);
            executor.shutdown();
            boolean terminated = executor.awaitTermination(3, TimeUnit.SECONDS);

            if (!terminated) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void completableFutureRunAsync() {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> cFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completable Future Thread: " + Thread.currentThread().getName());
        });
        try {
            cFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void completableFutureSupplyAsync() {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Completable Future Thread: " + Thread.currentThread().getName();
        }).exceptionally(exception -> {
            System.out.println(exception.getMessage());
            return "Exception";
        });
        try {
            System.out.println(cFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
