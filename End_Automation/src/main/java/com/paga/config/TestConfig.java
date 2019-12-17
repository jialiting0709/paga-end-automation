package com.paga.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.paga.utils.ConfigBeanPropUrl;

public class TestConfig {

    public static HttpClient defaultHttpClient;
    public static String jwtToken;
    public static String username;
    public static String fullName;

}
