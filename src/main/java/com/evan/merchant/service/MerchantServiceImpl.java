package com.evan.merchant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.evan.merchant.pojo.Offer;

@Component
public class MerchantServiceImpl implements MerchantService {
	 
	@Autowired
	private OfferRepo offerRepo;
	
	public void setOfferRepo(OfferRepo offerRepo) {
		  this.offerRepo = offerRepo;
		 }

	public List<Offer> retrieveOffers() {
		  List<Offer> Offers = offerRepo.findAll();
		  return Offers;
		 }
	

	 public Offer getOffer(int offerId) {
	  Optional<Offer> optOff = offerRepo.findById(offerId);
	  return optOff.get();
	 }
	  
	 public void saveOffer(Offer Offer){
		 offerRepo.save(Offer);
	 }
	  
	 public void deleteOffer(int offerId){
	  offerRepo.deleteById(offerId);
	 }
	  
	 public void updateOffer(Offer offer) {
	  offerRepo.save(offer);
	 }

	
}
