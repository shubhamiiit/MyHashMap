### MyHashMap Package

---

### Introduction
This package provides a basic implementation of a HashMap data structure in Java. HashMap is a data structure that allows storage and retrieval of key-value pairs efficiently.

### Usage
You can use this package to store key-value pairs and retrieve values based on their keys.

### Classes
- **MyHashMap<K,V>**: This is the main class representing the HashMap. It has methods to put key-value pairs into the HashMap (`put()`), retrieve values based on keys (`get()`), and constructors to initialize the HashMap with default or specified capacity.
- **Entry<K,V>**: This class represents an entry in the HashMap, containing a key-value pair and a reference to the next entry in case of collisions.

### Constants
- **INITIAL_SIZE**: The initial capacity of the HashMap. It is set to 2^4.
- **MAXIMUM_CAPACITY**: The maximum capacity that the HashMap can reach. It is set to 2^30.

### Methods
- **put(K key, V value)**: Inserts the specified key-value pair into the HashMap.
- **get(K key)**: Retrieves the value associated with the specified key from the HashMap.

### Main Method
The `main` method demonstrates the usage of the `MyHashMap` class by creating a HashMap, putting key-value pairs into it, and retrieving a value based on a key.

### How to Use
1. Import the `HashMap` package.
2. Create an instance of `MyHashMap`.
3. Use the `put` method to insert key-value pairs into the HashMap.
4. Use the `get` method to retrieve values based on keys.

### Example
```java
MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(10);
map.put(1, "hi");
map.put(2, "bye");
String value = map.get(1);
System.out.println(value); // Output: hi
```

### Note
- This implementation does not handle concurrency. If used in a multi-threaded environment, synchronization must be added externally.
- Collision resolution is implemented using chaining.
- Key objects must properly implement the `hashCode` and `equals` methods for correct behavior.

