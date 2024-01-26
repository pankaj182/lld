## Bloom Filter

- A Bloom filter is a probabilistic data structure designed to test whether a given element is a member of a set.
- It may return false positives but never false negatives. ie `probably YES, but definite NO`
- The basic idea behind a Bloom filter involves using multiple hash functions to map elements to a bit array.

### Use Cases:
- Caching: to check whether an item is present in a cache before accessing a slower data source.
- Spell Checking: to check if a word is misspelled by determining if it's not in the dictionary.
- Network Routing: to reduce the number of lookups in a routing table.
- Duplicate Elimination: can help identify potential duplicates in large datasets.
- Web Crawling: used to store visited URLs, avoiding revisiting the same URLs during web crawling.
- reducing disk lookups for the non-existing keys in a database
- determining whether a user ID is already taken
- filtering out previously shown posts on recommendation engines
- **identifying malicious URLs**, blocked IPs, and fraudulent transactions
- **Log-structured merge tree (LSM)** storage engine used in databases such as Cassandra uses a bloom filter to check if the key exists in the SSTable
- MapReduce uses the bloom filter for the efficient processing of large datasets

### Working
- Let's consider a simple example with a bit array of size 10 and three hash functions. Initially, all bits are set to 0.
```
Bit Array: 0 0 0 0 0 0 0 0 0 0
```
- Insert element "apple":
    - Hash functions produce three indices (hashed positions).
    - Set the corresponding bits to 1.
```
Hash("apple") = [3, 6, 8]
Bit Array: 0 0 0 1 0 0 1 0 1 0
```
- Insert element "orange":
```
Hash("orange") = [1, 4, 8]
Bit Array: 0 1 0 1 1 0 1 0 1 0
```
- Check for element "banana":
    - Hash functions produce three indices.
    - Check if all corresponding bits are set to 1 (may return a false positive).
```
Hash("banana") = [2, 5, 8]
All bits set? No.
```

### Time Complexity
- add item:	`O(k)` or `constant`
- membership query:	`O(k)` or `constant`

<hr>

## Counting Bloom Filter
- A Counting Bloom Filter is an extension of the basic Bloom Filter that **allows the removal of elements**. 
- Instead of a simple bit set, it **uses an array of counters** to **keep track of the number of times an element is added**. 
- Removal is achieved by **decrementing the counters when an element is deleted**. 

