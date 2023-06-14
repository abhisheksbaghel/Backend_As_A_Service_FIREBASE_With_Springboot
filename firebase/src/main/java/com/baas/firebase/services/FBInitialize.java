package com.baas.firebase.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {


    @Value("${key.path}")
    private String keyPath;

    @Value("$(database.url)")
    private String databaseUrl;


    @PostConstruct
    public void initialize()
    {
        try{

            FileInputStream serviceAccount =
                    new FileInputStream(keyPath);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(databaseUrl)
                    .build();

            FirebaseApp.initializeApp(options);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
