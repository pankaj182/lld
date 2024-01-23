LRU Cache Discards least-recently-used items first.

- LRU is a cache eviction policy that removes the item that was used the least recently. 
- The idea is to keep the most frequently accessed items in the cache, assuming that they are more likely to be requested again in the near future.
- LRU is a simple and intuitive policy that works well for applications that have `temporal locality`, **meaning that recently accessed items are likely to be accessed again soon**. 
- However, LRU has some drawbacks, such as:
  - It can be expensive to maintain the linked list, especially if the cache size is large and the access frequency is high. 
  - It can suffer from cache pollution, meaning that it can fill the cache with items that are accessed only once or rarely, displacing items that are more useful. 
  - It can be ineffective for applications that have cyclic access patterns, meaning that items are accessed in a fixed order repeatedly. For example, if the cache size is 4 and the access pattern is A-B-C-D-E-A-B-C-D-E..., then LRU will always evict E, even though it is accessed frequently.


- LRU can be implemented using a linked list, where each node represents a cached item, and the head of the list is the most recently used item.
- Whenever an item is accessed, it is moved to the head of the list. Whenever an item needs to be evicted, it is taken from the tail of the list.

`LRUCache(int capacity)` Initialize the LRU cache with positive size capacity.

`int get(int key)` Return the value of the key if the key exists, otherwise return -1.

`void put(int key, int value)` Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
If the number of keys exceeds the capacity from this operation, `evict the least recently used key`.

The functions get and put must each run in `O(1) average time complexity`.