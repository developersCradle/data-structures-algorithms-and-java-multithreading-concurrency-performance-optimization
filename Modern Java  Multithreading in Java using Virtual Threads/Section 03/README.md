# Chapter 03: Getting Started with Java Threads (Platform Threads). 

Getting Started with Java Threads (Platform Threads).

# What I learned.

# What is a Platform Thread, Why do we need them?

<div align="center">
    <img src="Why_We_Need_Virtual_Threads.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. Threads have been existed since 1.0.
2. This will be executed from the *Main* **Thread**!

<div align="center">
    <img src="Why_We_Need_Virtaul_Threads_Second.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. There are two **main threads**:
    - Platform Threads.
    - Virtual Threads.

<div align="center">
    <img src="Executing_Java_Thread.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. There are multiple ways to create the **Threads**:
    - There is a handy way to start `Thread.ofPlatform()`.
2. From Java 21 the Java Threads are called **Platform Threads**!

<div align="center">
    <img src="Benefits_Of_An_Thread.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. This helps to use cores with **Threads**! 

# Java Installation.

- We need **Java 21**, at least!

# Base Project Setup in IntelliJ.

- Sets the base of the project!

# Lets Create Platform Threads.

- Some basic illustration of the **Platform Threads**!

````Java
package com.modernjava.threads;

import com.modernjava.util.CommonUtil;
import static com.modernjava.util.LoggerUtil.log;

public class ExploreThreads {
    public static void doSomeWork() {
        log("started doSomeWork");
        CommonUtil.sleep(1000);
        log("finished doSomeWork");

    }

    public static void main(String[] args) {
        // Gives uss instance of the platform Thread!
        var thread1 = Thread.ofPlatform().name("T1");
        var thread2 = Thread.ofPlatform().name("T2");

        thread1.start(() -> {
            log("Run task 1 in the background!");
        });

        thread2.start(() -> {
            ExploreThreads.doSomeWork();
        });

        log("Program Completed!");
    }
}
````

- Lest illustrate the **Threads**!

<div align="center">
    <img src="Platform_Thread_Working.gif"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. We can see the order is not fixed!

- If we want to have the **result** out of the Thread's.
    - We can use `.join()`, as in below:

````Java
package com.modernjava.threads;


import static com.modernjava.util.CommonUtil.sleep;
import static com.modernjava.util.LoggerUtil.log;

public class HelloWorldThreads {
    private static String result="";

    private static void hello(){
        sleep(500);
        result = result.concat("Hello");
    }
    private static void world(){
        sleep(600);
        result = result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {

        // We would like to get the output as "HelloWorld"
        var thread1 = Thread.ofPlatform().name("T1").start(HelloWorldThreads::hello);
        var thread2 = Thread.ofPlatform().name("T2").start(HelloWorldThreads::world);

        // Join, makes Thread finish before coming to main Thread!
        thread1.join();
        thread2.join();

        log("Result is: " + result);
    }
}
````

- The `HelloWorldThreads`.

````Java
package com.modernjava.threads;

import static com.modernjava.util.CommonUtil.sleep;
import static com.modernjava.util.LoggerUtil.log;

public class HelloWorldThreads {
    private static String result="";

    private static void hello(){
        sleep(500);
        result = result.concat("Hello");
    }
    private static void world(){
        sleep(600);
        result = result.concat("World");
    }
    public static void main(String[] args) throws InterruptedException {

        // We would like to get the output as "HelloWorld"
        var thread1 = Thread.ofPlatform().name("T1").start(HelloWorldThreads::hello);
        var thread2 = Thread.ofPlatform().name("T2").start(HelloWorldThreads::world);

        // Join, makes Thread finish before coming to main Thread!
        thread1.join();
        thread2.join();

        log("Result is: " + result);
    }
}
````

- We can see the returned result is being returned!

<div align="center">
    <img src="Get_Result_Out_Of_Threads.gif"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. We can see the result is `.join()` out of thread!

# Thread Internals - How it works behind the scenes?

# Thread Scalability and Blocking nature of Java Threads - Drawbacks.

# Effects of Threads in a Backend WebApplication.