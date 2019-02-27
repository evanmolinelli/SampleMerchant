package com.evan.merchant;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.evan.merchant.pojo.Offer;
import com.evan.merchant.service.MerchantService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantApplicationTests {

	@Autowired
	private MerchantService merchantService;
	
	@Ignore
	@BeforeClass
	public static void setup(){
		/*
		 * List<Offer> list = merchantService.retrieveOffers(); Response res =
		 * get("http://localhost:8080/offers"); List<Offer> apiList =
		 * res.then().extract().body().jsonPath().getList(".",Offer.class);
		 */
		
	}

	@Test
	public void getAllOffersTest() {
		when().get("http://localhost:8080/api/Offers").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("[0].id", equalTo(1));
	}

	@Test
	public void getOfferTest() {
		Offer first = merchantService.getOffer(1);

		when().get("http://localhost:8080/api/Offer/{id}", first.getId()).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("id", equalTo(1));
	}

	@Test
	public void createAndDeleteOfferTest() {
		Offer offer = new Offer("guy", "lame guys", 69);
		System.out.println(offer);
		given().contentType(ContentType.JSON).body(offer).when().post("http://localhost:8080/api/SaveOffer").then()
				.assertThat().statusCode(201);

		offer  = merchantService.retrieveOffers().get(1);
		System.out.println(offer);
		when().delete("http://localhost:8080/api/DeleteOffer/{id}", offer.getId()).then().assertThat().statusCode(204);
	}

	@Test
	public void updateOfferTest() {
		Offer offer = new Offer("guy", "lame guys", 69);
		given().contentType(ContentType.JSON).body(offer).when().post("http://localhost:8080/api/SaveOffer").then()
				.assertThat().statusCode(201);

		offer = merchantService.retrieveOffers().get(2);
		offer.setDescription("jaeger");

		given().contentType(ContentType.JSON).body(offer).when()
				.put("http://localhost:8080/api/UpdateOffer/{id}", offer.getId()).then().assertThat().statusCode(200);
		
		merchantService.deleteOffer(offer.getId());
	}

}