package com.medimpact.paga.end.automation.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.UserInfo;

@Component
public class ConfigBaseData {
	
	@Bean
	public UserInfo initUserInfo(){
		UserInfo user = new UserInfo();
		return user;
	}

	@Bean
	public CaseRelevanceData initCaseRelevanceData(){
		CaseRelevanceData data = new CaseRelevanceData();
		return data;
	}
	
	@Bean
	public ConfigBeanPropUrl initConfigBeanPropUrl(){
		return new ConfigBeanPropUrl();
	}
}
