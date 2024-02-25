package org.neatcode;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        root = new Directory("/");
    }

    public List<String> ls(String path) {
        String[] parts = path.split("/");
        Component current = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                current = ((Directory) current).getComponent(part);
                if (current == null) return new ArrayList<>();
            }
        }
        List<String> result = new ArrayList<>();
        current.ls(result);
        return result;
    }

    public void mkdir(String path) {
        String[] parts = path.split("/");
        Component current = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                Component child = ((Directory) current).getComponent(part);
                if (child == null) {
                    Directory newDir = new Directory(part);
                    ((Directory) current).addComponent(newDir);
                    current = newDir;
                } else {
                    current = child;
                }
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        String fileName = parts[parts.length - 1];
        Component current = root;
        for (int i = 0; i < parts.length - 1; i++) {
            if (!parts[i].isEmpty()) {
                current = ((Directory) current).getComponent(parts[i]);
                if (current == null) return;
            }
        }
        File file = (File) ((Directory) current).getComponent(fileName);
        if (file == null) {
            file = new File(fileName);
            ((Directory) current).addComponent(file);
        }
        file.appendContent(content);
    }

    public String readContentFromFile(String filePath) {
        String[] parts = filePath.split("/");
        String fileName = parts[parts.length - 1];
        Component current = root;
        for (int i = 0; i < parts.length - 1; i++) {
            if (!parts[i].isEmpty()) {
                current = ((Directory) current).getComponent(parts[i]);
                if (current == null) return "";
            }
        }
        File file = (File) ((Directory) current).getComponent(fileName);
        if (file == null) return "";
        return file.readContent();
    }
}