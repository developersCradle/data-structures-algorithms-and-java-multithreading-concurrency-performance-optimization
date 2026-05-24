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

<div align="center">
    <img src="ReetrantLock_Why_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. We can enforce **fairness** for the `ReentrantLock`!

# ReentrantLock Part 2 – User Interface Application Example.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

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
