# Chapter 06 - Bonus Chapter. ✅

Bonus Chapter.

# What I learned.

# Method Binding + Demo. ✅

<div 
    align="center">
        <img 
        src="Method_Binding_Intro.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

1. We will be checking method binding!

<div 
    align="center">
        <img 
        src="Method_Binding.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

1. **Method Binding** is act of binding the method **implementation** to the method **definition**!
2. **Method declaration** is called **method signature binding**! 
3. The **implementation** is called **method implementation binding**!

<div 
    align="center">
        <img 
        src="Method_Signature_Binding.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

**Compiler verifies** whether the reference type contains or inherits a method declaration that matches the name and parameter types you are trying to call and writes to byte that to byte code!

- Example of the **reference type** and **object type**: `Animal myPet = new Dog();`.
    - **Reference Type**: `Animal`.
    - Runtime **Object Type**: `Dog`.

<div 
    align="center">
        <img 
        src="Method_Implementation_Binding.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

1. Depending on the **type of method**, implementation binding happens in one of **two places**:
    - At Compile Time (by the **Compiler**).
        - If the **method is the static**!
    - At Runtime (by the **JVM**).
        - If the method is **instance method**!

<div 
    align="center">
        <img 
        src="Static_Vs_Instance.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

1. **Early Binding** (Compile-Time Binding): Applied to **static methods**. It's called *"early"* because the compiler locks in the **exact method implementation** before the program ever runs
2. **Late Binding**/**Runtime Binding**: Applied to instance methods. It's called *"late"* because the binding is delayed **until the program is running**, allowing the JVM to look at the actual object in memory and decide which method version to invoke. 

<div 
    align="center">
        <img 
        src="Fields_Are_Early_Binded.PNG"  
        alt="Java JVM course!" 
        width="400"
        />
</div>

1. **Instance Fields** are **early blinded**.
    - While, **Instance Methods** use **late binding** (also known as runtime binding or dynamic binding)!

- We will be experimenting with following **Java code**!

````Java
//package com.semanticsquare.oop;

public class User {
   public int id = 1;
	
   public void printUserType() {
	   System.out.println("User");
   }
   
   public void saveWebLink() {
	   System.out.println("User: saveWebLink");
	   //postAReview();
   }
   public Review postAReview(String reviewText) {
	   System.out.println("User: postAReview");
	   Review review = new Review(reviewText);
	   return review;
   }
   
   // Method binding demo
   public static void staticMethod() {
   }
   
   public void instanceMethod(double d) {
      System.out.println("User: instanceMethod");
   }
   public void instanceMethod(User u) {
      System.out.println("User: instanceMethod");
   }
}
````

- The test case here:

````Java
//package com.semanticsquare.oop;

public class UserTest {
	
	//public void printUserType(User u) {
	//    u.printUserType();
	//}
	
	//public void approveReview(Staff s) {
	//	if (s instanceof Editor) {
	//		((Editor) s).approveReview(); 
    //    } else {
    //    	System.out.println("Invalid object passed!!");
    //    }
	//}
	
	public static void main(String[] args) {
		// Part 1
		/*User user = new User();
		User staff = new Staff();
		User editor = new Editor();*/
		
		//staff.postAReview("");
		
		//((Staff)staff).printId();
				
		/*UserTest ut = new UserTest();
		ut.printUserType(user);
		ut.printUserType(staff);
		ut.printUserType(editor);*/
		
		// Part 2
		//editor.approveReview();
		//editor.postAReview("");
		//editor.saveWebLink();	
		
		// Casting & instanceof demo
		//UserTest ut = new UserTest();
		//ut.approveReview(new Staff());
		//ut.approveReview(new Editor());		
		
		// Method binding demo
		User staff = new Staff();
		staff.staticMethod(); // part 1
		staff.postAReview("");
		//staff.instanceMethod(10); // part 2
		//staff.instanceMethod(new Staff());
	}
}
````

- We are using the **Java Disassembler** called `javap`!
    - One can check the [documentation](https://docs.oracle.com/en/java/javase/21/docs/specs/man/javap.html) link!
    - The command for **outputting information** is `javap -v UserTest.class`
        - For the `v = verbose (detailed output)`!

- Let's look for the **Java code**:
    ````Java
    staff.staticMethod(); // Part 01.
    ````
- Let's brake it down by line:
    - `10: invokestatic  #34                 // Method com/semanticsquare/oop/User.staticMethod:()V`.
        - `invokestatic` is VM instruction for **static method**.
        - `#34` is the **index number** of an entry in the constant pool.
            - This will be referring into the **Constant Pool**: 
                - `#34 = Methodref          #8.#35         // com/semanticsquare/oop/User.staticMethod:()V`.
                    - This in hence, will refer to the indexes `#8.#35` in **Constant Pool**! 
        - `// Method com/semanticsquare/oop/User.staticMethod:()V` The is the comment made for the human, explaining it.
        - `:()V` mean there are **no arguments** to the function and it returns **void**!
- `staff.postAReview("");`
> [!NOTE]
> 📝 The `constant pool` is where the **references** and **constants** used by the **bytecode** are stored. 📝

- Constant Pool of the class.
    ````Cmd
    Constant pool:
    #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
    #2 = Class              #4             // java/lang/Object
    #3 = NameAndType        #5:#6          // "<init>":()V
    #4 = Utf8               java/lang/Object
    #5 = Utf8               <init>
    #6 = Utf8               ()V
    #7 = Methodref          #8.#9          // com/semanticsquare/oop/User.printUserType:()V
    #8 = Class              #10            // com/semanticsquare/oop/User
    #9 = NameAndType        #11:#6         // printUserType:()V
    #10 = Utf8               com/semanticsquare/oop/User
    #11 = Utf8               printUserType
    #12 = Class              #13            // com/semanticsquare/oop/Editor
    #13 = Utf8               com/semanticsquare/oop/Editor
    #14 = Methodref          #12.#15        // com/semanticsquare/oop/Editor.approveReview:()V
    #15 = NameAndType        #16:#6         // approveReview:()V
    #16 = Utf8               approveReview
    #17 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
    #18 = Class              #20            // java/lang/System
    #19 = NameAndType        #21:#22        // out:Ljava/io/PrintStream;
    #20 = Utf8               java/lang/System
    #21 = Utf8               out
    #22 = Utf8               Ljava/io/PrintStream;
    #23 = String             #24            // Invalid object passed!!
    #24 = Utf8               Invalid object passed!!
    #25 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
    #26 = Class              #28            // java/io/PrintStream
    #27 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
    #28 = Utf8               java/io/PrintStream
    #29 = Utf8               println
    #30 = Utf8               (Ljava/lang/String;)V
    #31 = Class              #32            // com/semanticsquare/oop/Staff
    #32 = Utf8               com/semanticsquare/oop/Staff
    #33 = Methodref          #31.#3         // com/semanticsquare/oop/Staff."<init>":()V
    #34 = Methodref          #8.#35         // com/semanticsquare/oop/User.staticMethod:()V
    #35 = NameAndType        #36:#6         // staticMethod:()V
    #36 = Utf8               staticMethod
    #37 = String             #38            //
    #38 = Utf8
    #39 = Methodref          #8.#40         // com/semanticsquare/oop/User.postAReview:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
    #40 = NameAndType        #41:#42        // postAReview:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
    #41 = Utf8               postAReview
    #42 = Utf8               (Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
    #43 = Class              #44            // com/semanticsquare/oop/UserTest
    #44 = Utf8               com/semanticsquare/oop/UserTest
    #45 = Utf8               Code
    #46 = Utf8               LineNumberTable
    #47 = Utf8               (Lcom/semanticsquare/oop/User;)V
    #48 = Utf8               (Lcom/semanticsquare/oop/Staff;)V
    #49 = Utf8               StackMapTable
    #50 = Utf8               main
    #51 = Utf8               ([Ljava/lang/String;)V
    #52 = Utf8               SourceFile
    #53 = Utf8               UserTest.java
    ````

- Let's look for the Java code:
    - `staff.postAReview("");`.

- Lest

````Cmd
$ javap -v UserTest.class
Classfile /C:/Users/ScoopiDoo/Desktop/git projektit/data-structures-algorithms-a
nd-java-multithreading-concurrency-performance-optimization/A Comprehensive Intr
oduction to Java Virtual Machine (JVM)/Section 06/OOP/UserTest.class
  Last modified 10 Nov 2026; size 964 bytes
  SHA-256 checksum c0a62b1025efeea423b69877557c59238a7d0929e23e3a0b9e525863f26a8
1f9
  Compiled from "UserTest.java"
public class com.semanticsquare.oop.UserTest
  minor version: 0
  major version: 65
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #43                         // com/semanticsquare/oop/UserTest
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 4, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Methodref          #8.#9          // com/semanticsquare/oop/User.printUs
erType:()V
   #8 = Class              #10            // com/semanticsquare/oop/User
   #9 = NameAndType        #11:#6         // printUserType:()V
  #10 = Utf8               com/semanticsquare/oop/User
  #11 = Utf8               printUserType
  #12 = Class              #13            // com/semanticsquare/oop/Editor
  #13 = Utf8               com/semanticsquare/oop/Editor
  #14 = Methodref          #12.#15        // com/semanticsquare/oop/Editor.appro
veReview:()V
  #15 = NameAndType        #16:#6         // approveReview:()V
  #16 = Utf8               approveReview
  #17 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/Print
Stream;
  #18 = Class              #20            // java/lang/System
  #19 = NameAndType        #21:#22        // out:Ljava/io/PrintStream;
  #20 = Utf8               java/lang/System
  #21 = Utf8               out
  #22 = Utf8               Ljava/io/PrintStream;
  #23 = String             #24            // Invalid object passed!!
  #24 = Utf8               Invalid object passed!!
  #25 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/
lang/String;)V
  #26 = Class              #28            // java/io/PrintStream
  #27 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
  #28 = Utf8               java/io/PrintStream
  #29 = Utf8               println
  #30 = Utf8               (Ljava/lang/String;)V
  #31 = Class              #32            // com/semanticsquare/oop/Staff
  #32 = Utf8               com/semanticsquare/oop/Staff
  #33 = Methodref          #31.#3         // com/semanticsquare/oop/Staff."<init
>":()V
  #34 = Methodref          #8.#35         // com/semanticsquare/oop/User.staticM
ethod:()V
  #35 = NameAndType        #36:#6         // staticMethod:()V
  #36 = Utf8               staticMethod
  #37 = String             #38            //
  #38 = Utf8
  #39 = Methodref          #8.#40         // com/semanticsquare/oop/User.postARe
view:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
  #40 = NameAndType        #41:#42        // postAReview:(Ljava/lang/String;)Lco
m/semanticsquare/oop/Review;
  #41 = Utf8               postAReview
  #42 = Utf8               (Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
  #43 = Class              #44            // com/semanticsquare/oop/UserTest
  #44 = Utf8               com/semanticsquare/oop/UserTest
  #45 = Utf8               Code
  #46 = Utf8               LineNumberTable
  #47 = Utf8               (Lcom/semanticsquare/oop/User;)V
  #48 = Utf8               (Lcom/semanticsquare/oop/Staff;)V
  #49 = Utf8               StackMapTable
  #50 = Utf8               main
  #51 = Utf8               ([Ljava/lang/String;)V
  #52 = Utf8               SourceFile
  #53 = Utf8               UserTest.java
{
  public com.semanticsquare.oop.UserTest();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>
":()V
         4: return
      LineNumberTable:
        line 3: 0

  public void printUserType(com.semanticsquare.oop.User);
    descriptor: (Lcom/semanticsquare/oop/User;)V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=2, args_size=2
         0: aload_1
         1: invokevirtual #7                  // Method com/semanticsquare/oop/U
ser.printUserType:()V
         4: return
      LineNumberTable:
        line 6: 0
        line 7: 4

  public void approveReview(com.semanticsquare.oop.Staff);
    descriptor: (Lcom/semanticsquare/oop/Staff;)V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: aload_1
         1: instanceof    #12                 // class com/semanticsquare/oop/Ed
itor
         4: ifeq          17
         7: aload_1
         8: checkcast     #12                 // class com/semanticsquare/oop/Ed
itor
        11: invokevirtual #14                 // Method com/semanticsquare/oop/E
ditor.approveReview:()V
        14: goto          25
        17: getstatic     #17                 // Field java/lang/System.out:Ljav
a/io/PrintStream;
        20: ldc           #23                 // String Invalid object passed!!
        22: invokevirtual #25                 // Method java/io/PrintStream.prin
tln:(Ljava/lang/String;)V
        25: return
      LineNumberTable:
        line 10: 0
        line 11: 7
        line 13: 17
        line 15: 25
      StackMapTable: number_of_entries = 2
        frame_type = 17 /* same */
        frame_type = 7 /* same */

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #31                 // class com/semanticsquare/oop/St
aff
         3: dup
         4: invokespecial #33                 // Method com/semanticsquare/oop/S
taff."<init>":()V
         7: astore_1
         8: aload_1
         9: pop
        10: invokestatic  #34                 // Method com/semanticsquare/oop/U
ser.staticMethod:()V
        13: aload_1
        14: ldc           #37                 // String
        16: invokevirtual #39                 // Method com/semanticsquare/oop/U
ser.postAReview:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
        19: pop
        20: return
      LineNumberTable:
        line 44: 0
        line 45: 8
        line 46: 13
        line 49: 20
}
SourceFile: "UserTest.java"
````

<details>
<summary 
id="#"
open="true"> <b>Output of the javap -v UserTest.class
!</b> </summary>

````Cmd
$ javap -v UserTest.class
Classfile /C:/Users/ScoopiDoo/Desktop/git projektit/data-structures-algorithms-a
nd-java-multithreading-concurrency-performance-optimization/A Comprehensive Intr
oduction to Java Virtual Machine (JVM)/Section 06/OOP/UserTest.class
  Last modified 10 Nov 2026; size 964 bytes
  SHA-256 checksum c0a62b1025efeea423b69877557c59238a7d0929e23e3a0b9e525863f26a8
1f9
  Compiled from "UserTest.java"
public class com.semanticsquare.oop.UserTest
  minor version: 0
  major version: 65
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #43                         // com/semanticsquare/oop/UserTest
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 4, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Methodref          #8.#9          // com/semanticsquare/oop/User.printUs
erType:()V
   #8 = Class              #10            // com/semanticsquare/oop/User
   #9 = NameAndType        #11:#6         // printUserType:()V
  #10 = Utf8               com/semanticsquare/oop/User
  #11 = Utf8               printUserType
  #12 = Class              #13            // com/semanticsquare/oop/Editor
  #13 = Utf8               com/semanticsquare/oop/Editor
  #14 = Methodref          #12.#15        // com/semanticsquare/oop/Editor.appro
veReview:()V
  #15 = NameAndType        #16:#6         // approveReview:()V
  #16 = Utf8               approveReview
  #17 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/Print
Stream;
  #18 = Class              #20            // java/lang/System
  #19 = NameAndType        #21:#22        // out:Ljava/io/PrintStream;
  #20 = Utf8               java/lang/System
  #21 = Utf8               out
  #22 = Utf8               Ljava/io/PrintStream;
  #23 = String             #24            // Invalid object passed!!
  #24 = Utf8               Invalid object passed!!
  #25 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/
lang/String;)V
  #26 = Class              #28            // java/io/PrintStream
  #27 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
  #28 = Utf8               java/io/PrintStream
  #29 = Utf8               println
  #30 = Utf8               (Ljava/lang/String;)V
  #31 = Class              #32            // com/semanticsquare/oop/Staff
  #32 = Utf8               com/semanticsquare/oop/Staff
  #33 = Methodref          #31.#3         // com/semanticsquare/oop/Staff."<init
>":()V
  #34 = Methodref          #8.#35         // com/semanticsquare/oop/User.staticM
ethod:()V
  #35 = NameAndType        #36:#6         // staticMethod:()V
  #36 = Utf8               staticMethod
  #37 = String             #38            //
  #38 = Utf8
  #39 = Methodref          #8.#40         // com/semanticsquare/oop/User.postARe
view:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
  #40 = NameAndType        #41:#42        // postAReview:(Ljava/lang/String;)Lco
m/semanticsquare/oop/Review;
  #41 = Utf8               postAReview
  #42 = Utf8               (Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
  #43 = Class              #44            // com/semanticsquare/oop/UserTest
  #44 = Utf8               com/semanticsquare/oop/UserTest
  #45 = Utf8               Code
  #46 = Utf8               LineNumberTable
  #47 = Utf8               (Lcom/semanticsquare/oop/User;)V
  #48 = Utf8               (Lcom/semanticsquare/oop/Staff;)V
  #49 = Utf8               StackMapTable
  #50 = Utf8               main
  #51 = Utf8               ([Ljava/lang/String;)V
  #52 = Utf8               SourceFile
  #53 = Utf8               UserTest.java
{
  public com.semanticsquare.oop.UserTest();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>
":()V
         4: return
      LineNumberTable:
        line 3: 0

  public void printUserType(com.semanticsquare.oop.User);
    descriptor: (Lcom/semanticsquare/oop/User;)V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=2, args_size=2
         0: aload_1
         1: invokevirtual #7                  // Method com/semanticsquare/oop/U
ser.printUserType:()V
         4: return
      LineNumberTable:
        line 6: 0
        line 7: 4

  public void approveReview(com.semanticsquare.oop.Staff);
    descriptor: (Lcom/semanticsquare/oop/Staff;)V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: aload_1
         1: instanceof    #12                 // class com/semanticsquare/oop/Ed
itor
         4: ifeq          17
         7: aload_1
         8: checkcast     #12                 // class com/semanticsquare/oop/Ed
itor
        11: invokevirtual #14                 // Method com/semanticsquare/oop/E
ditor.approveReview:()V
        14: goto          25
        17: getstatic     #17                 // Field java/lang/System.out:Ljav
a/io/PrintStream;
        20: ldc           #23                 // String Invalid object passed!!
        22: invokevirtual #25                 // Method java/io/PrintStream.prin
tln:(Ljava/lang/String;)V
        25: return
      LineNumberTable:
        line 10: 0
        line 11: 7
        line 13: 17
        line 15: 25
      StackMapTable: number_of_entries = 2
        frame_type = 17 /* same */
        frame_type = 7 /* same */

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #31                 // class com/semanticsquare/oop/St
aff
         3: dup
         4: invokespecial #33                 // Method com/semanticsquare/oop/S
taff."<init>":()V
         7: astore_1
         8: aload_1
         9: pop
        10: invokestatic  #34                 // Method com/semanticsquare/oop/U
ser.staticMethod:()V
        13: aload_1
        14: ldc           #37                 // String
        16: invokevirtual #39                 // Method com/semanticsquare/oop/U
ser.postAReview:(Ljava/lang/String;)Lcom/semanticsquare/oop/Review;
        19: pop
        20: return
      LineNumberTable:
        line 44: 0
        line 45: 8
        line 46: 13
        line 49: 20
}
SourceFile: "UserTest.java"
````

</details>



# Websites & Social Media Groups to Follow. ✅
