package com.medimpact.paga.end.automation.domain;


import org.apache.http.client.HttpClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseRelevanceData {
	
	private Integer pkValue;
	private HttpClient defaultHttpClient;
	private String taskuuid;
	private String subtaskuuid;
	private Integer subtaskid;
	private Integer criteriaCode;
	private String newReviewSubTaskuuid;
	private String newSubTaskDeployedUuid;
	private String newReviewtaskuuid;
	private String newDonetaskuuid;
	private String commentId;
	private String subtaskRejuuid;
	private String subtaskRejcomuuid;
	private String addPathId;
	

}
	