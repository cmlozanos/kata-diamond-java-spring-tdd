package com.example.katadiamondjavaspringtdd.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.katadiamondjavaspringtdd.web.controller.Diamond;

@Service
public class DiamondServiceImpl implements DiamondService {

	private static final String LETTERS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

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
		// TODO Auto-generated method stub
		return null;
	}
}
