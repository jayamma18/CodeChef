# SBIBPD05

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Music Playlist Editor

Let's build upon the concept of using `ArrayList` with a "Music Playlist Editor". This will allow you to add songs to your playlist, view them, insert new songs at specific positions, and remove songs. This exercise will further reinforce how to add, access, insert, and remove elements from an `ArrayList`. It will also indirectly touch upon exception handling concepts because attempting to access an invalid index would result in `IndexOutOfBoundsException`.

Here's the problem:

You need to create a program that does the following:

- Creates an ArrayList to store song titles (strings).
- Adds three initial song titles: "Bohemian Rhapsody", "Imagine", and "Stairway to Heaven".
- Prints all the song titles, each on a new line, with their index number.
- Inserts a new song, "Hotel California", at index 1.
- Removes the song at index 2 (which was originally "Imagine" before insertion).
- Prints the updated playlist, again with index numbers on new lines.

Here's how the output should look after adding the initial songs:

```
Music Playlist:
0: Bohemian Rhapsody
1: Imagine
2: Stairway to Heaven

```

And after inserting "Hotel California" at index 1 and removing the element at index 2:

```
Updated Music Playlist:
0: Bohemian Rhapsody
1: Hotel California
2: Stairway to Heaven

```

Complete the code below to achieve this.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T09:20:57.027Z  

```java
import java.util.ArrayList;

class Codechef {
    public static void main(String[] args) {

        // 1. Create an ArrayList
        ArrayList<String> playlist = new ArrayList<>();

        // 2. Add three initial songs
        playlist.add("Bohemian Rhapsody");
        playlist.add("Imagine");
        playlist.add("Stairway to Heaven");

        // 3. Print the initial playlist
        System.out.println("Music Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }

        // 4. Insert "Hotel California" at index 1
        playlist.add(1, "Hotel California");

        // 5. Remove the song at index 2
        playlist.remove(2);

        // 6. Print the updated playlist
        System.out.println();
        System.out.println("Updated Music Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/SBIBPD05)