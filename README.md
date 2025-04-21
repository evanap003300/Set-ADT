# SET — Custom Java Set Implementation

This project is a custom Java implementation of a basic **Set** data structure designed to handle core set operations such as `union`, `intersection`, `complement`, `subset testing`, and `element deletion` without relying on Java's built-in `Set` library.

---

## Overview
The `SET` class supports fundamental set operations.

This project focuses on:
- Understanding object-oriented design.
- Handling type erasure and Java generics.
- Implementing basic set theory logic without external dependencies.

---

## Features
- `add()` — Adds an element to the set (if not already present).
- `delete()` — Removes an element from the set.
- `union()` — Combines two sets into one.
- `intersection()` — Returns elements shared between two sets.
- `complement()` — Returns all elements from the universe set not present in the current set.
- `isSubset()` — Checks if a set is a subset of another.
- `cardinality()` — Returns the size of the set.
- `contains()` — Checks for the presence of an element.
- `toString()` — Prints the set in a readable list format.

---

## Technologies Used
- Java 17
- Standard Java Collections (Array-based backend)

---

## How to Run
1. Clone the repository.
2. Compile and run the `SET.java` file.
```bash
javac SET.java
java SET
