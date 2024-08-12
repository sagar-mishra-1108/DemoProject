package com.practice.fileOperations;

import java.io.*;

public class FileReadWriteDemo {

    public static void main(String[] args) throws IOException {
        FileReadWriteDemo demo = new FileReadWriteDemo();
        demo.fileWrite(true);
        demo.fileReadOneChar();
        demo.fileReadWhole();
        demo.fileBufferedWriter(true);
        demo.fileBufferedReader();
    }

    private void fileBufferedWriter(boolean append) throws IOException {
        File file = new File("src/main/resources/demoFile.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            bw.write("New Line by Buffered Writer\n");
        }
    }

    private void fileBufferedReader() throws IOException {
        File file = new File("src/main/resources/demoFile.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

    }

    private void fileWrite(boolean append) throws IOException {
        File file = new File("src/main/resources/demoFile.txt");
        try (FileWriter fw = new FileWriter(file, append)) {
            fw.write("Another new text\n");
        }
    }

    public void fileReadOneChar() throws IOException {
        File file = new File("src/main/resources/demoFile.txt");
        try (FileReader fr = new FileReader(file)) {
            System.out.println((char) fr.read());
        }
    }

    public void fileReadWhole() throws IOException {
        File file = new File("src/main/resources/demoFile.txt");
        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            fr.read(chars);
            System.out.println(new String(chars));
        }
    }

}
