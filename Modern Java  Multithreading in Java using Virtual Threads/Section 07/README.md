# Chapter 07 - HTTP calls using Virtual Threads.

HTTP calls using Virtual Threads.

# What I learned.

# Set Up Simple WebServer.

<div align="center">
    <img src="Simple_Web_Server.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

1. This is **Simple Web Server** from **Java 18**
    - This will be serving files from **local machine**!

> [!TIP]
> `jwebserver` is a lightweight HTTP server included with the JDK starting in Java 18. It's designed for prototyping, testing, and serving static files, not for production web applications. It only supports HTTP/1.1 and serves static content (HTML, CSS, JavaScript, images, etc.).

- We will be making **Simple Web Server** to return the **JSON**.
  - The project folder `modern-java-concurrency`, where we will be running the `jwebserver` in this folder.
  <div align="center">
        <img src="Running_The_Simple_Web_Server.gif"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
    </div>

    - We will start the server running with the `jwebserver`.
    
    <div align="center">
        <img src="Simple_Web_Server_Working.PNG"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
    </div>
    1. We will be returning this:

````JSON
{
  "productId": 1234,
  "productOptions": [{
    "size": "64GB",
    "color": "black",
    "price": 699.99
  },
    {
      "size": "512GB",
      "color": "black",
      "price": 999.99
    }
  ]
}
````

- We can test endpoint was with **Simple Web Server**!

# Build the HttpClient for ProductInfo service.

- **Java** and **Spring** provides some popular **HTTP web client** options:

| Client                         | Built-in?   | Best for                                             |
| ------------------------------ | ----------- | ---------------------------------------------------- |
| **HttpClient** (`java.net.http`) | ✅ Java 11+  | **General-purpose HTTP client (recommended)**!            |
| `HttpURLConnection`            | ✅ Java 1.1+ | Legacy applications.                                  |
| Spring WebClient               | ❌           | Reactive Spring applications.                         |
| Spring RestClient              | ❌           | Modern synchronous Spring applications (Spring 6.1+). |
| Spring RestTemplate            | ❌           | Older Spring applications (maintenance mode).         |

- We will have the following **utils** class for the **HttpClient** creation.

````Java
package com.modernjava.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static com.modernjava.util.LoggerUtil.log;
import static java.net.http.HttpRequest.newBuilder;

public class CommonUtil {

    public static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2))
            .build();

    public  static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static HttpRequest requestBuilder(String url) {
        return newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET() // default (could leave that out)
                .build();
    }
}
````

- We will be creating **HTTP Client call** to our **Simple Web Server**!
  - We will make **HTTP client**:
    ````Java
      var httpClient = CommonUtil.httpClient;
      var httpRequest = requestBuilder(PRODUCT_INFO_URL);
    ````
  - In here we will be making **HTTP client request**.
    ````Java
            HttpResponse<String> response =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    ````
      - The **handler** for the response!
        - `HttpResponse.BodyHandlers.ofString()`.
          - *"Read the HTTP response body and give it to me as a String."*
      - The request to send **httpRequest**.
  - Converts the **JSON** to the **ProductInfo** java object.
    - `return objectMapper.readValue(response.body(), ProductInfo.class);`.

- We can test this client and server!
  ````Java
      @Test
      @Disabled
      void retrieveProductInfo_http() throws IOException, InterruptedException {
          var productInfo = productInfoService.retrieveProductInfoHttp("ABC");
          LoggerUtil.log("productInfo : "+ productInfo);
          assertNotNull(productInfo);

      }
  ````

- We will be testing this with the previous test: 

<div align="center">
    <img src="Testing_The_Simple_Web_Server.gif"  alt="Modern Java - Multithreading in Java using Virtual Threads!" width="600"/>
</div>

<details>
<summary id="Code_CompletableFuture" open="true"> <b>Code for the Simple WebServer , with test!</b> </summary>
 
#### ProductInfoServiceTest.java

````Java

package com.modernjava.service;

import com.modernjava.util.LoggerUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductInfoSercviceTest {

    @Spy
    ProductInfoService productInfoService = new ProductInfoService();

    @Test
//    @Disabled
    void retrieveProductInfo_http() throws IOException, InterruptedException {
        var productInfo = productInfoService.retrieveProductInfoHttp("ABC");
        LoggerUtil.log("productInfo : "+ productInfo);
        assertNotNull(productInfo);

    }
}
````

#### ProductInfoService.java

````Java
package com.modernjava.service;

import com.modernjava.domain.ProductInfo;
import com.modernjava.domain.ProductOption;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;

import static com.modernjava.util.CommonUtil.objectMapper;
import static com.modernjava.util.CommonUtil.requestBuilder;


public class ProductInfoService {

    // virtual-threads/src/main/resources/deliveryDetails.json
    public  static String PRODUCT_INFO_URL = "http://127.0.0.1:8000/virtual-threads/src/main/resources/productInfo.json";


    public ProductInfo retrieveProductInfoHttp(String productId) throws IOException, InterruptedException {
        var httpClient = CommonUtil.httpClient;
        var httpRequest = requestBuilder(PRODUCT_INFO_URL);

        HttpResponse<String> response =
                httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        return objectMapper.readValue(response.body(), ProductInfo.class);

    }

    public ProductInfo retrieveProductInfo(String productId) {
        CommonUtil.sleep(1000);
//        throw new RuntimeException("retrieveProductInfo");
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay");
        return new ProductInfo(productId, productOptions);
    }

    public ProductInfo retrieveProductInfoV2(String productId) {
        CommonUtil.sleep(2000);
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay v2 ");
        return new ProductInfo(productId, productOptions);
    }

    public ProductInfo retrieveProductInfoV3(String productId) {
        CommonUtil.sleep(8000);
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay v3 ");
        return new ProductInfo(productId, productOptions);
    }

    public ProductInfo retrieveProductInfo_MultipleSources(String productId) {

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<ProductInfo>()) {
            scope.fork(() -> retrieveProductInfo(productId));
            scope.fork(() -> retrieveProductInfoV2(productId));
            scope.fork(() -> retrieveProductInfoV3(productId));

            return scope.join().result();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
````

</details>


# Lets make real HTTP calls in ProductService using VirtualThreads.


- Do the structure concurrenct


