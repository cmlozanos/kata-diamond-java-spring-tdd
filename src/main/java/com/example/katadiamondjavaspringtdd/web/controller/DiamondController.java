package com.example.katadiamondjavaspringtdd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.katadiamondjavaspringtdd.services.DiamondService;

@RestController
@RequestMapping("/api/v1/diamonds")
public class DiamondController {

	@Autowired
	DiamondService service;

	@GetMapping
	public ResponseEntity<Diamond> of(@RequestParam("letter") final String letter) {
		return ResponseEntity.ok().body(this.service.of(letter));
	}
}
