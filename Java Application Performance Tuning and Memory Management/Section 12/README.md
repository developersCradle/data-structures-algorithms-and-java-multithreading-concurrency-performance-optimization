# Chapter 12 - Monitoring the Heap.

Monitoring the Heap.

# What I learned.

# What is a soft leak?

- We will be visualizing how the **JVM** is reserving the memory!

<div align="center">
    <img src="Memory_Leak.PNG"  alt="Java threads." width="700"/>
</div>

1. The memory leaks should **not be** possible:
    - Java has **G**arbage **C**ollection (**GC**), which automatically removes objects from memory when they are no longer being used!

 2. **Soft leaks** – when an object remains referenced when no longer needed:
    - A soft leak (often just called a memory leak in Java) happens when objects are **still referenced somewhere**, even though your program **no longer needs them**.
        - This can be **problematic** in **long-running** applications!
            - Since the object is still referenced, it remains in the **Java Heap**, so the Garbage Collector cannot remove it and the memory stays reserved.





# Introducing (J)VisualVM.

# Monitoring the size of the heap over time.

# Fixing the problem and checking the heap size.