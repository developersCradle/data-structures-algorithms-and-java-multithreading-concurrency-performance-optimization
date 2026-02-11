# Section 02: Just In Time Compilation and the Code Cache.

Just In Time Compilation and the Code Cache.

# What I learned.

# What is bytecode?

<div align="center">
    <img src="Chapter_02_JIT_Compilation.PNG"  alt="Java threads." width="700"/>
</div>

1. We will be looking what happens, when **JVM** runs the code!

<div align="center">
    <img src="What_Happens_In_Jvm.PNG"  alt="Java threads." width="700"/>
</div>

1. `Main.java` gets compiled into `Main.class`.
2. **JVM** runs the **byte code**!
    - We are saying, that **JVM** is interpreting this **byte code** at runtime!

- This **byte code** can be run multiple platform where there is **JVM** installed!

- **JVM** is not simply interpreter!
    - **JVM** contains **features** and **algorithms** to enhance the speed of running the **byte code**!

<div align="center">
    <img src="Example_Of_Other_Interpretented_Language.gif"  alt="Java threads." width="700"/>
</div>

1. **PHP**, is not complied, but interpretented at runtime with the **Apache web server**!
    - Codes are looked at and executed as it is needed!

- **JVM** is asked to run **Java byte code**.
    - As result, any language which can be **compiled** into **JVM** compatible byte code, can be ran in **JVM**!
        - *Kotlin*.
        - *Scala*.
        - *Groovy*.
        - *Clojure*.
        - *JRuby*.
        - *Jython*.
    - They all compile to **JVM** bytecode.

> [!NOTE]
> We will be comparing different **byte code** from different languages!

# The concept of "Just In Time Compilation"

<div align="center">
    <img src="JVM_Bytecode_Running.gif"  alt="Java threads." width="700"/>
</div>


# Introducing the first example project

# Finding out which methods are being compiled in our applications

# The C1 and C2 Compilers and logging the compilation activity

# Tuning the code cache size

# Remotely monitoring the code cache with
