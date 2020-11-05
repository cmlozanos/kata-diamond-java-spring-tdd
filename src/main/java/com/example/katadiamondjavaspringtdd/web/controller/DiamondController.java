package com.example.katadiamondjavaspringtdd.web.controller;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/diamonds")
public class DiamondController {

	@GetMapping
	public ResponseEntity<Diamond> of(@RequestParam("letter") final String letter) {
		final Diamond diamond = Diamond.builder().rows(Arrays.asList(" A ", "B B", " A ")).build();
		return ResponseEntity.ok().body(diamond);
	}
}
