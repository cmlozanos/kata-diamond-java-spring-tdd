package com.example.katadiamondjavaspringtdd.web.controller;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Diamond {
	public List<String> rows;
}
