package com.example.famto.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.famto.controller.BannerController;
import com.example.famto.dto.BannerRequest;
import com.example.famto.entity.Banner;
import com.example.famto.repository.BannerRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


@Service

public class BannerService {

	@Autowired
	BannerRepository bannerrepository;

	public Banner addBanner(BannerRequest bannerRequest) {
		if (!"image/png".equals(bannerRequest.getBannerImage().getContentType())) {
			throw new IllegalArgumentException("Only PNG images are allowed for title image.");
		}
		return saveBanner(bannerRequest);
	}

	public Banner saveBanner(BannerRequest bannerRequest) {
		Banner addBanner = new Banner();
		String fileName = generateUniqueFileName();
		String imageUrl = null;
		try {
			imageUrl = uploadFileToFirebase(bannerRequest.getBannerImage(), fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addBanner.setBannerImageUrl(imageUrl);
		addBanner.setName(bannerRequest.getName());
		addBanner.setRestaurantId(bannerRequest.getRestaurantId());
		addBanner.setGeoFence(bannerRequest.getGeoFence());
		return bannerrepository.save(addBanner);
	}

	private String generateUniqueFileName() {
		return UUID.randomUUID().toString() + ".png";
	}

	private String uploadFileToFirebase(MultipartFile bannerImage, String fileName) throws IOException {
//		FirebaseInitializer.initialize();

		File tempFile = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(tempFile)) {
			fos.write(bannerImage.getBytes());
			fos.close();
		}

		// Get Storage instance
		// Storage storage = StorageOptions.getDefaultInstance().getService();

		// Define the blob ID and blob info
		BlobId blobId = BlobId.of("famto-5ca51.appspot.com", "banners/" + fileName);
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(bannerImage.getContentType()).build();
		InputStream inputStream = BannerController.class.getClassLoader()
				.getResourceAsStream("serviceAccountKey.json"); // change the file name with your one
		GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
		Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
		storage.create(blobInfo, java.nio.file.Files.readAllBytes(tempFile.toPath()));
		// Upload the file
		Blob blob = storage.create(blobInfo, bannerImage.getBytes());

		// Return the media link
		return blob.getMediaLink();
	}

	   public Banner updateBanner(Long id , BannerRequest bannerRequest) throws FileNotFoundException, IOException
	{
	    	Optional<Banner> existing = bannerrepository.findById(id);
	    	Banner existingBanner = existing.get();
	    	
	    	if(bannerRequest.getName() != null)
	    	{
	    		existingBanner.setName(bannerRequest.getName());
	    	}
	    	
	    	if(bannerRequest.getRestaurantId() != null)
	    	{
	    		existingBanner.setRestaurantId(bannerRequest.getRestaurantId());
	    	}
	    	
	    	if(bannerRequest.getGeoFence() != null)
	    	{
	    		existingBanner.setGeoFence(bannerRequest.getGeoFence());
	    	}
	    	
	    	if(bannerRequest.getBannerImage() != null)
	    	{
	    		deleteExistingImage(existingBanner.getBannerImageUrl());
	    		String fileName = generateUniqueFileName();
//	    		uploadFileToFirebase(bannerRequest.getBannerImage(), fileName);
	    		String newBannerImageUrl =  uploadFileToFirebase(bannerRequest.getBannerImage(), fileName);
	    		existingBanner.setBannerImageUrl(newBannerImageUrl);
	    	
	    	}
	    	
	    	return bannerrepository.save(existingBanner);
	    	
	    	
	    	 
	    	

	}

	private boolean deleteExistingImage(String bannerImageUrl) throws FileNotFoundException, IOException
	{		String decodedUrl = URLDecoder.decode(bannerImageUrl, StandardCharsets.UTF_8.name());
        String bucketName = "famto-5ca51.appspot.com";
        String prefix = "https://www.googleapis.com/download/storage/v1/b/" + bucketName + "/o/banners/";

        String filePath = decodedUrl.substring(prefix.length(), decodedUrl.indexOf("?"));

        InputStream inputStream = BannerController.class.getClassLoader()
				.getResourceAsStream("serviceAccountKey.json"); // change the file name with your one
        
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .build()
                .getService();

        // Delete the file
        BlobId blobId = BlobId.of(bucketName, "banners/" + filePath);
        boolean deleted = storage.delete(blobId);
		return deleted;
	}
	
}

