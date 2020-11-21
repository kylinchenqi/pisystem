package com.pi.bean;

import java.sql.Date;

public class Car {
    private int CARID;
    private int PID;
    private String CARCHEPAI;
    private Date CARDENJIDATE;


    public int getCARID() {
        return CARID;
    }

    public void setCARID(int CARID) {
        this.CARID = CARID;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getCARCHEPAI() {
        return CARCHEPAI;
    }

    public void setCARCHEPAI(String CARCHEPAI) {
        this.CARCHEPAI = CARCHEPAI;
    }

    public Date getCARDENJIDATE() {
        return CARDENJIDATE;
    }

    public void setCARDENJIDATE(Date CARDENJIDATE) {
        this.CARDENJIDATE = CARDENJIDATE;
    }
}
