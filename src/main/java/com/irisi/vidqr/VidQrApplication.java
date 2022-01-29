package com.irisi.vidqr;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VidQrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VidQrApplication.class, args);
    }


    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnwze3q1b",
                "api_key", "153212394175444",
                "api_secret", "jW3W3BjHUnDmk3vo4QgGztclYLU"));
    }

}
