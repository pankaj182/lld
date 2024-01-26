package org.neatcode;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======Simple Bloom Filter=======");
        BloomFilter<String> simpleBloomFilter = new SimpleBloomFilter<>();
        simpleBloomFilter.add("A");
        simpleBloomFilter.add("B");
        simpleBloomFilter.add("C");
        simpleBloomFilter.add("D");
        System.out.println("contains A: " + simpleBloomFilter.contains("A"));
        System.out.println("contains a: " + simpleBloomFilter.contains("a"));

        System.out.println("=======Counting Bloom Filter=======");
        BloomFilter<String> countingBloomFilter = new CountingBloomFilter<>();
        countingBloomFilter.add("A");
        countingBloomFilter.add("B");
        countingBloomFilter.add("C");
        countingBloomFilter.add("D");
        System.out.println("contains A: " + countingBloomFilter.contains("A"));
        System.out.println("contains a: " + countingBloomFilter.contains("a"));
        countingBloomFilter.delete("A");
        System.out.println("contains A: " + countingBloomFilter.contains("A"));
    }
}
