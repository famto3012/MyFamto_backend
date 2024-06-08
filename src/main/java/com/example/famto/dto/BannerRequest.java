package com.example.famto.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data

public class BannerRequest {

	private String name;
	private Long restaurantId;
	private String geoFence;
	private MultipartFile bannerImage;
}
