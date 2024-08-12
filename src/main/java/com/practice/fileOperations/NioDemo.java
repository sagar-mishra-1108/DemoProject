package com.practice.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NioDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        NioDemo nioDemo = new NioDemo();
        nioDemo.writeUsingNio1();
        nioDemo.readAllUsingNio1();
        nioDemo.writeUsingNio2();
        nioDemo.readAllUsingNio2();
        nioDemo.readUsingClassLoaderNio();
    }

    private void writeUsingNio1() throws IOException {
        String file = "src/main/resources/nioDemoFile.txt";
        String newText = "New Text via NIO\n";
        Files.write(Paths.get(file), newText.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private void writeUsingNio2() throws IOException {
        String file = "src/main/resources/nioDemoFile.txt";
        Files.write(Paths.get(file),
                Arrays.asList("New Line 1", "New Line 2", "New Line 3\n"),
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
    }

    private void readAllUsingNio1() throws IOException {
        String file = "src/main/resources/nioDemoFile.txt";
        byte[] bytes = Files.readAllBytes(Paths.get(file));
        System.out.println(new String(bytes));
    }

    private void readAllUsingNio2() throws IOException {
        String file = "src/main/resources/nioDemoFile.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
            System.out.println(br.lines().collect(Collectors.toList()));
        }
    }

    private void readUsingClassLoaderNio() throws URISyntaxException, IOException {
        URI uri = ClassLoader.getSystemResource("nioDemoFile.txt").toURI();
        Stream<String> fileStream = Files.lines(Paths.get(uri));
        fileStream.forEach(System.out::println);
    }
}
