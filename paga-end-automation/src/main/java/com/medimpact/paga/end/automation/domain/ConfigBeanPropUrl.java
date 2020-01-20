package com.medimpact.paga.end.automation.domain;

import org.springframework.stereotype.Component;

@Component
public class ConfigBeanPropUrl {
	
	private String uri = "http://10.129.0.35:8001";
    private String login = "/auth/oauth/token";
    private String taskType = "/metadata/TASK_TYPE";
    private String allHdr = "/metadata/REQUEST_BY";
    private String hdr = "/hq/hdr";
    private String addTask = "/taskMgr/task/add";
    private String startTask = "/taskFlow/task/start";
    private String startSubtask = "/taskFlow/subtask/start";
    private String addclink = "/taskMgr/linkingCrit/add";
    private String condition = "/rule/condition";
    private String addPaths = "/taskMgr/path/add";
    private String updateSub = "/taskMgr/subtask/update";
    private String completeSubTask = "/taskFlow/subtask/completeSubTask";
    private String subtasktkId = "/taskMgr/subtask";
    private String write = "/rule/write";
    private String approveSubTask = "/taskFlow/subtask/approveSubTask";
    private String ruleZip = "/rule/write";
    private String RejectSubTask = "/taskFlow/subtask/rejectSubTask";
    private String newSubTaskuuid = "/taskFlow/tasks";
    private String approveTask = "/taskFlow/task/approveTask";
    private String comments = "/taskFlow/comments";
    private String addComments = "/taskFlow/addComment";
    private String preview = "/rule/preview";
    private String rulePath = "/odm/add/rulePath";
    
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getRulePath() {
		return rulePath;
	}

	public void setRulePath(String rulePath) {
		this.rulePath = rulePath;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getAddComments() {
		return addComments;
	}

	public void setAddComments(String addComments) {
		this.addComments = addComments;
	}

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

	public String getHdr() {
		return hdr;
	}

	public void setHdr(String hdr) {
		this.hdr = hdr;
	}

	public String getAddTask() {
		return addTask;
	}

	public void setAddTask(String addTask) {
		this.addTask = addTask;
	}


	public String getStartTask() {
		return startTask;
	}

	public void setStartTask(String startTask) {
		this.startTask = startTask;
	}

	public String getStartSubtask() {
		return startSubtask;
	}

	public void setStartSubtask(String startSubtask) {
		this.startSubtask = startSubtask;
	}

	public String getCompleteSubTask() {
		return completeSubTask;
	}

	public void setCompleteSubTask(String completeSubTask) {
		this.completeSubTask = completeSubTask;
	}
	

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getUpdateSub() {
		return updateSub;
	}

	public void setUpdateSub(String updateSub) {
		this.updateSub = updateSub;
	}


	public String getAddPaths() {
		return addPaths;
	}

	public void setAddPaths(String addPathss) {
		this.addPaths = addPathss;
	}

	public String getAddclink() {
		return addclink;
	}

	public void setAddclink(String addclink) {
		this.addclink = addclink;
	}

	public String getRejectSubTask() {
		return RejectSubTask;
	}

	public void setRejectSubTask(String rejectSubTask) {
		RejectSubTask = rejectSubTask;
	}

	public String getApproveSubTask() {
		return approveSubTask;
	}

	public void setApproveSubTask(String approveSubTask) {
		this.approveSubTask = approveSubTask;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRuleZip() {
		return ruleZip;
	}

	public void setRuleZip(String ruleZip) {
		this.ruleZip = ruleZip;
	}

	public String getSubtasktkId() {
		return subtasktkId;
	}

	public void setSubtasktkId(String subtasktkId) {
		this.subtasktkId = subtasktkId;
	}

	public String getNewSubTaskuuid() {
		return newSubTaskuuid;
	}

	public void setNewSubTaskuuid(String newSubTaskuuid) {
		this.newSubTaskuuid = newSubTaskuuid;
	}

	public String getApproveTask() {
		return approveTask;
	}

	public void setApproveTask(String approveTask) {
		this.approveTask = approveTask;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	} 
	
	
	
    
}
