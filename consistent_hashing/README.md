- Consistent hashing is a technique used in distributed systems to map keys to nodes in a way that `minimizes remapping when nodes are added or removed`. 
- It is commonly used in distributed caches, distributed databases, and load balancing.

### Usecases
- Data partitioning - dbs like cassandara, dynamo db employ this to partition data across multiple servers
- similarly for data sharding, distributed file system, distributed caching
- CDN: like cloudflare use this to distribute content to a network of edge servers
- Load Balancing: distribute load to servers

### Problem with traditional hashing
- we use this `hash % n` model to map keys to servers (n = #servers)
- if a server dies or a new one is added, all keys are moved

### in consistent hashing,
- we hash keys as well as servers on to a `hash ring`
- now a key is mapped to the server which is closed to its right
- this reduces #keys shuffle once a server dies or a new one is added
- this approach can still lead to a problem, i.e all keys can fall between two servers, hence one of them will be severely loaded
- to counter this, we has virtual servers, i.e. we hash servers multiple times onto hash ring
