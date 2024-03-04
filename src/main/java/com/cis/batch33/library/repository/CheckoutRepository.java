package com.cis.batch33.library.repository;


import com.cis.batch33.library.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {

}
