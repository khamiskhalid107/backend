package com.example.demo.repository;

import com.example.demo.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Integer> {


}
