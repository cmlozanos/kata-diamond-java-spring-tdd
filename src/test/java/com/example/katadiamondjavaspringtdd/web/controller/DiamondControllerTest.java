package com.example.katadiamondjavaspringtdd.web.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.katadiamondjavaspringtdd.services.DiamondService;

@SpringBootTest
public class DiamondControllerTest {

	@InjectMocks
	DiamondController controller;

	@Mock
	DiamondService service;

	@Test
	public void givenControllerAndServiceWhenInvokeControllerShouldInvokeService() {
		// given
		final String letter = "B";

		// when
		this.controller.of(letter);

		// then
		Mockito.verify(this.service, Mockito.times(1)).of(letter);
	}

}
