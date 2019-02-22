package com.evan.merchant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evan.merchant.pojo.Offer;

@Service
public interface MerchantService {
	
	public List<Offer> retrieveOffers();
	
	public Offer getOffer(int offerId);
	  
	 public void createOffer(Offer offer);
	  
	 public void deleteOffer(int offerId);
	  
	 public void updateOffer(Offer offer);
}
