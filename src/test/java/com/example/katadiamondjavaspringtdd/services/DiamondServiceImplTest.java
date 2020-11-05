package com.example.katadiamondjavaspringtdd.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.katadiamondjavaspringtdd.web.controller.Diamond;

@SpringBootTest
public class DiamondServiceImplTest {

	@Autowired
	DiamondServiceImpl service;

	@Test
	public void givenLetterBWhenCreateDiamondThenShouldReturnDiamondOfB() {
		// given

		// when
		final Diamond diamond = this.service.of("B");

		// then
		Assertions.assertNotNull(diamond);
		Assertions.assertNotNull(diamond.getRows());
		Assertions.assertEquals(3, diamond.getRows().size());
		Assertions.assertEquals(" A ", diamond.getRows().get(0));
		Assertions.assertEquals("B B", diamond.getRows().get(1));
		Assertions.assertEquals(" A ", diamond.getRows().get(2));
	}

}
