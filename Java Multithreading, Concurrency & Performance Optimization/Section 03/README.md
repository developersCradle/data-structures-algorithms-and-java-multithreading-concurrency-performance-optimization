# Chapter 03 - Threading Fundamentals - Thread Coordination.

Threading Fundamentals - Thread Coordination.

# What I learned.

# Thread Termination & Daemon Threads

<div align="center">
    <img src="WeStartFromTheThreadTermination.PNG"  alt="Java threads" width="500"/>
</div>

1. Why need to **start** and **stop** the **thread**.

<div align="center">
    <img src="ThreadTerminationWhenAndWhy.PNG"  alt="Java threads" width="500"/>
</div>

1. Thread consumer **resources**, such as:
    - Memory and kernel resources.
    - CPU cycles and cache memory.
- Also, if the **Thread** has finished its job, we would want to **clean up** its resources. 
2. One reason to **terminate** **thread** is if its:
    - It's not **responding**!
    - The query is **running too long**!
3. We cannot **end** the **Application** if there is threads running.

<div align="center">
    <img src="WeStartFromTheThreadTermination.PNG"  alt="Java threads" width="500"/>
</div>

1. `Thread.interupt()`.

<div align="center">
    <img src="threadInterupts.PNG"  alt="Java threads" width="500"/>
</div>

1. We can send interrupt from the **Thread A** to **Thread B** using `Thread.interrupt()`!

<div align="center">
    <img src="whenTheInteruptIsFine.PNG"  alt="Java threads" width="500"/>
</div>

1. If the **Thread** which we are trying to **interrupt** is running method that has throws `InterruptedException`. [InterruptedException](https://docs.oracle.com/javase/8/docs/api/java/lang/InterruptedException.html)
2. If this handled **explicitly**.

- When using the following `Thread.sleep(500000);`.
    - Is forcing to handle the `InterruptedException` in the thread. 

<div align="center">
    <img src="threadSleeping.PNG"  alt="Java threads" width="500"/>
</div>

1. One can see the `SLEEPING` status at the **Thread** debugger tab. 

- We can raise the **interrupt**, with following: `thread.interrupt();`.
    - The **main thread** interrupts the Blocking Thread.

````
/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * Thread Termination & Daemon Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {
    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.setName("Blocking Thread");

        thread.start();

        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(500000);
                System.out.println("Finished");
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }
}

````

- We will be getting followings logs: 

````
Connected to the target VM, address: '127.0.0.1:63604', transport: 'socket'
Existing blocking thread
Disconnected from the target VM, address: '127.0.0.1:63604', transport: 'socket'

Process finished with exit code 0
````

# Quiz 3: Thread Termination & Daemon Threads

# Joining Threads

# Coding Exercise 2: Multithreaded Calculation

# Multithreaded Calculation - Solution
