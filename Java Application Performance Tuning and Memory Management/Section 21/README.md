## Section 21: Chapter 21 - How Maps Work.

Section 21: Chapter 21 - How Maps Work

# What I learned.

# 109. The role of the Hashcode.

<img src="hashMapDesc.PNG" alt="picture of the course" width="600"/>

- **Hash Code**, will be connected to `HashCode`.

- `MAP` each **Key** is pointing to the **Value**.
    - These are **Unique**.

- In **HashMap** retrieving value with the **Key**, will be irrelevant regardless of the **Size** of the **HashMap**
    - Example of `retrieving value with the key`:
        - **HashMap** size of **10** items.
        - **HashMap** size of **10** items.
    - Will be the **SAME!**.

<img src="hashMapWorking.PNG" alt="picture of the course" width="500"/>

1. Will represents of the **Book**.
2. The `id` will be `key`. This could be any Object, not just **Integer**.
3. We will be having **16** books in the `HashMap`.
4. `Value` will be **Book** Object.

- When accessing the `HashMap` **Java** takes the **Key** and convert into the **Integer** value.
    - If we are using **Integer** for keys, that **fine**.
        - With **String** or **other type**, this needs to be **converted** to **Integer**. 
5. Java will do **Calculation** with the **Integer**. Calculation:
    - **Modulus** of the **key** number and with **size** of the **HashMap**.
        - This **example** will be `12`.
            - This means, this will be stored in **bucket** number `12`.

# 109. The role of the Hashcode.

- Every **Java Object** has the `hashCode()`.

<img src="hashMapWithTheString.GIF" alt="picture of the course" width="500"/>

1. Now the **Key** will be **String**.
    - In this case this we want to the **Integer** representation of the **String**. Now we can just call the **Strings** `hashCode()`.
2. Printing the `Objects` `hashCode`, with `System.out.println("Litle Woman".hashCode());`
3. `HashCode` of this Object is. In this case its **String**. 
4. Bucket number `4` is chosen for the `Little Women`.

# 110. How Hashmaps Work - part 2.

<img src="hashMap.JPG" alt="picture of the course" width="500"/>

1. There is **chance** that all **Objects** will be stored inside bucket **4**. Even thought, the **hash codes** are different, the operation yield same **bucket**.
    - So there can be multiple **objects** inside one bucket!

<img src="hashMapArray.JPG" alt="picture of the course" width="500"/>

1. Bucket contains **Linked List**(Not the Java, but similar).

- Hash has concept called **Load Factor**.
    - Default load factor is **75%** of the capacity.

- [Example of Load Factor](https://www.baeldung.com/java-hashmap-load-factor).
> The **Load factor** is the measure that decides when to increase the capacity of the Map. The default load factor is **75%** of the capacity.

<img src="loadFactor.JPG" alt="picture of the course" width="500">

1. If the **HashMap** have occupied 75% of the size, it is reconsidered to be **full!**.

<img src="hashCodeGrowing.JPG" alt="picture of the course" width="500">

1. It will **HashMap** will grow **double** its size.
    - For perspective **ArrayList** will grow **half of the column size**. 

2. When **HashMap** grows, the positions **need** to be **re-evaluated**.
    - This means, the **modulus** gives different answer, since `size` is now **double**.

# 111. Specifying the initial size and factor of a HashMap.

<img src="hashMapExample.JPG" alt="picture of the course" width="500">
