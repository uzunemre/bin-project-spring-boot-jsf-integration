package com.emreuzun.bank.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyService {

    @Value("${spring.profiles.active}")
    private String PROFILE;

    public boolean isDevelopmentMode() {
        return PROFILE.equals("dev");
    }

}
