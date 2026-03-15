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

1.  We will be coming thought the **Time Complexity**  for this project!
2. We usually illustrate this, with the three letters:
    - **Omega**.
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

> [!IMPORTANT]  
> we can see that this is `O(n)` **Linear Time**

# Coding Exercise 01 ↔ Big O: O(n).

<div align="center">
    <img src="Coding_Exercise_01_Big_O.PNG"  alt="Coding Exercise 01 Big O Exercise" width="400"/>
</div>


<details>
<summary id="The factorial thread" open="true"> <b>Coding Exercise 01: Big O Question!</b> </summary>

````yml
<> Big O: O(n)
Write a method called printItems in Java.

The purpose of this method is to print out a series of integer numbers, starting from 0 up to (but not including) a specified number.

Code that is provided:
    1. The method is defined as public and static, meaning it can be accessed from any class without needing to create an instance of the class it belongs to.

    2. The method  returns void, meaning it will not return any value.

    3. The method accepts a single parameter, an integer n. The method will use this value to determine the number of items to be printed.


Code that you are tasked with writing:

    1. The method should include a for loop. The loop should start with a counter i initialized at 0, continue as long as i is less than n, and increment i by 1 with each iteration.

    2. Inside the loop, the method should print the current value of i to the console followed by a new line.


The final result of this task should be a method that, when called with an argument n, prints the integer numbers from 0 to n-1 (inclusive) on separate lines.

For instance, if called with n = 10, the output should be:

0
1
2
3
4
5
6
7
8
9

````


</details>

```yaml
Task 1: Write a method called printItems in Java.
```

1. **Task 1:**
	- **Answer:** 
    ````Java
    public class Main {
        public static void printItems(int n) {
        
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        }

        // DO NOT CHANGE THE MAIN METHOD BELOW
        public static void main(String[] args) {
            printItems(10);
        }
    }
    ````

# Big O: Drop Constants.

<div align="center">
    <img src="Drop_Constants_Intro.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We are experimenting of dropping the **constants**!

- Code that we are going to analyze:

````Java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }

    for (int j = 0; j < n; j++) {
        System.out.println(j);
    }
}
````

- Running the code:

````Java
import misc.big_o.BigO_Second;

public class Main {
    public static void main(String[] args) {
        BigO_Second.printItems(10);
    }
}
````

- We are running the code:

<div align="center">
    <img src="N_Plus_N.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We can see that **10** items have replayed **two times**! That's like `n+n`!

<div align="center">
    <img src="Analysing_The_Algorithm.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We had `n + n` operations. We passed **10** + **10** items we got **20** times.
2. It becomes `2n`, **two** times `n`.  
3. We could think of this `O(2n)`.
4. We **simplify** this `O(n)`. 

> [!NOTE]
> **Rule of simplification**: We always **drop** the **constants**!

# Big O: O(n^2).

<div align="center">
    <img src="O_Of_N_Pow_Two.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We will be exploring the `O(n^2)`.

- Code that we are going to analyze:
    - Here is the two for loops inside each other.

````Java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + " " + j);
        }
    }
}
````

- Notice, the **difference** there is **two** `for` loops inside.

- Running the code:

````Java
import misc.big_o.BigO_Second;
import misc.big_o.BigO_Third;

public class Main {
    public static void main(String[] args) {
        BigO_Third.printItems(10);
    }
}
````

- We are running the code:

<div align="center">
    <img src="N_Pow_Two.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. It goes to **99**.

<div align="center">
    <img src="Analysing_The_Algorithm_N_Pow_Two.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. This was run `n * n`.
2. This can be simplified `n^2`.
3. This is `O(n^2)`.

> [!IMPORTANT]  
>  We are calling this as `O(n2)` **Quadratic Time**!

<div align="center">
    <img src="O_Of_N_Pow_Two_Graph.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="700"/>
</div>

1. `O(n^2)` is more heavy operation compared to `O(n)`.
    - If there is to write the code to `O(n)`, it is **huge plus**!
2. Number of operations!
3. `n` passed to function!

# Big O: Drop Non-Dominants.

- Code that we are going to analyze:
    - Here is the two `for` loops inside each other and another `for` next to it.

````Java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + " " + j);
        }
    }

    for (int k = 0; k < n; k++) {
        System.out.println(k);
    }
}
````

- We can see this running:

<div align="center">
    <img src="N_Pow_Two_Example_Running.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="700"/>
</div>

1. One can see the output!

<div align="center">
    <img src="Big_O_Drop_Non_Dominants_Analysiz.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="700"/>
</div>

1. This first part is `O(n^2)`.
    - `1.1` is `n` times since it was **quadratic time**!
2. This second part is `O(n)`.
    - `2.1` is `n` times since it was **linear time**!

<div align="center">
    <img src="Worst_Case_Operation_Is_Taking_Place.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="400"/>
</div>

1. The **worst** case is the `n^2`.
    - This will be chosen for the **worst** case!
2. The **less bad** case is the `n`.

<div align="center">
    <img src="Dropping_The_N.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We just drop the `n` and the `O(...)` case will be `n^2`!

> [!NOTE]  
> `O` was the worst case!

# Big O: O(1).

<div align="center">
    <img src="O_Of_One_Intro.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We will be going thought, the **most efficient** t

<div align="center">
    <img src="N_Pow_Two_Example_Analysis.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. In this example if the `n` **grows** the **operations** execution time status stays at the `O(1)`, since there is one `+` operation!
2. Now if we add **new** `+` **operation** we could say this `O(2)`,
3. We will be simplifying this into the `O(1)`. This is called **Constant Time**
    - If the `n` grows, the number of operation **does not** grow! 



<div align="center">
    <img src="O_Of_One.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. `n` passed to the function! 
2. Number of operation.
3. `O(1)` is most **efficient**!

# Big O: O(log n).

<div align="center">
    <img src="O_Of_N_Pow_Two.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. `O(log n)`.


# Big O: Different Terms for Input.

# Big O: Array Lists.

# Big O: Wrap Up.

# Quiz 01: Big O.