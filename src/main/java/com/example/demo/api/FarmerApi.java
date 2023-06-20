package com.example.demo.api;

import com.example.demo.model.Farmer;
import com.example.demo.repository.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Farmer")
@CrossOrigin(origins = "http://localhost:3000")
public class FarmerApi {
    @Autowired
    private FarmerRepo farmerRepo;
    @GetMapping("/allFarmer") //Http://localhost:8080/Farmer/allFarmer
    public ResponseEntity<?>getFarmer(){
        try {
            List<Farmer> farmerList = farmerRepo.findAll();
            if (farmerList.isEmpty()){
                return new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(farmerList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Netwok Error",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?>addFarmer(@RequestBody Farmer farmer){
        try {
            Farmer farmer1 = farmerRepo.save(farmer);
            return new ResponseEntity<>("data success full",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("uzembe wa devlp",HttpStatus.BAD_REQUEST);
        }
    }
//    @Transactional
    @DeleteMapping("/delete/{FarmerId}")
    public ResponseEntity<?> deleted(@PathVariable int FarmerId){
        try {
            farmerRepo.deleteById(FarmerId);
            return new ResponseEntity<>("data deleted",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("server do not exist",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{FarmerId}")//http://localhost:8080/update/{FarmerId}
    public ResponseEntity<?> updateFarmer(@PathVariable int FarmerId, @RequestBody Farmer updatedFarmer){
        try {
            Optional<Farmer> optionalFarmer = farmerRepo.findById(FarmerId);
            if (optionalFarmer.isPresent()){
                Farmer existingFarmer = optionalFarmer.get();
                existingFarmer.setFname(updatedFarmer.getFname());
                existingFarmer.setFarmerId(updatedFarmer.getFarmerId());
                existingFarmer.setAddress(updatedFarmer.getAddress());
                existingFarmer.setEmail(updatedFarmer.getEmail());
                farmerRepo.save(existingFarmer);
                return new ResponseEntity<>("Data updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Farmer does not exist",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

