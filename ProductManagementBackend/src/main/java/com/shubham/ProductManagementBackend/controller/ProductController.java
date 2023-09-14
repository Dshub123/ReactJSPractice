package com.shubham.ProductManagementBackend.controller;

import com.shubham.ProductManagementBackend.beans.Product;
import com.shubham.ProductManagementBackend.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService pservice;

    //Get All Products Controller:-----
    @GetMapping("/alltproducts")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> plist = pservice.allProducts();
        if(plist != null){
            return ResponseEntity.ok(plist);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Get By Id Controller:-----
    @GetMapping("/getproduct/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer pid){

        Product prod = pservice.getById(pid);

        if(prod != null){
            return ResponseEntity.ok(prod);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Insert New Product Controller:-----
    @PostMapping("/newproduct")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product prod){

        Product p = pservice.insertNewProduct(prod);

        if(p != null){
            return ResponseEntity.ok(p);
        }

        return (ResponseEntity<Product>) ResponseEntity.badRequest();
    }

    //Update The Existing Product:-----
    @PostMapping("/editproduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod){

        Product p = pservice.changeProduct(prod);

        if(p != null){
            return ResponseEntity.ok(p);
        }

        return (ResponseEntity<Product>) ResponseEntity.badRequest();
    }

    //Delete The Product:-----
    @DeleteMapping("/deleteproduct/{pid}")
    public ResponseEntity<String> deleteproduct(@PathVariable Integer pid){
        Boolean status = pservice.removeProduct(pid);
        if(status){
            return ResponseEntity.ok("Deleted Successfully");
        }

        return (ResponseEntity<String>) ResponseEntity.badRequest();
    }

}
