package com.practice.fileOperations;

import java.io.*;

public class TransientDemo implements Serializable {
    int num = 101;
    final int fnum = 11;
    transient int tnum = 33;
    transient final int tfnum = 45;
    transient static int tsnum = 77;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransientDemo td = new TransientDemo();
        String file = "src/main/resources/transientDemo.txt";

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(td);
        System.out.println("Values written: \n" + td);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientDemo tdReturns = (TransientDemo) ois.readObject();
        System.out.println("Values retrieved: \n" + tdReturns);
    }

    @Override
    public String toString() {
        return "TransientDemo{" +
                "num=" + num +
                ", fnum=" + fnum +
                ", tnum=" + tnum +
                ", tfnum=" + tfnum +
                ", tsnum=" + tsnum +
                '}';
    }
}
