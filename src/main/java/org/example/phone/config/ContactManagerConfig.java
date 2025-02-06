package org.example.phone.config;

import org.example.phone.ContactDao;
import org.example.phone.InMemoryContactDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContactManagerConfig {
    @Bean("contactDao")
    @Scope("singleton")
    public ContactDao contactDao() {
        return new InMemoryContactDao();
    }
}


