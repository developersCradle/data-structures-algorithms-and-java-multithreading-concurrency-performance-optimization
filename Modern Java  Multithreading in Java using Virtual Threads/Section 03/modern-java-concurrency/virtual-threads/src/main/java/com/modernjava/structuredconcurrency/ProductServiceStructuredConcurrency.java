package com.modernjava.structuredconcurrency;


import com.modernjava.domain.Product;
import com.modernjava.domain.ProductV2;
import com.modernjava.service.DeliveryService;
import com.modernjava.service.ProductInfoService;
import com.modernjava.service.ReviewService;

import java.util.concurrent.StructuredTaskScope;


public class ProductServiceStructuredConcurrency {

    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;
    private final DeliveryService deliveryService;

    public ProductServiceStructuredConcurrency(ProductInfoService productInfoService, ReviewService reviewService, DeliveryService deliveryService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
        this.deliveryService = deliveryService;
    }

    public ProductServiceStructuredConcurrency(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
        this.deliveryService = null;
    }


    public Product retrieveProductDetails(String productId) {
        // We will implement this using Structured Concurrency!

        try (var scope = new StructuredTaskScope.ShutdownOnFailure())
        {
            // Fork the task. Where we make a calls!
            var productsInfoSubTask = scope.fork(() -> productInfoService.retrieveProductInfo(productId));
            var reviewsSubTask = scope.fork(() -> reviewService.retrieveReviews(productId));

            // Join the tasks. We will wait for the task to finish!
            scope.join().throwIfFailed();

            var productInfo = productsInfoSubTask.get();
            var reviewsInfo = reviewsSubTask.get();

            return  new Product(productId, productInfo, reviewsInfo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductV2 retrieveProductDetailsV2(String productId) {

        // We will implement this using Structured Concurrency!
        try (var scope = new StructuredTaskScope.ShutdownOnFailure())
        {
            // Fork the task. Where we make a calls!
            var productsInfoSubTask = scope.fork(() -> productInfoService.retrieveProductInfo(productId));
            var reviewsSubTask = scope.fork(() -> reviewService.retrieveReviews(productId));

            // Join the tasks. We will wait for the task to finish!
            scope.join().throwIfFailed();

            var productInfo = productsInfoSubTask.get();
            var reviewsInfo = reviewsSubTask.get();

            // We are getting DeliveryDetails.
            var deliveryDetailsTask = scope.fork(() -> deliveryService.retrieveDeliveryInfo(productInfo));
            scope.join().throwIfFailed();

            return new ProductV2(productId, productInfo, reviewsInfo, deliveryDetailsTask.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductV2 retrieveProductDetailsHttp(String productId) {

        // We will implement this using Structured Concurrency!
        try (var scope = new StructuredTaskScope.ShutdownOnFailure())
        {
            // Fork the task. Where we make a calls!
            var productsInfoSubTask = scope.fork(() -> productInfoService.retrieveProductInfoHttp(productId));
            var reviewsSubTask = scope.fork(() -> reviewService.retrieveReviewsHttp(productId));

            // Join the tasks. We will wait for the task to finish!
            scope.join().throwIfFailed();

            var productInfo = productsInfoSubTask.get();
            var reviewsInfo = reviewsSubTask.get();

            // We are getting DeliveryDetails.
            var deliveryDetailsTask = scope.fork(() -> deliveryService.retrieveDeliveryInfoHttp(productInfo));
            scope.join().throwIfFailed();

            return new ProductV2(productId, productInfo, reviewsInfo, deliveryDetailsTask.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
