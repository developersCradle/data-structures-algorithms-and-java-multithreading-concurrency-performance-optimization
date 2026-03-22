# Section 05: LL: Coding Exercises.

 LL: Coding Exercises.

# What I learned.

# Coding Exercise 02: LL: Constructor.

<details>
<summary id="coding_exercise_02_ll_constructor" open="true"> <b>Coding Exercise 02: LL Constructor Exercise!</b> </summary>

<div align="center">
    <img src="Coding_Exercise_02_LL_Constructor.PNG"  alt="Coding Exercise 02 LL Constructor" width="500"/>
</div>

````Java
public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;
     
    class Node {
        int value;
        Node next;
     
        Node(int value) {
            this.value = value;
        }
    }


    //   +===================================================+
    //   |                  WRITE YOUR CODE HERE             |
    //   | Description:                                      |
    //   | - Constructor for the LinkedList class.           |
    //   | - Initializes the linked list with a single node. |
    //   |                                                   |
    //   | Parameters:                                       |
    //   | - value: The integer value of the first node in   |
    //   |   the newly created linked list.                  |
    //   |                                                   |
    //   | Behavior:                                         |
    //   | - A new Node is created with the given value.     |
    //   | - This node is set as both the head and tail of   |
    //   |   the list, indicating it is the only node in the |
    //   |   list at creation.                               |
    //   | - The length of the list is initialized to 1.     |
    //   +===================================================+


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

}
````

- **Task 02:** Create a constructor for a `LinkedList` class that initializes a new `Linked List` with a single node.
    - **Answer**: Below:

````Java
public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;
     
    class Node {
        int value;
        Node next;
     
        Node(int value) {
            this.value = value;
        }
    }



    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
}
````

</details>

# Coding Exercise 03: LL: Append.

# Coding Exercise 04: LL: Remove Last.

# Coding Exercise 05: LL: Prepend.

# Coding Exercise 06: LL: Remove First.

# Coding Exercise 07: LL: Get.

# Coding Exercise 08: LL: Set.

# Coding Exercise 09: LL: Insert.

# Coding Exercise 10: LL: Remove.

# Coding Exercise 11: LL: Reverse.