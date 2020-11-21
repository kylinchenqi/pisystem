package com.pi.bean;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Date;
import java.util.List;

public class Training {
	private int TID;
	private Date TRAININGDATE;
	private String SUBJECT;
	private String LOCATION;
	private String GOAL;
	private String SPEAKER;
	private String NOTEKEEPER;
	private String CONTENT;
	private String EVALUATION;
	private String REMARK;
	private String CLASSHOUR;
	private List<Person2training> PERSON2TRAINING;

	public int getTID() {
		return TID;
	}

	public void setTID(int TID) {
		this.TID = TID;
	}

	public Date getTRAININGDATE() {
		return TRAININGDATE;
	}

	public void setTRAININGDATE(Date TRAININGDATE) {this.TRAININGDATE = TRAININGDATE;}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String LOCATION) {
		this.LOCATION = LOCATION;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String SUBJECT) {
		this.SUBJECT = SUBJECT;
	}

	public String getGOAL() {
		return GOAL;
	}

	public void setGOAL(String GOAL) {
		this.GOAL = GOAL;
	}

	public String getSPEAKER() {
		return SPEAKER;
	}

	public void setSPEAKER(String SPEAKER) {
		this.SPEAKER = SPEAKER;
	}

	public String getNOTEKEEPER() {
		return NOTEKEEPER;
	}

	public void setNOTEKEEPER(String NOTEKEEPER) {
		this.NOTEKEEPER = NOTEKEEPER;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}

	public String getEVALUATION() {
		return EVALUATION;
	}

	public void setEVALUATION(String EVALUATION) {
		this.EVALUATION = EVALUATION;
	}

	public String getREMARK() { return REMARK;}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}

	public String getCLASSHOUR() {
		return CLASSHOUR;
	}

	public void setCLASSHOUR(String CLASSHOUR) {
		this.CLASSHOUR = CLASSHOUR;
	}

	public List<Person2training> getPERSON2TRAINING() {
		return PERSON2TRAINING;
	}

	public void setPERSON2TRAINING( List<Person2training> PERSON2TRAINING ) {
		this.PERSON2TRAINING = PERSON2TRAINING;
	}
}
