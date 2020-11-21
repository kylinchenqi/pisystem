package com.pi.bean;

import java.sql.Date;

public class Plan {
	private String TITLE;
	private int PID;
	private String TARGETPERSON;
	private String PLANHOUR;
	private String CONTENT;
	private String TEACHER;
	private String STATUS;
	private String REMARK;
	private String INDEX;

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}

	public String getTARGETPERSON() {
		return TARGETPERSON;
	}

	public void setTARGETPERSON(String TARGETPERSON) {
		this.TARGETPERSON = TARGETPERSON;
	}

	public String getPLANHOUR() {
		return PLANHOUR;
	}

	public void setPLANHOUR(String PLANHOUR) {
		this.PLANHOUR = PLANHOUR;
	}

	public String getTEACHER() {
		return TEACHER;
	}

	public void setTEACHER(String TEACHER) {
		this.TEACHER = TEACHER;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}

	public String getINDEX() {
		return INDEX;
	}

	public void setINDEX(String INDEX) {
		this.INDEX = INDEX;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}

	public int getPID() {return PID;}

	public void setPID(int PID) {
		this.PID = PID;
	}


}
