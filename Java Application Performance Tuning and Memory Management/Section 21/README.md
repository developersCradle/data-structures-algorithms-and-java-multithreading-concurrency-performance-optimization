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

1. How big it is from begging.
    - **Size** of array is always power of **two**, so size of array will be `2^19 = 524288`. So array of is at least `500000`, in this case it will be `524288`!
2. Load Factor, how full it's should get, until it resizes.

<img src="loadFactorInDebug.JPG" alt="picture of the course" width="500"/>

1. We can see the load factor in **debug** mode.

- In general, getting and setting stuff to `HashMap` pretty fast! 

> **HashMap** stores and retrieves entries in constant time **O(1)**.
- Test program for `1000 000` of items.

```
package hashMapExample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {


	    public static void main(String[] args) {

	        Date start = new Date();

	        Map<Integer, Book> books = new HashMap<Integer, Book>();
	        for (int i = 0; i < 1000000; i++) {
	            books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
	        }


	        Date end = new Date();
	        System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	    }
	}


```

- For me this took `Elapsed time was 707 ms.`

- We experiment the same with **initial size** with **500000**, this reduces need for **re-sizing**.
    - Example below:

```

package hashMapExample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {


	    public static void main(String[] args) {

	        Date start = new Date();

	        Map<Integer, Book> books = new HashMap<Integer, Book>(500000);
	        for (int i = 0; i < 1000000; i++) {
	            books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
	        }


	        Date end = new Date();
	        System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	    }
	}


```

- This time it took `Elapsed time was 515 ms.`.

- Let's try inputting **Load factor** to `0.9f`.
    - Example code below:

```
package hashMapExample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {


	    public static void main(String[] args) {

	        Date start = new Date();

	        Map<Integer, Book> books = new HashMap<Integer, Book>(500000, 0.9f);
	        for (int i = 0; i < 1000000; i++) {
	            books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
	        }


	        Date end = new Date();
	        System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	    }
	}


```

- This time it took `Elapsed time was 507 ms.`.

> [!IMPORTANT]
> To find the best portion for performance, one can experiment with **initial size** and the **Load Factor**.

- Don't put too big number for **HashMap**. It will take too much **memory** and one would never use the full size of **HashMap**.

# 112. HashMap Performance.

<img src="hashMapFirstAndLast.JPG" alt="picture of the course" width="500">

- Case wants to `retrieve` Book from its `key`.

1. **Java** wants to calculate of the key for 
