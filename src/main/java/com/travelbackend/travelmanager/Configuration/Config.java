package com.travelbackend.travelmanager.Configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class Config {
    @Value("${activeProfile)")
    String activeProfile;

}
