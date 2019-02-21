package com.evan.merchant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/offers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @GetMapping("/offers")
	public List<Offer> offerController() {
		List<Offer> Offers = merchantService.retrieveOffers();
		return Offers;
	}

	@GetMapping("/offers/{offerId}")
	public Offer getEmployee(@PathVariable(name = "offerId") int offerId) {
		return merchantService.getOffer(offerId);
	}

	@RequestMapping(value = "/SaveOffers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping("/SaveOffers")
	public void saveEmployee(@RequestBody Offer offer) {
		merchantService.saveOffer(offer);
		System.out.println("Offer Saved Successfully");
	}

	@DeleteMapping("/DeleteOffer/{offerId}")
	public void deleteEmployee(@PathVariable(name = "offerId") int offerId) {
		merchantService.deleteOffer(offerId);
		System.out.println("Offer Deleted Successfully");
	}

	@PutMapping("/UpdateOffers/{offerId}")
	@ResponseBody
	public String updateEmployee(@RequestBody Offer offer, @PathVariable(name = "offerId") int offerId) {
		Offer o = merchantService.getOffer(offerId);
		if (o != null && offer.getId() == offerId) {
			merchantService.updateOffer(offer);
			return "cool...";
		}else{
			return "Not today";
		}

	}
}
