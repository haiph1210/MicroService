package com.YangKang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONObject {
    @Bean
    public net.minidev.json.JSONObject provideJSONObject(){
        return new net.minidev.json.JSONObject();
    }
}
