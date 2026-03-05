# Section 16: Hash Tables.

Hash Tables.

# What I learned.

# Hash Table: Intro.

<div align="center">
    <img src="Hash_Tables_Intro.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. We are checking **Hash Tables**!

<div align="center">
    <img src="Hash_Table.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We have address space!
    - This will hold **key-value** pairs.
2. This is **key-value** pair!
3. This represented **hash method**!

<div align="center">
    <img src="Hashing_Function_In_Progress.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. Key-value pair, the **key**, the **hash function** is run on the **key**, not the value.
    - Hence, its ran against the `"nails"`.
2. It will give the **address** based on the **key**. In this case its `2`. The **value** is going to be stored there! 

<div align="center">
    <img src="Hashing_Table_Is_One_Way.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. The **hash table** is only **one way**!
    - One can only go in one way!

<div align="center">
    <img src="Deterministics_Tables.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. This is **deterministic**, meaning the outcome for same input is **always** the sane!

- So, **hash tables**:
    - Deterministic!
    - One way!

<div align="center">
    <img src="Inserting_Data_In_To__THe_Same_Id_Where_Collision_Happens.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We are **set**:ing values with our own `set(String key, int value)` implementation!
2. We get **collision**, when there are **two values** is being inserted in same **key**!
    - There are multiple ways to store values with same **key**!

<div align="center">
    <img src="Getting_Data_From_Hash_Table.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We can implement **get** data. If there are multiple values in one **storage**, we need iterate over the **key values**!

# HT: Collisions.

<div align="center">
    <img src="Collisions_Intro.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="600"/>
</div>

1. How we are dealing with the **collisions**.

<div align="center">
    <img src="Collisions_Seperate_Chaining.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. One way to deal, with **multiple values** being in one **storage box**, this is called **Separate Chaining**!
    - Even if there is value already there!

<div align="center">
    <img src="Linear_Probing.gif"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. One another way, is if it does not fit one **storage box**, it will go into **next** one.
    - This is called **Linear Probing**, which is one of the types **Open Addressing**.

- These **two** are the **most popular** ones, when dealing with **collisions**:
    - **Linear Probing** and the **Separate Chaining**.

<div align="center">
    <img src="Seperate_Chaining_Implementation_In_Linked_Lists.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. We are using **Linked List** dealing with separate chaining, to fit multiple **key-value** into one **storage box**.

# HT: Constructor.

<div align="center">
    <img src="Hash_Table_Is_Array_Of_References.PNG"  alt="Java Data Structures and Algorithms plus LEETCODE Exercises" width="500"/>
</div>

1. Notice that these are **array** of **references** to the **Nodes**!
2. This is size `7`.


# HT: Hash Method.

# HT: Set.

# HT: Get.

# HT: Keys.

# HT: Big O.

# HT: Interview Question.

# Quiz 5: Hash Table Big O.





