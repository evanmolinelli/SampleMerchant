package com.evan.merchant;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
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
	
	private static Offer offer;
	
	@BeforeClass
	public static void setup(){
		/*
		 * List<Offer> list = merchantService.retrieveOffers(); Response res =
		 * get("http://localhost:8080/offers"); List<Offer> apiList =
		 * res.then().extract().body().jsonPath().getList(".",Offer.class);
		 */
		offer = new Offer(44, "chuggin", "brewskies", 500);
		
	}

	@Test
	public void getAllOffersTest() {
		when().get("http://localhost:8080/Offers").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("[0].id", equalTo(1)).body("[1].id", equalTo(2));
	}

	@Test
	public void getOfferTest() {
		Offer first = merchantService.getOffer(1);

		when().get("http://localhost:8080/Offer/{id}", first.getId()).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("id", equalTo(1));
	}

	@Test
	public void createAndDeleteOfferTest() {

		given().contentType(ContentType.JSON).body(offer).when().post("http://localhost:8080/SaveOffer").then()
				.assertThat().statusCode(201);

		when().delete("http://localhost:8080/DeleteOffer/{id}", offer.getId()).then().assertThat().statusCode(204);
	}

	@Test
	public void updateOfferTest() {

		given().contentType(ContentType.JSON).body(offer).when().post("http://localhost:8080/SaveOffer").then()
				.assertThat().statusCode(201);

		offer.setDescription("jaeger");

		given().contentType(ContentType.JSON).body(offer).when()
				.put("http://localhost:8080/UpdateOffer/{id}", offer.getId()).then().assertThat().statusCode(200);
	}

}
