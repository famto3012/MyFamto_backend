package com.example.famto.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.famto.dto.BannerRequest;
import com.example.famto.entity.Banner;
import com.example.famto.services.BannerService;

@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @PostMapping("/add")
    public Banner uploadBannerImage(@ModelAttribute BannerRequest bannerRequest) throws IOException {
    		
    	return bannerService.addBanner(bannerRequest);
		
    }	

    @PutMapping("/{id}")
    public Banner updateBanner(@PathVariable Long id , @ModelAttribute BannerRequest bannerRequest) throws FileNotFoundException, IOException
    {
    	return bannerService.updateBanner(id , bannerRequest);
    }
    
    	
    	
}

