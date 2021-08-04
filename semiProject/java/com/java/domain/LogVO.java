package com.java.domain;

public class LogVO {
	private String userID;
	private String sessionID;
	private String logCreateSessionDate;
	private String logVisitPage;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getLogCreateSessionDate() {
		return logCreateSessionDate;
	}
	public void setLogCreateSessionDate(String logCreateSessionDate) {
		this.logCreateSessionDate = logCreateSessionDate;
	}
	public String getLogVisitPage() {
		return logVisitPage;
	}
	public void setLogVisitPage(String logVisitPage) {
		this.logVisitPage = logVisitPage;
	}
	
	
	
	
}
