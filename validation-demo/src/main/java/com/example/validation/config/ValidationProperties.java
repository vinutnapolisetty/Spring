package com.example.validation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "validation.user")
public class ValidationProperties {
    private NameValidation name = new NameValidation();
    private EmailValidation email = new EmailValidation();
    private PasswordValidation password = new PasswordValidation();
    
    @Data
    public static class NameValidation {
        private int min;
        private int max;
    }
    
    @Data
    public static class EmailValidation {
        private String pattern;
    }
    
    @Data
    public static class PasswordValidation {
        private int min;
        private String pattern;
    }
}