Linked List Operations for Handling Lists of Numbers
Introduction to Data Structures and Algorithms

In this guide, we'll implement a series of operations using linked lists, specifically tailored for handling two lists of numbers read from a text file. We'll consider both sorted and unsorted linked lists, discussing their time complexities for each operation.

### Operations to Implement

1. **MakeHeap**: Creates an empty linked list.
2. **Insert**: Inserts an item into the list.
3. **Minimum**: Returns the minimum value of the list.
4. **ExtractMin**: Extracts the minimum from the list and returns it.
5. **Union**: Combines both lists into one list.

### Approach

1. **Prompt the User**: Ask the user whether they want to work with a sorted or unsorted linked list.
2. **Read Input from File**: Read two lists of numbers from a text file.
3. **Sort if Necessary**: If the user chose a sorted linked list, sort the lists upon insertion.
4. **Ask the user** to choose command from the command bellow and execute.
   
### Time Complexities

- **MakeHeap**: O(1)
- **Insert**:
  - Sorted List: O(n) (due to finding the correct position)
  - Unsorted List: O(1) (insert at the head)
- **Minimum**:
  - Sorted List: O(1)
  - Unsorted List: O(n)
- **ExtractMin**:
  - Sorted List: O(1)
  - Unsorted List: O(n)
- **Union**: O(m + n)
  - Sorted List: O(n) 
  - Unsorted List: O(1)

This structure ensures efficient operations tailored to the specific requirements of either sorted or unsorted linked lists.
