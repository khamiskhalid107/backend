package com.example.demo.api;

import com.example.demo.model.Buyer;
import com.example.demo.repository.BuyerRepo;
import com.example.demo.repository.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController// 1st
@RequestMapping("/Buyer") //2nd
public class BuyerApi {
    @Autowired

    private BuyerRepo buyerRepo;
    @GetMapping("/allBuyer")      // hii baadae inatumika kwenye pst man
    public ResponseEntity<?>getBuyer(){
        try {
            List<Buyer> buyerList = buyerRepo.findAll();
            if(buyerList.isEmpty()){
                return new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(buyerList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network error",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byId{BuyerId}") //get by id
    public ResponseEntity<?> getById(@PathVariable int BuyerId){
        try {
            Optional<Buyer> optionalBuyer = buyerRepo.findById(BuyerId);
            if(optionalBuyer.isPresent()){
                return new ResponseEntity<>(optionalBuyer,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("nothing",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("uzembe wa devlp",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")   //get method
    public ResponseEntity<?> addBuyer(@RequestBody Buyer buyer){
        try {
            Buyer buyer1 = buyerRepo.save(buyer);
            return new ResponseEntity<>("data success",HttpStatus.OK);
        }catch (Exception exceptione){
            return new ResponseEntity<>("uzembe",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete{BuyerId}")
    public ResponseEntity<?>deletedd(@PathVariable int BuyerId){
        try {
            buyerRepo.deleteById(BuyerId);
            return new ResponseEntity<>("data delet",HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>("server do not exist",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{BuyerId}")
    public ResponseEntity<?> updateBuyer(@PathVariable int BuyerId, @RequestBody Buyer updatedBuyer){
        try {
            Optional<Buyer> optionalBuyer = buyerRepo.findById(BuyerId);
            if (optionalBuyer.isPresent()){
                Buyer existingBuyer = optionalBuyer.get();
                existingBuyer.setBuyerEmail(updatedBuyer.BuyerEmail);
                existingBuyer.setBuyerId(updatedBuyer.BuyerId);
                existingBuyer.setBuyerGender(updatedBuyer.BuyerGender);
                existingBuyer.setBuyerMobile(updatedBuyer.BuyerMobile);
                existingBuyer.setBuyerName(updatedBuyer.BuyerName);
                buyerRepo.save(existingBuyer);
                return  new ResponseEntity<>("data updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Buyer does not exist",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}

