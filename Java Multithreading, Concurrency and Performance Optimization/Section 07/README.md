# Chapter 07 - Advanced Locking.

Advanced Locking

# What I learned.

# ReentrantLock Part 1 – tryLock and interruptible Lock.


<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

1. We will be introducing new type of lock!

<div align="center">
    <img src="What_We_Will_Learn_Next_Is_Advanced_Locks.PNG" width="700" alt="Threads multithreading."/>
</div>

1. We will be looking at `ReetrantLock`!

<div align="center">
    <img src="ReetrantLock_Lock.PNG"  alt="Java threads." width="600"/>
</div>

1. Concept is the same as with the locking with the object!
    - Requires **explicit** locking and unlocking! 

<div align="center">
    <img src="ReetrantLock_Old_And_New_Way.PNG"  alt="Java threads." width="600"/>
</div>

1. **Left** is how we would normally lock the **Object()**!
2. **Right** how we would lock with the **ReetantLock()**!
    - `2.1`, with this we would need to **explicitly** `.lock()` and `unlock()` the object!

<div align="center">
    <img src="ReetrantLock_Disadvantage.PNG"  alt="Java threads." width="600"/>
</div>

1. After we used to lock shared object, we may **forget** to unlock it!

<div align="center">
    <img src="ReetrantLock_Disadvantage_Second_Point.PNG"  alt="Java threads." width="600"/>
</div>

1. If **exception** inside business logic, we may never get to call `.unblock()`!

<div align="center">
    <img src="ReetrantLock_Disadvantage_Second_Point_Solution.PNG"  alt="Java threads." width="600"/>
</div>

1. To fix that, we just need to use `try-catch` block!

<div align="center">
    <img src="Methods_For_ReetrantLock.PNG"  alt="Java threads." width="600"/>
</div>

- This comes very handy, when testing production code!

<div align="center">
    <img src="ReetrantLock_Why.PNG"  alt="Java threads." width="600"/>
</div>

<br>

<div align="center">
    <img src="ReetrantLock_Why_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. We can enforce **fairness** for the `ReentrantLock`!

<div align="center">
    <img src="ReentantLock_Fairness.gif"  alt="Java threads." width="600"/>
</div>

1. If there are **many threads** wanting to get **lock** on the one object!
    - There can be situation where **one thread gets lock multiple times**, where other **threads** are going to be starved!
        - In such situations, we would need to consider **fairness flag!** 

<div align="center">
    <img src="FairnessFlag.PNG"  alt="Java threads." width="600"/>
</div>

1. Using **fairness flag**, when you need it!
    - It may cause reduce throughput!

<div align="center">
    <img src="What_We_Will_Learn_Next_LockInterruptibly.PNG"  alt="Java threads." width="600"/>
</div>

1. Feature of **ReenterantLock** is `.lockInterruptibly()`.

<div align="center">
    <img src="LockInterruptibly_Motivation.PNG"  alt="Java threads." width="600"/>
</div>

1. Generally: When the **thread** is acquiring the `.lock()`, while another **thread** is currently holding lock. The caller **thread** usually gets **suspended** until the lock is released!
2. In this case calling `.interrupt()` does not help!

<div align="center">
    <img src="LockInterruptibly_Locking.PNG"  alt="Java threads." width="600"/>
</div>

1. With locking with the `.lockInterruptibly()` we are **forced** to implement the `try catch`!

<div align="center">
    <img src="LockInterruptibly_Locking_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. If we want to **stop thread** waiting for the **lock**, we can call the `.interrupt()` on the suspended **thread** and resume the `catch` block for it!
    - We could shut down tread gracefully!

<div align="center">
    <img src="LockInterruptibly_Use_Cases.PNG"  alt="Java threads." width="600"/>
</div>

1. We could use this for **Watchog** functionality.
2. When our app would exit, we could implement gracefully exit!

<div align="center">
    <img src="ReetrantLock_TryLock.PNG"  alt="Java threads." width="600"/>
</div>

1. We will go thought `.tryLock()`.

<div align="center">
    <img src="ReetrantLock_Why_To_Use.PNG"  alt="Java threads." width="600"/>
</div>

1. `.tryLock()` is trying to get the lock.

<div align="center">
    <img src="Scenario_01.PNG"  alt="Java threads." width="600"/>
</div>

1. Locking scenario for both flows are similar in locking the!

<div align="center">
    <img src="Scenario_02.PNG"  alt="Java threads." width="600"/>
</div>

1. If `.lock()` has object locked, the **tread** is suspended till its `.unlocked()`!
2. The **rest flow** is **resumed**, when the lock is unlocked.

<div align="center">
    <img src="Scenario_02_With_TryLock.PNG"  alt="Java threads." width="600"/>
</div>

1. Check is happened if the object is locked.
2. If It's locked, we can do something else!
    - We can come back later to acquire lock again!

<div align="center">
    <img src="TryLock_User_Cases.PNG"  alt="Java threads." width="600"/>
</div>

1. Suspending on the tread on a `.lock()` in real time application is unacceptable! Examples:
    - Video/Image processing
    - High Speed/Low latency trading system!
    - User Interface applications!
- These will lead application to be **unresponsible**!

<div align="center">
    <img src="Summary.PNG"  alt="Java threads." width="600"/>
</div>

# ReentrantLock Part 2 – User Interface Application Example.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

1. We will try `ReetrantLock` in real application!

<div align="center">
    <img src="ReetrantLock_TryLock_With_Real_Application.PNG"  alt="Java threads." width="600"/>
</div>

1. How and when to use `.tryLock()` in real application!

<div align="center">
    <img src="Dashboards.PNG"  alt="Java threads." width="600"/>
</div>

1. There are two dashboards!

<div align="center">
    <img src="JavaFx_Plan.PNG"  alt="Java threads." width="600"/>
</div>

1. **Thread 1**: UI application for mouse inputs!
2. **Thread 2**: Network call to assets and make update prices!
3. This is updated to the **shared resource**!

- 2:40


# Quiz 10: ReentrantLock.

# Reentrant Read-Write Lock & Database Implementation.


<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>



# Resources.


<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

# Quiz 11: Read-Write Locks.

# Coding Exercise 4: Product Reviews Service.

# Product Reviews Service – Solution.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>
