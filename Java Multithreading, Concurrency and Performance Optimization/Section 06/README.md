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
    - **Two** threads could be performing these set of codes **at the same time**. Example set of operations below:

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
2. This is to prevent access to the **critical section** or to the **method** from the **multiple threads** at the time.
    - We have **two** ways to use this!
        - First the **Monitor** way!
        - Second the **Lock** way!

<div align="center">
    <img src="Synchronized_Used_In_The_Block.PNG" width="500" alt="Threads resource"/>
</div>

1. **First** the Monitor way!
    - `synchronized` ensures that only **one thread** at a time can execute any synchronized method of that particular object instance (`method1()`, `method2()`, etc.). Other threads must wait until the monitor (lock) is released.
    - Only *one* **synchronized method** can be run at a time:

    ````
    ClassWithCriticalSections obj = new ClassWithCriticalSections();

    Thread t1 = new Thread(() -> obj.method1()); // This works.
    Thread t2 = new Thread(() -> obj.method1()); // This wont works!
    
    t1.start(); // This works.
    t2.start(); // This wont work!
    ````
    - We could start `a.method1()` and `b.method1()` at the same time, since `synchronized` keyword **locks the object**, **not the class**! Example in below:
    ````
    ClassWithCriticalSections obj1 = new ClassWithCriticalSections();
    ClassWithCriticalSections obj2 = new ClassWithCriticalSections();

    Thread t1 = new Thread(() -> obj1.method1()); // This works.
    Thread t2 = new Thread(() -> obj2.method1()); // This works.
    t1.start(); // This works.
    t2.start(); // This works.
    ````
        
<div align="center">
    <img src="Synchronized_Used_In_The_Block_Second.PNG" width="600" alt="Threads resource"/>
</div>

1. If the `Thread A` is executing either `method1()` or `method2()` the `Thread B` is prevented to execute at all other methods. The locking is applied to the **object itself**, rather than **individual methods**!
    - The term used here for this concept is **Monitor**.

<p align="center">
    <img src="Our_Critical_Section.PNG" width="500" alt="Threads resource"/>
</p>

1. We will apply our `synchronized` for our old user case!

> [!IMPORTANT]
> **Rule of Thumb (very important)**
> One should be using `synchronize` where the **shared data is**, not **where it is used**!

- We will be using `synchronized` **keyword** on the shared object.
You can see it's now fixed.
    - We are getting consistent results!

<div align="center">
    <img src="Using_Synchronized.gif" width="700" alt="Threads resource"/>
</div>

<details>
<summary id="The synchronized key word in locking monitor way!" open="true"> <b>Usage of synchronized key word in where data is shared! The Locking Monitor way!</b> </summary>

````Java 
/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * Resource Sharing & Introduction to Critical Sections
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        decrementingThread.join();
        incrementingThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;

        public synchronized void increment() {
            items++;
        }

        public synchronized void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }
}
````
</details>

- Second is the **Lock** way!

<div align="center">
    <img src="Synchronized_Used_In_The_Block_Using_Lock.PNG" width="700" alt="Threads resource"/>
</div>

1. We can use **Lock Objects** to block (synchronize) **sections of code** and **not block whole method**, therefore we have better control over blocking! 
    - This can be **any** Object!
2. We lock **specified section**, from other threads to access it, as long the **Object locked**!

> [!TIP]
> **Separate lock objects** = **better concurrency control**!

<div align="center">
    <img src="Using_Synchronized_As_Lock.gif" width="700" alt="Threads resource"/>
</div>

1. You can think as with the **Monitor** approach. This is equal to the approach in `2.`.
2. `synchronized(this)` in the methods, which will be blocking the methods calls of other threads.

<div align="center">
    <img src="We_Can_Have_More_Flexibility_In_Our_Code_When_Blocking.PNG" width="700" alt="Threads resource"/>
</div>

1. With this approach, we can have much more flexibility in our **blocking**.
    - We can have **multiple critical sections**, which are `synchronize`:d into **multiple different objects** in the same class!

<div align="center">
    <img src="Using_Synchronized_As_Lock_With_Multiple_Blocking_Objects.gif" width="700" alt="Threads resource"/>
</div>

1. While `Thread A` will be accessing the `method1()`'s critical section. The `Thread B` will be accessing the `method2()`'s critical section.
2. Once the `Thread B` tries to the access the section where the `Thread A` is currently executing. The `Thread B` will get the access **blocked** and need to wait for the `Thread  A` to finish its **execution** of the **critical section**.

<div align="center">
    <img src="We_Can_Spesify_The_Section_Of_The_Code_The_Concurrent_Execution.PNG" width="700" alt="Threads resource"/>
</div>

1. With this, we can separate the **blocked** code section to **bare minimum**. This example inside method.
2. We should always try to **reduce** the **critical section** to be `synchorinized` rather than `synchorinize` whole method.  
    - With this, we can execute more code **concurrently** and **less code** needs to be waited by the other threads.

- Below the example where we are **blocking**, for the **specified** code section! We just modify the previous example, main changes:
    - First we create the **Lock Object**:
    ````
    // The lock Object!
    Object lock = new Object();
    ````
    - `public  void decrement()`:
    ````
    public  void decrement() {
                synchronized (this.lock){
                    items--;
                }
            }
    ````
    - `public void increment()`:
    ````
    public void increment() {
            synchronized (this.lock){
                items++;
            }
        }
    ````
    - `public int getItems()`:
    ````
        public int getItems() {
            synchronized (this.lock){
                return items;
            }
        }
    ````

<div align="center">
    <img src="Using_Synchronized_As_Lock_With_Multiple_Blocking_Objects_Code_Example.gif" width="700" alt="Threads resource"/>
</div>

1. We can see that we are having **consistent** results with the **blocking separate codes**.
<details>
<summary id="The synchronized block" open="true"> <b>We are using the synchronized for blocking the some parts of critical section!</b> </summary>

````Java
/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * Resource Sharing & Introduction to Critical Sections
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        decrementingThread.join();
        incrementingThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;

        // The lock Object!
        Object lock = new Object();

        public void increment() {
            synchronized (this.lock){
                items++;
            }
        }

        public  void decrement() {
            synchronized (this.lock){
                items--;
            }
        }

        public int getItems() {
            synchronized (this.lock){
                return items;
            }
        }
    }
}
````
</details>

- Selvitä miksi tässä pitää käyttää synzhronized sanaa.

> [!TIP]
> *"Synchronized block is **Reentrant**
**A thread cannot prevent itself from entering a critical section**"*

<div align="center">
    <img src="Synchorinized_Block_Is_Reentrant.PNG" width="700" alt="Threads resource"/>
</div>

1. `Reentrant` in **Java context**: *Means that the same thread can enter a synchronized block or method it already holds the lock on*!

<div align="center">
    <img src="Synchronized_Threads_Are_Reentrant_In_This_Example_Accesssing_Multiple_Critical_Sections.PNG" width="700" alt="Threads resource"/>
</div>

1. In other words, the `Thread A` is able to access, both `synchronized` methods, while still proceeding on the other `synchronized` method.
    - Thread **cannot prevent itself** to access another critical section!

<div align="center">
    <img src="Critical_Section_Summary.PNG" width="700" alt="Threads resource"/>
</div>

# Quiz 06: Critical Section & Synchronization.

<details>
<summary id="Thread progress
" open="true"> <b>Question 01.</b> </summary>

````yaml
Question 01:
Which statement is correct?
````

````Java
public class Main {
   public static void main(String [] args) {
        SharedClass sharedObject = new SharedClass();
 
        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });
 
        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });
 
        thread1.start();
        thread2.start();
    }
 
    static class SharedClass {
        private int counter = 0;
 
        public synchronized void increment() {
            this.counter++;
        }
    }
}
````

- My answer:

<div align="center">
    <img src="Quiz 06/Q1.PNG" width="500"/>
</div>

1. The one **thread** can access **locked object** at the time. Since it was using the `synchronized` keyword in the method signature.

</details>

<details>

<summary id="Thread progress
" open="true"> <b>Question 02.</b> </summary>

````yaml
Question 02:
Which one is true?
````

````Java
public class Main {
    public static void main(String [] args) {
        SharedClass sharedObject = new SharedClass();
 
        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });
 
        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedObject.decrement();
            }
        });
 
        thread1.start();
        thread2.start();
    }
 
    static class SharedClass {
        private int counter = 0;
 
        public synchronized void increment() {
            this.counter++;
        }
 
        public synchronized void decrement() {
            this.counter--;
        }
    }
}
````

- My answer:

<div align="center">
    <img src="Quiz 06/Q2.PNG" width="500"/>
</div>

1. Since the `sharedObject` is shared and the `synchronized` is behaving like the `synchronized(this)` for locking the class `SharedClass`.

</details>

<details>

<summary id="Thread progress
" open="true"> <b>Question 03.</b> </summary>

````yaml
Question 03:

````

````Java


````

- My answer:

<div align="center">
    <img src="Quiz 06/Q3.PNG" width="500"/>
</div>

1.
</details>

<details>

<summary id="Thread progress
" open="true"> <b>Question 04.</b> </summary>

````yaml
Question 04:

````

````Java


````

- My answer:

<div align="center">
    <img src="Quiz 06/Q4.PNG" width="500"/>
</div>

1.

</details>




# Atomic Operations, Volatile & Metrics Practical Example.

# Quiz 7: Atomic Operations, Volatile & Metrics Practical Example.

# Coding Exercise 3: Min - Max Metrics.

# Min - Max Metrics - Solution.

# Race Conditions & Data Races.

# Quiz 8: Data Races.

# Locking Strategies & Deadlocks.

# Quiz 9: Locking Strategies & Deadlocks.
