package com.example.demo.api;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // 1st
@RequestMapping("/Product")  //2nd   //andika kweny post man
@CrossOrigin(origins = "http://localhost:3000")
public class ProductApi {
    @Autowired

    private ProductRepo productRepo; // link these with your repository

    @GetMapping("/allProduct") //andika kweny post//    Http://localhost:8080/Product/allProduct
    public ResponseEntity<?>getProduct(){
        try {
            List<Product> productList = productRepo.findAll();
            if(productList.isEmpty()){
                return new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(productList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network project ",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/byId{ProId}")  //get by Id
    public ResponseEntity<?> getByID(@PathVariable int ProId){
        try {
            Optional<Product> optionalProduct = productRepo.findById(ProId);    //create variable (product) to get specific data
            if(optionalProduct.isPresent()){
                return new ResponseEntity<>(optionalProduct,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("hakuna ",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception pro){
            return new ResponseEntity<>("System down",HttpStatus.BAD_REQUEST);   //ikiwa anashindwa kupata api
        }
    }
    @PostMapping("/add")      //get method
    public ResponseEntity<?> addProduct(@RequestBody Product proda){
        try {
            Product product1 = productRepo.save(proda);
            return new ResponseEntity<>("data inserted succesful",HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>("uzembe wangu",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{ProId}")
    public ResponseEntity<?> deletedd(@PathVariable int ProId){
        try {
            productRepo.deleteById(ProId);//kupata data kwa repo
            return new ResponseEntity<>("data deleted",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("server do not exist",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{ProId}")
    public ResponseEntity<?> updateProduct(@PathVariable int ProId,@RequestBody Product updateProduct){
        try {
            if(productRepo.findById(ProId).isPresent()){
                updateProduct.setProId(ProId);
                Product product = productRepo.save(updateProduct);

                return new ResponseEntity<>(product,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

