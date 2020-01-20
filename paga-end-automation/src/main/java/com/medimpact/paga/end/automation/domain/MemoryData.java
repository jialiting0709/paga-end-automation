package com.medimpact.paga.end.automation.domain;


public class MemoryData {
	
	private static UserInfo userInfo = new UserInfo();
	private static CaseRelevanceData data = new CaseRelevanceData();
	
		
	public static UserInfo getUserInfo(){
		return userInfo;
	}	
	
	
	public static CaseRelevanceData getCaseRelevanceData(){
		return data;
	}	

}
