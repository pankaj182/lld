package org.neatcode;

import java.util.List;

class File implements Component {
    private String name;
    private StringBuilder content;

    public File(String name) {
        this.name = name;
        this.content = new StringBuilder();
    }

    public void appendContent(String content) {
        this.content.append(content);
    }

    public String readContent() {
        return this.content.toString();
    }

    @Override
    public void ls(List<String> res) {
//        System.out.println(name);
        res.add(name);
    }

    @Override
    public String getName() {
        return name;
    }
}