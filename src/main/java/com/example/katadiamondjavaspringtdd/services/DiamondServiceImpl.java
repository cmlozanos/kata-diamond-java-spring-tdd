package com.example.katadiamondjavaspringtdd.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.katadiamondjavaspringtdd.web.controller.Diamond;

@Service
public class DiamondServiceImpl implements DiamondService {

	private static final String LETTERS = "ABCDEFGHIJKLMN�OPQRSTUVWXYZ";

	@Override
	public Diamond of(final String letter) {
		final int indexOfLetter = this.indexOfLetter(letter);
		final String emptyLine = this.createEmptyLine(indexOfLetter);
		final List<String> topRows = this.createTop(indexOfLetter, emptyLine);
		final List<String> bottomRows = this.createBottom(topRows);
		final List<String> rows = Stream.concat(topRows.stream(), bottomRows.stream()).collect(Collectors.toList());
		return Diamond.builder().rows(rows).build();
	}

	public int indexOfLetter(final String letter) {
		return DiamondServiceImpl.LETTERS.indexOf(letter) + 1;
	}

	public String createEmptyLine(final int indexOfLetter) {
		final int times = (indexOfLetter * 2) - 1;
		return Stream.generate(() -> " ").limit(times).collect(Collectors.joining());
	}

	public String createLine(final int indexOfLetter, final String emptyLine, final int position) {
		final char letter = DiamondServiceImpl.LETTERS.charAt(position - 1);

		final StringBuilder lineBuilder = new StringBuilder(emptyLine);
		final int offset = 1;
		final int initialLetterPosition = (indexOfLetter - position - offset) + 1;
		final int finalLetterPosition = ((indexOfLetter + position) - offset) - 1;
		lineBuilder.setCharAt(initialLetterPosition, letter);
		lineBuilder.setCharAt(finalLetterPosition, letter);
		return lineBuilder.toString();

	}

	public List<String> createTop(final int indexOfLetter, final String emptyLine) {
		final int offset = 1;
		return IntStream.range(1, indexOfLetter + offset)
				.mapToObj(position -> this.createLine(indexOfLetter, emptyLine, position)).collect(Collectors.toList());
	}

	public List<String> createBottom(final List<String> rows) {
		final List<String> bottomRows = new ArrayList<>(rows.subList(0, rows.size() - 1));
		Collections.reverse(bottomRows);
		return bottomRows;
	}
}
