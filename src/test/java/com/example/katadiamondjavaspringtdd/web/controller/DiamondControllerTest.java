package com.example.katadiamondjavaspringtdd.web.controller;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
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
				.body("rows", Matchers.hasSize(3)).body("rows[0]", CoreMatchers.equalTo(" A "))
				.body("rows[1]", CoreMatchers.equalTo("B B")).body("rows[2]", CoreMatchers.equalTo(" A "));
	}

	@Test
	public void givenLetterAWhenRequestForDiamondThenShouldReturnDiamondOfA() {
		RestAssuredMockMvc

				// given
				.given().standaloneSetup(this.controller).and().param("letter", "A")

				// when
				.when().get("/api/v1/diamonds")

				// then
				.then().log().all().statusCode(HttpStatus.OK.value()).contentType(ContentType.JSON)
				.body("rows", Matchers.hasSize(1)).body("rows[0]", CoreMatchers.equalTo(" A "));

	}
}
