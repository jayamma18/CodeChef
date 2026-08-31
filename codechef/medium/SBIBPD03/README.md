# SBIBPD03

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### To-Do List Application

Let's build a simple "To-Do List" application using `ArrayList`. This will allow you to add tasks, view them, and remove them. We will leverage the concepts you learned about `ArrayList`, focusing on adding, accessing, and removing elements.

Here's the problem:

You need to create a program that does the following:

- Creates an ArrayList to store to-do items (strings).
- Adds three initial to-do items: "Grocery Shopping", "Laundry", and "Pay Bills".
- Prints all the to-do items, each on a new line, with their index number.
- Removes the to-do item at index 1 (which is "Laundry").
- Prints the updated to-do list, again with index numbers on new lines.

This exercise will reinforce how to add, access, and remove elements from an `ArrayList`. It will also indirectly use the exception handling concepts, because attempting to access an invalid index would result in `IndexOutOfBoundsException`.

Here's how the output should look after adding the initial items:

```
To-Do List:
0: Grocery Shopping
1: Laundry
2: Pay Bills

```

And after removing "Laundry":

```
Updated To-Do List:
0: Grocery Shopping
1: Pay Bills

```

Now, let's walk through the solution.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T09:17:00.298Z  

```java
import java.util.ArrayList;

class Codechef {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();

        // Add items
        todoList.add("Grocery Shopping");
        todoList.add("Laundry");
        todoList.add("Pay Bills");

        // Print initial list
        System.out.println("To-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + ": " + todoList.get(i));
        }

        // Remove item at index 1
        todoList.remove(1);

        // Print updated list
        System.out.println();
        System.out.println("Updated To-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + ": " + todoList.get(i));
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/SBIBPD03)