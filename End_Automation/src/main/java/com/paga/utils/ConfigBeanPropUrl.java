package com.paga.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
@PropertySource(value = "classpath:configUrl.properties")
public class ConfigBeanPropUrl {

    private String login;
    private String taskType;
    private String allHdr;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getAllHdr() {
		return allHdr;
	}

	public void setAllHdr(String allHdr) {
		this.allHdr = allHdr;
	}  
    
}
