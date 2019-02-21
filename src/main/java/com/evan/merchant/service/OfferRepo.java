package com.evan.merchant.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evan.merchant.pojo.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Integer>{

}
