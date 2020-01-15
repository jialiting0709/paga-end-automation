package com.medimpact.paga.end.automation.domain;


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
    

}
