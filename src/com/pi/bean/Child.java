package com.pi.bean;

import java.sql.Date;

public class Child {
	private int CHILDID;
	private int PID;
	private Date CHILDSHENRI;
	private String CHILDXINMIN;
	private String CHILDXINBIE;


	public int getCHILDID() {
		return CHILDID;
	}

	public void setCHILDID(int CHILDID) {
		this.CHILDID = CHILDID;
	}

	public int getPID() {
		return PID;
	}

	public Date getCHILDSHENRI() {
		return CHILDSHENRI;
	}

	public void setCHILDSHENRI(Date CHILDSHENRI) {
		this.CHILDSHENRI = CHILDSHENRI;
	}

	public String getCHILDXINMIN() {
		return CHILDXINMIN;
	}

	public void setCHILDXINMIN(String CHILDXINMIN) {
		this.CHILDXINMIN = CHILDXINMIN;
	}

	public String getCHILDXINBIE() {
		return CHILDXINBIE;
	}

	public void setCHILDXINBIE(String CHILDXINBIE) {
		this.CHILDXINBIE = CHILDXINBIE;
	}

	public void setPID(int PID) {
		this.PID = PID;
	}


}
