### Using Hash Functions
- The idea is to use hash function that converts a given phone number or any other key to a smaller number
- and uses the small number as index in a table called hash table.
- a hash function maps a big number or string to a small integer that can be used as index in hash table.

### Good Hash Function
A good hash function should have following properties:
- Efficiently computable.
- Should uniformly distribute the keys (Each table position equally likely for each key)

### Collision Handling
Since a hash function gets us a small number for a big key, there is possibility that two keys result in same value.
The situation where a newly inserted key maps to an already occupied slot in hash table is called collision and must be handled using some collision handling technique.
Following are the ways to handle collisions:
1. Separate Chaining
2. Open Addressing

- Collisions are very likely even if we have big table to store keys.
- An important observation is Birthday Paradox. With only 23 persons, the probability that two people have same birthday is 50%.
  With 367- 100% , only with 70 - 99.9%
  `P(same) = 1-P(diff)`;
  `P(diff) =  (364/365) x (363/365) x (362/365) x …. x (1 – (n-1)/365)`   , where n is the number of persons in the room.

#### Separate Chaining:
- The idea is to make each cell of hash table point to a linked list of records that have same hash function value.
- Advantages:
    1) Simple to implement.
    2) Hash table never fills up, we can always add more elements to chain.
    3) Less sensitive to the hash function or load factors.
    4) It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.

- Disadvantages:
    1) Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
    3) Wastage of Space (Some Parts of hash table are never used)
    4) If the chain becomes long, then search time can become `O(n)` in worst case.
    5) Uses extra space for links.
       m = Number of slots in hash table
       n = Number of keys to be inserted in has table
       Load factor α = n/m

#### Open Addressing :
- In Open Addressing, all elements are stored in the hash table itself.
- So at any point, size of table must be greater than or equal to total number of keys (Note that we can increase table size by copying old data if needed).
  - `Insert(k)`: Keep probing until an empty slot is found. Once an empty slot is found, insert k.
  - `Search(k)`: Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.
  - `Delete(k)`: Delete operation is interesting. If we simply delete a key, then search may fail. So slots of deleted keys are marked specially as “deleted”.
  - Insert can insert an item in a deleted slot, but search doesn’t stop at a deleted slot.

Open Addressing is done following ways:

for exploring, we have a technical term called **probing**.
a) **Linear Probing**:
- In linear probing, we linearly probe for next slot. For example, typical gap between two probes is 1
- `(hash(x) + 1) % S` is also full, then we try `(hash(x) + 2) % S`
- The main problem with linear probing is clustering, many consecutive elements form groups and it starts taking time to find a free slot or to search an element.
- Linear probing has the best cache performance, but suffers from clustering.
- One more advantage of Linear probing is easy to compute.
  b) **Quadratic Probing** :
- we look for `i^2‘th` slot in i’th iteration.
- If `(hash(x) + 1*1) % S` is also full, then we try `(hash(x) + 2*2) % S`
- Quadratic probing lies between the two in terms of cache performance and clustering.
  c) **Double Hashing**
- We use another hash function `hash2(x)` and look for `i*hash2(x)` slot in i’th rotation.
- If `(hash(x) + 1*hash2(x)) % S` is also full, then we try `(hash(x) + 2*hash2(x)) % S`
- Double hashing has poor cache performance but no clustering. Double hashing requires more computation time as two hash functions need to be computed.

Advantages of Open Addressing
- Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
- Wastage of Space (Some Parts of hash table in chaining are never used). In Open addressing, a slot can be used even if an input doesn’t map to it.
- haining uses extra space for links.

<hr>
