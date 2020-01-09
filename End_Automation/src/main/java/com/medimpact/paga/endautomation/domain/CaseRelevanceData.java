package com.medimpact.paga.endautomation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseRelevanceData {
	private int pkValue;
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
	