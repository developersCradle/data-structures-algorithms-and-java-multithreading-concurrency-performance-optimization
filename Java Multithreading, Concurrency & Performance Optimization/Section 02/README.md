# Chapter 02 - Threading Fundamentals - Thread Creation.

Threading Fundamentals - Thread Creation.

# What I learned.

# Tips about Coding Lectures and Debugging Instructions.

- ✅.

# Threads Creation - Part 1, Thread Capabilities & Debugging.

- We will be doing *"hello world"* of **Threads**. 

<div align="center">
    <img src="firstThread.PNG"  alt="Java threads" width="500"/>
</div>

- We can create `Thread`, where we input the `Runnable`.

````
Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in  a new thread
                System.out.println("we are now in thread "+Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });
````

# Threads Creation - Part 2, Thread Inheritance.

# Coding Exercise 1: Thread Creation - MultiExecutor.

# Thread Creation - MultiExecutor Solution.
