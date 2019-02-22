package com.evan.merchant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evan.merchant.pojo.Offer;
import com.evan.merchant.service.MerchantService;

@RestController
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@RequestMapping(value = "/Offers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @GetMapping("/offers")
	public ResponseEntity<List<Offer>> offerController() {
		List<Offer> offers = merchantService.retrieveOffers();
		return new ResponseEntity<List<Offer>>(offers, HttpStatus.OK);
	}

	@GetMapping("/Offer/{offerId}")
	public ResponseEntity<Offer> getOffer(@PathVariable(name = "offerId") int offerId) {
		return new ResponseEntity<Offer>(merchantService.getOffer(offerId), HttpStatus.OK);
	}

	@RequestMapping(value = "/SaveOffer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping("/SaveOffers")
	public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
		merchantService.createOffer(offer);
		System.out.println("Offer Saved Successfully");
		return new ResponseEntity<Offer>(HttpStatus.CREATED);
	}

	@DeleteMapping("/DeleteOffer/{offerId}")
	public ResponseEntity<Void> deleteOffer(@PathVariable(name = "offerId") int offerId) {
		merchantService.deleteOffer(offerId);
		System.out.println("Offer Deleted Successfully");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/UpdateOffer/{offerId}")
	@ResponseBody
	public ResponseEntity<Void> updateOffer(@RequestBody Offer offer, @PathVariable(name = "offerId") int offerId) {
		Offer o = merchantService.getOffer(offerId);
		if (o != null && offer.getId() == offerId) {
			merchantService.updateOffer(offer);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}
}
