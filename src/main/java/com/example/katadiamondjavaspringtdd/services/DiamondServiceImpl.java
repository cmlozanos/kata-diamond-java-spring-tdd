package com.example.katadiamondjavaspringtdd.services;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.katadiamondjavaspringtdd.web.controller.Diamond;

@Service
public class DiamondServiceImpl implements DiamondService {

	private static final String LETTERS = "ABCDEFGHIJKLMN�OPQRSTUVWXYZ";

	@Override
	public Diamond of(final String letter) {
		if ("A".equalsIgnoreCase(letter)) {
			return Diamond.builder().rows(Arrays.asList(" A ")).build();
		}
		return Diamond.builder().rows(Arrays.asList(" A ", "B B", " A ")).build();
	}

	public int indexOfLetter(final String letter) {
		return DiamondServiceImpl.LETTERS.indexOf(letter) + 1;
	}

	public String createEmptyLine(final int index) {
		final int times = (index * 2) - 1;
		return Stream.generate(() -> " ").limit(times).collect(Collectors.joining());
	}

	public String createLine(final int index, final String emptyLine, final int position) {
		// TODO Auto-generated method stub
		return null;
	}
}
