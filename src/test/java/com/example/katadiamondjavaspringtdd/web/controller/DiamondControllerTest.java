package com.example.katadiamondjavaspringtdd.web.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiamondControllerTest {

	@Autowired
	DiamondController controller;

	@Test
	public void givenLetterBWhenRequestForDiamondThenShouldReturnDiamondOfB() {
		RestAssuredMockMvc

				// given
				.given().standaloneSetup(this.controller).and().param("letter", "B")

				// when
				.when().get("/api/v1/diamonds")

				// then
				.then().log().all().statusCode(HttpStatus.OK.value()).contentType(ContentType.JSON)
				.body("rows", CoreMatchers.hasItems(" A ", "B B", " A "));

	}
}
