# Chapter 05 - Data Sharing Between Threads.

Data Sharing Between Threads.

# What I learned.

# Stack & Heap Memory Regions.

<div align="center">
    <img src="What_We_Will_Learn_In_Data_Sharing.PNG" width="700"/>
</div>

<div align="center">
    <img src="What_Is_The_Stack.PNG" width="700"/>
</div>

1. Remember the **stack**, what we were discussing before.

<div align="center">
    <img src="What_Is_The_Stack_Information.PNG" width="700"/>
</div>

1. *Memory Region*:
    - Methods are called.
        - Every time a method/function is invoked, a **stack frame** is pushed onto the stack.
        - When the method returns, its stack frame is popped off.
    - When the argument is **passed into function**, It's passed into the **stack**.
    - All the **local variables** are stored in the **stack**.
2. Instruction Pointer (Program Counter) → the exact instruction currently being executed. 

<div align="center">
    <img src="What_Is_The_Stack_Inside.PNG" width="700"/>
</div>

1. As soon as the tread jumps into **method**, the space is allocated in the **Stack**. This space is called **Stack Frame**.
2. Arguments are pushed on the stack, as soon as they appear. 

# Quiz 5: Stack & Heap Memory Regions.

# Resource Sharing & Introduction to Critical Sections.
