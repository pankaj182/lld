package org.neatcode;

public class Main {
    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyHashMap<>();

        map.put("P", 16);
        map.put("U", 21);
        map.put("N", 13);
        map.put("K", 11);
        map.put("A", 1);
        map.put("J", 10);
        map.put("N", 14);

        System.out.println(map); // {P:16}{A:1}{U:21}{J:10}{K:11}{N:14}

        MyIterator<EntryNode<String, Integer>> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
