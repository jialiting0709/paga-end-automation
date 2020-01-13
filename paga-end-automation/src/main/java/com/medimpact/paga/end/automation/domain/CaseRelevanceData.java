package com.medimpact.paga.end.automation.domain;


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
	
	private static CaseRelevanceData caseRelevanceData = null;
	    
	   private CaseRelevanceData(){
	    	
	   }
	       
	public static CaseRelevanceData getInstance() {
		if (caseRelevanceData == null) {
			caseRelevanceData = new CaseRelevanceData();
		  }
		return caseRelevanceData;
		}

	public int getPkValue() {
		return pkValue;
	}

	public void setPkValue(int pkValue) {
		this.pkValue = pkValue;
	}

	public String getTaskuuid() {
		return taskuuid;
	}

	public void setTaskuuid(String taskuuid) {
		this.taskuuid = taskuuid;
	}

	public String getSubtaskuuid() {
		return subtaskuuid;
	}

	public void setSubtaskuuid(String subtaskuuid) {
		this.subtaskuuid = subtaskuuid;
	}

	public Integer getSubtaskid() {
		return subtaskid;
	}

	public void setSubtaskid(Integer subtaskid) {
		this.subtaskid = subtaskid;
	}

	public Integer getCriteriaCode() {
		return criteriaCode;
	}

	public void setCriteriaCode(Integer criteriaCode) {
		this.criteriaCode = criteriaCode;
	}

	public String getNewReviewSubTaskuuid() {
		return newReviewSubTaskuuid;
	}

	public void setNewReviewSubTaskuuid(String newReviewSubTaskuuid) {
		this.newReviewSubTaskuuid = newReviewSubTaskuuid;
	}

	public String getNewSubTaskDeployedUuid() {
		return newSubTaskDeployedUuid;
	}

	public void setNewSubTaskDeployedUuid(String newSubTaskDeployedUuid) {
		this.newSubTaskDeployedUuid = newSubTaskDeployedUuid;
	}

	public String getNewReviewtaskuuid() {
		return newReviewtaskuuid;
	}

	public void setNewReviewtaskuuid(String newReviewtaskuuid) {
		this.newReviewtaskuuid = newReviewtaskuuid;
	}

	public String getNewDonetaskuuid() {
		return newDonetaskuuid;
	}

	public void setNewDonetaskuuid(String newDonetaskuuid) {
		this.newDonetaskuuid = newDonetaskuuid;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getSubtaskRejuuid() {
		return subtaskRejuuid;
	}

	public void setSubtaskRejuuid(String subtaskRejuuid) {
		this.subtaskRejuuid = subtaskRejuuid;
	}

	public String getSubtaskRejcomuuid() {
		return subtaskRejcomuuid;
	}

	public void setSubtaskRejcomuuid(String subtaskRejcomuuid) {
		this.subtaskRejcomuuid = subtaskRejcomuuid;
	}

	public String getAddPathId() {
		return addPathId;
	}

	public void setAddPathId(String addPathId) {
		this.addPathId = addPathId;
	}

	public static CaseRelevanceData getCaseRelevanceData() {
		return caseRelevanceData;
	}

	public static void setCaseRelevanceData(CaseRelevanceData caseRelevanceData) {
		CaseRelevanceData.caseRelevanceData = caseRelevanceData;
	}
	
	
		  
}
	