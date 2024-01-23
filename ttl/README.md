- TTL is a cache eviction policy that **removes the item that has expired its time to live**, which is a predefined duration that indicates how long an item can stay in the cache. 
- The idea is to keep the most up-to-date items in the cache, assuming that they are more relevant and useful than outdated ones.

- TTL is a flexible and adaptive policy that works well for applications that have dynamic and time-sensitive data, such as news, weather, or stock prices. 
- However, TTL also has some drawbacks, such as:
  - It can be expensive to maintain the timestamp and the data structure, especially if the TTL value is small and the cache size is large. 
  - It can be difficult to choose an optimal TTL value for each cached item, as it may depend on various factors such as the data source, the user preference, and the application context. 
  - It can be ineffective for applications that have static or persistent data, such as images, videos, or documents.

- TTL can be implemented using a timestamp for each cached item, and a priority queue or a hash map of doubly linked lists to store the items in ascending order of their expiration times. 
- Whenever an item is added to the cache, its timestamp is set to the current time plus the TTL value. 
- Whenever an item needs to be evicted, it is taken from the earliest expiration group.
