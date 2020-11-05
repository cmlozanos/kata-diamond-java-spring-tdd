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

	@Test
	public void givenLetterAWhenCreateDiamondThenShouldReturnDiamondOfA() {
		// given

		// when
		final Diamond diamond = this.service.of("A");

		// then
		Assertions.assertNotNull(diamond);
		Assertions.assertNotNull(diamond.getRows());
		Assertions.assertEquals(1, diamond.getRows().size());
		Assertions.assertEquals(" A ", diamond.getRows().get(0));
	}

	@Test
	public void givenLetterBWhenComputeIndexOfLettersShoulReturn2() {
		// given
		final String letter = "B";

		// when
		final int index = this.service.indexOfLetter(letter);

		// then
		Assertions.assertEquals(2, index);
	}

	@Test
	public void givenIndexOf2WhenCreateEmptyLineThenShouldReturnStringWithThisSizeAndEmpty() {
		// given
		final int index = 2;
		// when
		final String emptyLine = this.service.createEmptyLine(index);

		// then
		Assertions.assertEquals("   ", emptyLine);
	}

	@Test
	public void givenIndexOf3WhenCreateEmptyLineThenShouldReturnStringWithThisSizeAndEmpty() {
		// given
		final int index = 3;
		// when
		final String emptyLine = this.service.createEmptyLine(index);

		// then
		Assertions.assertEquals("     ", emptyLine);
	}

}
