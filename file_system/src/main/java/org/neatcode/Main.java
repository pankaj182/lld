package org.neatcode;

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/abc");
        fileSystem.addContentToFile("/abc/def.txt", "Hello,");
        fileSystem.addContentToFile("/abc/def.txt", " World!");
        System.out.println(fileSystem.readContentFromFile("/abc/def.txt")); // Output: Hello, World!
        System.out.println(fileSystem.ls("/"));
    }
}