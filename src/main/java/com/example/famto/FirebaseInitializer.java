 package com.example.famto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseInitializer {

    private static final Logger logger = Logger.getLogger(FirebaseInitializer.class.getName());

    public static void initialize() throws IOException {
        logger.info("Initializing Firebase...");
        FileInputStream serviceAccount =
            new FileInputStream("src/main/resources/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setStorageBucket("famto-5ca51.appspot.com")
            .build();

        FirebaseApp.initializeApp(options);
        logger.info("Firebase initialized successfully.");
    }
}
