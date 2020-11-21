package com.pi.bean;

import java.sql.Date;

public class Person2training {
	private int TID;
	private int PID;
	private String ABSENT;
	private String REASON;
	private String RESULT;
	private Date RETRAININGDATE;
	private String XINMIN;

	public int getTID() {
		return TID;
	}

	public void setTID(int TID) {
		this.TID = TID;
	}

	public int getPID() {
		return PID;
	}

	public String getABSENT() {
		return ABSENT;
	}

	public void setABSENT(String ABSENT) {	this.ABSENT = ABSENT;	}

	public String getXINMIN() {
		return XINMIN;
	}

	public void setXINMIN(String XINMIN) {	this.XINMIN = XINMIN;	}

	public String getREASON() {
		return REASON;
	}

	public void setREASON(String REASON) {
		this.REASON = REASON;
	}

	public String getRESULT() {
		return RESULT;
	}

	public void setRESULT(String RESULT) {
		this.RESULT = RESULT;
	}

	public Date getRETRAININGDATE() {
		return RETRAININGDATE;
	}

	public void setRETRAININGDATE(Date RETRAININGDATE) {
		this.RETRAININGDATE = RETRAININGDATE;
	}

	public void setPID(int PID) {
		this.PID = PID;
	}


}
