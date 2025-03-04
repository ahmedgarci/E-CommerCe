package com.example.E_Commerce.Infrastructure.Cloudinary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    private String cloudName="dit4hdghr";

    private String apiKey= "118553587329966";

    private String apiSecret="UQmTp22EiIxEvl9-WI6IfapzQYQ";

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        );
        return new Cloudinary(config);
    }
}
