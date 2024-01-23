### Least Frequently Used (LFU)
- LFU is a cache eviction policy that removes the item that was `used the least frequently`. 
- The idea is to `keep the most popular items` in the cache, assuming that they have a higher probability of being requested again in the near future. 

- LFU is a more sophisticated policy than LRU that can avoid some of its pitfalls, such as:
  - It can prevent cache pollution by evicting items that are accessed only once or rarely, regardless of their recency. 
  - It can handle cyclic access patterns better than LRU by keeping items that are accessed more often than others.
- However, LFU also has some drawbacks, such as:
  - It can be more expensive to maintain than LRU, especially if the frequency counters and the data structure need to be updated frequently. 
  - It can suffer from aging, meaning that it can favor old items that have accumulated high frequencies over time, even if they are no longer relevant or useful. 
  - It can be ineffective for applications that have changing access patterns, meaning that items that were popular in the past may not be popular in the present or future.

- Implementation
  - LFU can be implemented using a frequency counter for each cached item, and a priority queue or a hash map of doubly linked lists to store the items in ascending order of their frequencies.
  - Whenever an item is accessed, its frequency counter is incremented and its position in the data structure is updated accordingly.
  - Whenever an item needs to be evicted, it is taken from the lowest frequency group.
