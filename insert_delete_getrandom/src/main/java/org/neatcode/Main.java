package org.neatcode;

public class Main {
    public static void main(String[] args) {
        RandomSet<Integer> randomSet = new RandomSetImpl();
        print(randomSet.insert(4));
        print(randomSet.insert(5));
        print(randomSet.insert(6));
        print(randomSet.insert(7));

        print(randomSet.insert(7));
        print(randomSet.insert(8));

        print(randomSet.delete(4));
        print(randomSet.delete(9));

        print(randomSet.getRandom());
        print(randomSet.getRandom());
    }

    static void print(Object o) {
        System.out.println(o);
    }
}