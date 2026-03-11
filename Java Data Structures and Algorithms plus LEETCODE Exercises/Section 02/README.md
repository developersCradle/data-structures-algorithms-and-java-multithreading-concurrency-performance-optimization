# Chapter 02: Big O.

Big O.

# What I learned.

# Big O: Intro.

<div align="center">
    <img src="Big_O_Intro.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. What is Big O? We will answer this question.

<div align="center">
    <img src="Comparing_Codes.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. Both have the same **code**, but the implementation is different.
    - Which ones better?
        - **BIG O** comes to help this!

- **Big O** is how compare two codes mathematically!

<div align="center">
    <img src="Comparing_Codes.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. Code 1 runs 15 secs!
2. Code 2 runs 60 secs!

- This is **Time Complexity**.
    - This is not measured in time!
        - If there is some **CPU** better, code will run faster!
    - That's why, it's measured in time per operation!

- **Space Complexity** is how much memory it consumes, here example of those **two** algorithms. The first here:

<div align="center">
    <img src="Space_Complexity_First_Algorithm.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="400"/>
</div>

- The second:

<div align="center">
    <img src="Space_Complexity_Second_Algorithm.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="400"/>
</div>

# Big O: Worst Case.

<div align="center">
    <img src="Big_O_Worst_Case.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. Time complexity project!
2. Three letters:
    - **Omega** .
    - **Theta**.
    - **Omegran** or **O**.

<div align="center">
    <img src="Array_With_For_Loop.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

0. Represents **array**, which we are looking when we are looping in for loop!
1. Best-case! **Omega** Ω.
2. Average-case! θ.
3. Worst-case! **Big O**.
    - Technically big **O** is the worst case!

# Big O: O(n).

<div align="center">
    <img src="O_Of_N.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. `O(n)` it might be the easiest to get head around!

- Code that we are going to analyze:

````Java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
}
````

- Running the code:

````Java
import datastructures.hashtable.HashTable;
import misc.big_o.BigO;

public class Main {

    public static void main(String[] args) {
        BigO.printItems(10);
    }
}
````

- We are running the code:

<div align="center">
    <img src="10_items.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We get 10 **items** from **n** times.

- Analysis of the code.

<div align="center">
    <img src="This_Code_Is_O_Of_N.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. This code is `O(n)`. It is `O(n)` since we passed **n=10** and it printed **10 times**!  

<div align="center">
    <img src="O_Of_N_Graph.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. `n` passed to function!
2. Number of operations!

- As you can see this is proportional!

# Coding Exercise 01 ↔ Big O: O(n).

# Big O: Drop Constants.

# Big O: O(n^2).

# Big O: Drop Non-Dominants.

# Big O: O(1).

# Big O: O(log n).

# Big O: Different Terms for Input.

# Big O: Array Lists.

# Big O: Wrap Up.

# Quiz 01: Big O.