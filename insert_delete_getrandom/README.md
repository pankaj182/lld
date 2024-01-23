## Problem
Design a data structure with following Operations Supported:

**Insert**
- Insert an element E into the data structure
- O(1)

**Delete**
- Delete a given element E (if present) from the data structure
- O(1)

**Get Random**
- Return a random element for the data structure
- O(1)

## Solution
- maintain 2 data structure - an Arraylist and a HashMap
- for insertion:
  - if data is already present in hashmap, ignore
  - insert the data at the end into array list
  - push the data and index in Hashmap
- for deletion:
  - if data is not present in hashmap -> ignore
  - if present, check the index in hashmap and swap this element from last element of arraylist & update the index in hashmap
- for random, get a random integer between 0 and length of list -> return the element at this index
