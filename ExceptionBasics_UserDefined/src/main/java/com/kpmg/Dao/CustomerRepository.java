package com.kpmg.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpmg.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
