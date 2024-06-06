package com.example.famto.controller;

import com.example.famto.entity.ProductsData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")


public class ProductsController {

    @Autowired
    private ProductsRepo productsRepo;

    // get all products
    @GetMapping
    public List<ProductsData> getAllProducts() {
        return this.productsRepo.findAll();

    }

    // get products by id
    @GetMapping("/{productId}")
    public ProductsData getProductById(@PathVariable(value = "productId") int productId) {
        return this.productsRepo.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("User not found with productId"));
    }

    @PostMapping
    public ResponseEntity<ProductsData> createProduct(@RequestBody ProductsData productsData) {
        // Get the values of isVeg, isNonVeg, and isBoth from the request body
        boolean isVeg = productsData.isVeg();
        boolean isNonVeg = productsData.isNonVeg();
        boolean isBoth = productsData.isBoth();

        // Validate that only one option is selected
        if ((isVeg && (isNonVeg || isBoth)) || (isNonVeg && (isVeg || isBoth)) || (isBoth && (isVeg || isNonVeg))) {
            return ResponseEntity.badRequest().build(); // Return bad request if more than one option is selected
        }

        // Set the appropriate fields based on the selected option
        if (isVeg) {
            productsData.setVeg(true);
        } else if (isNonVeg) {
            productsData.setNonVeg(true);
        } else { // isBoth selected
            productsData.setBoth(true);
        }

        // Save the product data
        ProductsData createdProduct = this.productsRepo.save(productsData);

        // Return the created product along with HTTP status code 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }


    // update product data
    @PutMapping("/{productId}")
    public ResponseEntity<ProductsData> updateProduct(@RequestBody ProductsData productsData,
                                                      @PathVariable("productId") int productId) {
        ProductsData existingProduct = this.productsRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with productId: " + productId));

        // Update the fields of the existing product with the new values

        if (productsData.getProductName() != null) {
            existingProduct.setProductName(productsData.getProductName());
        }
        if (productsData.getRestaurantName() != null) {
            existingProduct.setRestaurantName(productsData.getRestaurantName());
        }
        if (productsData.getProductImageUrl() != null) {
            existingProduct.setProductImageUrl(productsData.getProductImageUrl());
        }
        if (productsData.getShortDescription() != null) {
            existingProduct.setShortDescription(productsData.getShortDescription());
        }
        if (productsData.getLongDescription() != null) {
            existingProduct.setLongDescription(productsData.getLongDescription());
        }
        if (productsData.getPrice() != null) {
            existingProduct.setPrice(productsData.getPrice());
        }
        if (productsData.getDiscount() != null) {
            existingProduct.setDiscount(productsData.getDiscount());
        }
        if (productsData.getInventoryStatus() != null) {
            existingProduct.setInventoryStatus(productsData.getInventoryStatus());
        }
        if (productsData.getQuantity() != null) {
            existingProduct.setQuantity(productsData.getQuantity());
        }
        if (productsData.getAlert() != null) {
            existingProduct.setAlert(productsData.getAlert());
        }
        if (productsData.getPrepartionTime() != null) {
            existingProduct.setPrepartionTime(productsData.getPrepartionTime());
        }
        if (productsData.getCategory() != null) {
            existingProduct.setCategory(productsData.getCategory());
        }
        if (productsData.getCategoryDesc() != null) {
            existingProduct.setCategoryDesc(productsData.getCategoryDesc());
        }
        if (productsData.getMinOrderQty() != null) {
            existingProduct.setMinOrderQty(productsData.getMinOrderQty());
        }
        if (productsData.getMaxQtyPerOrder() != null) {
            existingProduct.setMaxQtyPerOrder(productsData.getMaxQtyPerOrder());
        }
        if (productsData.getSku() != null) {
            existingProduct.setSku(productsData.getSku());
        }
        if (productsData.getCost() != null) {
            existingProduct.setCost(productsData.getCost());
        }
        if (productsData.getAddOnName() != null) {
            existingProduct.setAddOnName(productsData.getAddOnName());
        }
        if (productsData.getAddOnSelectionType() != null) {
            existingProduct.setAddOnSelectionType(productsData.getAddOnSelectionType());
        }


        existingProduct.setVeg(productsData.isVeg());
        existingProduct.setNonVeg(productsData.isNonVeg());
        existingProduct.setBoth(productsData.isBoth());

        // Save the updated product
        ProductsData updatedProduct = this.productsRepo.save(existingProduct);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId) {
        ProductsData existingProduct = this.productsRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with productId: " + productId));
        this.productsRepo.delete(existingProduct);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/restaurant-products-data")
    public List<ProductsData> searchRestaurantProducts(@RequestParam int restaurantId) {
        return productsRepo.findRestaurantProducts(restaurantId);
    }

    @GetMapping("/restaurant-category-products")
    public List<ProductsData> searchRestaurantProductCategory(@RequestParam int restaurantId,
                                                              @RequestParam String category) {
        return productsRepo.findUserByRestaurantAndCategory(restaurantId, category);
    }

    @GetMapping("/restaurant-product")
    public ResponseEntity<ProductsData> searchRestaurantProduct(@RequestParam int restaurantId,
                                                                @RequestParam String category,
                                                                @RequestParam int productId) {
        ProductsData restaurantProduct = productsRepo.findUserByRestaurantAndCategoryAndProductId(restaurantId,
                category, productId);
        if (restaurantProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurantProduct);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductsData>> searchProducts(@RequestParam(required = false) String query) {
        // Check if query parameter is provided
        if (query == null || query.isEmpty()) {
            // If query parameter is not provided, return all products
            List<ProductsData> allProducts = productsRepo.findAll();
            return ResponseEntity.ok(allProducts);
        } else {
            // If query parameter is provided, perform search
            List<ProductsData> searchResults = productsRepo.findByProductNameContainingIgnoreCase(query);
            return ResponseEntity.ok(searchResults);
        }
    }

}
