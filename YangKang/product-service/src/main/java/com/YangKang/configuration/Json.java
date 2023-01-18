package com.YangKang.configuration;

import net.minidev.json.JSONObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Json {
    public JSONObject jsonObject(){
        return new JSONObject();
    }
}
