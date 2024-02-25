package org.neatcode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

class Directory implements Component {
    private String name;
    private SortedMap<String, Component> children;

    public Directory(String name) {
        this.name = name;
        this.children = new TreeMap<>();
    }

    public void addComponent(Component component) {
        children.put(component.getName(), component);
    }

    public Component getComponent(String name) {
        return children.get(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void ls(List<String> res) {
        res.add(name);
        for (Component component : children.values()) {
            component.ls(res);
        }
    }
}
