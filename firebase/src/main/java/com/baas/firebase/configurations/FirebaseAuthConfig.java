package com.baas.firebase.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseAuthConfig {

    @Value("${key.path}")
    private String serviceAccount;

    @Value("$(database.url)")
    private String databaseUrl;

    @Bean
    FirebaseAuth firebaseAuth() throws IOException {
        var options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(serviceAccount)))
                .build();

        var firebaseApp = FirebaseApp.initializeApp(options);

        return FirebaseAuth.getInstance(firebaseApp);
    }

}
