# Chapter 06 - The Concurrency Challenges & Solutions.

The Concurrency Challenges & Solutions.

# What I learned.

# Critical Section & Synchronization.

<div align="center">
    <img src="What_We_Will_Learn_Next_Is_Critical_Sections.PNG" width="700" alt="Threads resource"/>
</div>

1. We will be starting to explore the **Critical Section**.


- We need to address following **problem**:

<div align="center">
    <img src="We_Had_Following_Problem_With_The_Concurrency.PNG" width="700" alt="Threads resource"/>
</div>

- We would need to execute **set** of operation, which would need to be executed as **single atomic operation**.
    - **Two** threads could be perform these set of codes at the same time. Example set of operations below:

````
void aggregateFunction() {
    operation1();
    operation2();
    operation3();
}
````

<div align="center">
    <img src="Critical_Section.gif" width="700" alt="Threads resource"/>
</div>

1. We will be surrounding this **critical section** with the **tags** as following. This will prevent the concurrent execution of the code. 
2. `Thread A` can execute the operations, exit and enter to this **section**.
3. If `Thread B` tries to access this **critical section**, while `Thread A` is still on it, the `Thread B` will be **suspended** status until the first **thread** `Thread A` is finished with the **critical section**.

<p align="center">
    <img src="Critical_Section_Second.gif" width="700" alt="Threads resource"/>
</p>

1. Once the `Thread A` finishes the **critical section**, the second **thread** `Thread B` can access the **critical section** and perform all the operations!

> [!TIP]
> **Remember** these concepts are the **same** regardless of the language. They might be in different flavor or API.

<div align="center">
    <img src="What_We_Will_Learn_Next_Synchronized.PNG" width="700" alt="Threads resource"/>
</div>

1. **JVM** provides us with many ways to **protect** the **critical section** against multiple threads execution!

<div align="center">
    <img src="Synchorinized_Keyword.PNG" width="700" alt="Threads resource"/>
</div>

1. Simplest solution is to use `synchronized` **keyword**. This is **locking mechanism**!
2. This is to prevent access to the **critical section** or to the **method** for the **single thread** at the time.
    - We have **two** ways to use this!
        - First the **Monitor** way!
        - Second the **Lock** way!

<div align="center">
    <img src="Synchronized_Used_In_The_Block.PNG" width="500" alt="Threads resource"/>
</div>

1. `synchronized` ensures that only **one thread** at a time can execute any synchronized method of that particular object instance (`method1()`, `method2()`, etc.). Other threads must wait until the monitor (lock) is released.
    - Only **one** **synchronized method** can be run at a time `ClassWithCriticalSections obj = new ClassWithCriticalSections();`.
        - We could start `a.method1()` and `b.method1()` at the same time, since `synchronized` instance methods **locks the object**, **not the class**! Example in below:

        ````
        ClassWithCriticalSections obj1 = new ClassWithCriticalSections();
        ClassWithCriticalSections obj2 = new ClassWithCriticalSections();

        Thread t1 = new Thread(() -> a.method1()); // This works.
        Thread t2 = new Thread(() -> b.method1()); // This works.
        t1.start(); // This works.
        t2.start(); // This works.
        ````
        
<div align="center">
    <img src="Synchronized_Used_In_The_Block_Second.PNG" width="500" alt="Threads resource"/>
</div>

1. If the `Thread A` is executing either `method1()` or `method2()` the `Thread B` is prevented to execute at all other methods. The locking is applied to the **object itself**, rather than **individual methods**!
    - The term used here is **Monitor**.

# Quiz 6: Critical Section & Synchronization.

# Atomic Operations, Volatile & Metrics Practical Example.

# Quiz 7: Atomic Operations, Volatile & Metrics Practical Example.

# Coding Exercise 3: Min - Max Metrics.

# Min - Max Metrics - Solution.

# Race Conditions & Data Races.

# Quiz 8: Data Races.

# Locking Strategies & Deadlocks.

# Quiz 9: Locking Strategies & Deadlocks.
