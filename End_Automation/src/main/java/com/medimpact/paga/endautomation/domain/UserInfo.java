package com.medimpact.paga.endautomation.domain;

import org.apache.http.client.HttpClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	
    private String username;
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String refreshToken_lifeSpan;
    private String jti;
    private HttpClient defaultHttpClient;

}
