package com.medimpact.paga.end.automation.domain;

import org.apache.http.client.HttpClient;


public class UserInfo {	
	
    private String username;
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String refreshToken_lifeSpan;
    private String jti;
    private HttpClient defaultHttpClient;
    
    private static UserInfo userInfo = null;
    
    private UserInfo(){
    	
    }
       
	public static UserInfo getInstance() {
	  if (userInfo == null) {
		  userInfo = new UserInfo();
	  	}
	  return userInfo;
	 }
	    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getRefreshToken_lifeSpan() {
		return refreshToken_lifeSpan;
	}
	public void setRefreshToken_lifeSpan(String refreshToken_lifeSpan) {
		this.refreshToken_lifeSpan = refreshToken_lifeSpan;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	public HttpClient getDefaultHttpClient() {
		return defaultHttpClient;
	}
	public void setDefaultHttpClient(HttpClient defaultHttpClient) {
		this.defaultHttpClient = defaultHttpClient;
	}
    
    

}
