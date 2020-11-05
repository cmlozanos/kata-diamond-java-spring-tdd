package com.example.katadiamondjavaspringtdd.services;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
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

	@Test
	public void givenIndexAndEmptyLineAndPositionWhenCreateLineThenShouldReturnLine() {
		// given
		final int indexOfLetter = 2;
		final String emptyLine = "   ";
		final int position = 2;

		// when
		final String row = this.service.createLine(indexOfLetter, emptyLine, position);

		// then
		Assertions.assertEquals("B B", row);
	}

	@Test
	public void givenIndexAndEmptyLineWhenCreateTopThenShouldReturnTopLines() {
		// given
		final int indexOfLetter = 2;
		final String emptyLine = "   ";

		// when
		final List<String> rows = this.service.createTop(indexOfLetter, emptyLine);

		// then
		Assertions.assertEquals(2, rows.size());
		Assertions.assertEquals(" A ", rows.get(0));
		Assertions.assertEquals("B B", rows.get(1));

	}

	@Test
	public void givenTopLinesWhenCreateBottomThenShouldReturnBottomLines() {
		// given
		final List<String> rows = Arrays.asList(" A ", "B B");

		// when
		final List<String> bottomRows = this.service.createBottom(rows);

		// then
		Assertions.assertEquals(1, bottomRows.size());
		Assertions.assertEquals(" A ", rows.get(0));
	}

	@Test
	public void givenLetterWhenCreateDiamondThenShouldInvokeNextMethods() {
		// given
		final DiamondServiceImpl mockService = Mockito.spy(DiamondServiceImpl.class);

		// when
		mockService.of("B");

		// then
		Mockito.verify(mockService, Mockito.times(1)).indexOfLetter("B");
		Mockito.verify(mockService, Mockito.times(1)).createEmptyLine(ArgumentMatchers.anyInt());
		Mockito.verify(mockService, Mockito.times(1)).createTop(ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyString());
		Mockito.verify(mockService, Mockito.times(1)).createBottom(ArgumentMatchers.anyList());
	}
}
