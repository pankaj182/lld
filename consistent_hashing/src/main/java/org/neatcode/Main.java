package org.neatcode;

public class Main {
    public static void main(String[] args) {
        MyMap<String> consistentHashing = new ConsistentHashMap<>(3);

        // Add nodes to the hash circle
        consistentHashing.addNode("Node1");
        consistentHashing.addNode("Node2");
        consistentHashing.addNode("Node3");

        // Find the node responsible for a key
        String key = "SomeKey";
        String responsibleNode = consistentHashing.getNodeForKey(key);

        System.out.println("Key '" + key + "' is mapped to node: " + responsibleNode);

        // Remove a node from the hash circle
        consistentHashing.removeNode("Node2");

        // Find the node responsible for the key after removal
        responsibleNode = consistentHashing.getNodeForKey(key);

        System.out.println("Key '" + key + "' is now mapped to node: " + responsibleNode);
    }
}
