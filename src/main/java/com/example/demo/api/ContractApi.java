package com.example.demo.api;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Contract")
public class ContractApi {
    @Autowired
    private ContractRepo contractRepo;
    @GetMapping("/allContract")
    public ResponseEntity<?>getContract(){
        try {
            List<Contract> contractList = contractRepo.findAll();
            if (contractList.isEmpty()){
                return new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(contractList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network error",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byId{ContId}")
    public ResponseEntity<?>getById(@PathVariable int ContId){
        try {
            Optional<Contract> optionalContract = contractRepo.findById(ContId);
            if (optionalContract.isPresent()){
                return new ResponseEntity<>(optionalContract,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("nothing",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("uzembe wa devpl",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> addContract(@RequestBody Contract contract){
        try {
            Contract contract1 = contractRepo.save(contract);
            return new ResponseEntity<>("data success",HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{ContId}")
    public ResponseEntity<?>deletedd(@PathVariable int ContId){
        try {
            contractRepo.deleteById(ContId);
            return new ResponseEntity<>("data deleted",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("server do not exist",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{ContId}")
    public ResponseEntity<?> updateContract(@PathVariable int ContId, @RequestBody Contract updatedContract){
        try {
            Optional<Contract> optionalContract = contractRepo.findById(ContId);
            if (optionalContract.isPresent()){
                Contract existingContract = optionalContract.get();
                existingContract.setContID(updatedContract.ContID);
                existingContract.setContCode(updatedContract.getContCode());
                existingContract.setContDate(updatedContract.getContDate());
                existingContract.setContType(updatedContract.getContType());
                existingContract.setContName(updatedContract.getContName());
                contractRepo.save(existingContract);
                return new ResponseEntity<>("Data updated",HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("Contract not exist",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



