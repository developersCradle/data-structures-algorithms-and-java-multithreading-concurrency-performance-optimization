# Chapter 05 - Future and CompletableFuture.

Future and CompletableFuture.

# What I learned.

# Evolution of Concurrency APIs in Java.

<div align="center">
    <img src="Evolution_Of_Concurrency_APIs.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. **Threads** were introduced in **Java 1** in 1996!
2. There was **multicore** support in **Java 5** in 2004!
3. **Java 7** brought **Data Parallelism** to the language in 2011!
4. **Java 8** functional programming world in 2014!
5. **Java 21** introduced the **Virtual Threads** in 2023!

# Parallelism VS Concurrency.

<div align="center">
    <img src="Concurrency.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>


1. **Concurrency** is the ability of a system to make progress on two or more **independent** tasks during the same period of time

<div align="center">
    <img src="Concurrency_Example.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. We will be having **two threads**!
2. We start the **threads**.
3. We make them wait, until they are finished!
4. We will be getting the *Hello Wordl* out of these operations!
5. The **Shared Object** is root of all evil!

<div align="center">
    <img src="Parallelism.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

0. **Parallelism** is the simultaneous execution of two or more tasks or subtasks on multiple processors or CPU cores.
1. **First** is to brake the task into **subtask's**. 
    - This can be smallest as possible. This is called **forking**!
2. We execute the task!
3. We will be **.join(...)**!

<div align="center">
    <img src="Parallelism_Example.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. We will be having the **parallelism** example using the **transformation** operation!

<div align="center">
    <img src="Parallelism_Java_Code.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. `.parallelStream()` splits a large task into **smaller subtasks**, processes them in **parallel** using multiple threads, and then **joins** the results!
2. [Multithreading,Parallel & Asynchronous Coding in Modern Java](https://www.udemy.com/course/parallel-and-asynchronous-programming-in-modern-java/)!

<div align="center">
    <img src="Concurrency_Vs_Parallism.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. **Concurrency**
    - Time →
        - **Task A**: ███__ ███__ ███
        - **Task B**: __ ███__ ███
    - The CPU switches between **Task A** and **Task B**. Only one task runs at a time, but both make progress!
2. **Parallelism**
    - Core 1: **Task A** ███████
    - Core 2: **Task B** ███████
    - **Task A** and **Task B** run simultaneously!

# Introduction to Future.

<div align="center">
    <img src="Future_And_Executor_Service.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. **Future API's** is to retrieve the result of an asynchronous task. This made it easier to return values from **Threads**!

<div align="center">
    <img src="Product_Service.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. We will be having the **product service**!
2. It will have two **services** behind it!

> [!TIP]
> `ExecutorService` is a Java framework for managing and executing threads. Instead of creating and managing threads manually, you submit tasks to `ExecutorService`, which handles the threads for you.
>    - Old way, with **Thread's APIS**:
>        ````Java
>        Thread t = new Thread(() -> {
>            System.out.println("Running...");
>        });
>        t.start();
>        
>        ````
>    - With **ExecutorService**:
>        ````Java
>        ExecutorService executor = Executors.newFixedThreadPool(2);
>        executor.submit(() -> {
>        System.out.println("Running...");
>        });
>        executor.shutdown();
>        ````

<div align="center">
    <img src="Future_And_Executor_Service_In_Code.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. Create pool of **6 worker** threads.
2. **Future** is as a promise of a **result that will be available later**.
3. These are **blocking** calls!
4. Collect are return **Product**!

# ProductService using Future API and ExecutorService.

#### ProductServiceUsingExecutor.java

````Java
package com.modernjava.future;


import com.modernjava.domain.Product;
import com.modernjava.domain.ProductInfo;
import com.modernjava.domain.Reviews;
import com.modernjava.service.ProductInfoService;
import com.modernjava.service.ReviewService;
import com.modernjava.util.LoggerUtil;

import java.util.concurrent.*;

public class ProductServiceUsingExecutor {

    static ExecutorService executorService = Executors.newFixedThreadPool(6);

    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public ProductServiceUsingExecutor(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws ExecutionException, InterruptedException, TimeoutException {

        Future<ProductInfo> productInfoFuture = executorService.submit(() -> productInfoService.retrieveProductInfo(productId));
        Future<Reviews> reviewFuture = executorService.submit(() -> reviewService.retrieveReviews(productId));

        ProductInfo productInfo = productInfoFuture.get(); // This is a  blocking call.
        //ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS);
        Reviews reviews = reviewFuture.get(); // This is a  blocking call.
        //Review review = reviewFuture.get(2, TimeUnit.SECONDS);

        return new Product(productId, productInfo, reviews);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingExecutor productService = new ProductServiceUsingExecutor(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        LoggerUtil.log("Product is " + product);
        executorService.shutdown();
    }
}
````

- These are executed as parallel!
    ````Java
    Future<ProductInfo> productInfoFuture = executorService.submit(() -> productInfoService.retrieveProductInfo(productId));
    Future<Reviews> reviewFuture = executorService.submit(() -> reviewService.retrieveReviews(productId));
    ````
- There are blocking calls, to get data!
    ````Java
    ProductInfo productInfo = productInfoFuture.get(); // This is a  blocking call.
    //ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS);
    Reviews reviews = reviewFuture.get(); // This is a  blocking call.
    ````

- We can see the **ExecutorService** is working!

<div align="center">
    <img src="Running_Tests_To_See_The_ExecutorService_Working.gif"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

- Limitation of limitations of **ExecutorService** and **Future API**. 

<div align="center">
    <img src="Limitations_Of_ExecutorService_And_Future_API.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. To get data, we need to call `.get()`. This is blocking task!
2. There is no better way to combine data!

# CompletableFuture API - ProductService using CompletableFuture API.