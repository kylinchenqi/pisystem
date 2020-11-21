package com.pi.bean;

import java.sql.Date;

public class Zhizhao {
    private int ZHIZHAOID;
    private String ZHIZHAOTYPE;
    private int PID;
    private Date ZHIZHAODATEFROM;
    private Date ZHIZHAODATETO;

    public int getZHIZHAOID() {
        return ZHIZHAOID;
    }

    public void setZHIZHAOID(int ZHIZHAOID) {
        this.ZHIZHAOID = ZHIZHAOID;
    }

    public String getZHIZHAOTYPE() {
        return ZHIZHAOTYPE;
    }

    public void setZHIZHAOTYPE(String ZHIZHAOTYPE) {
        this.ZHIZHAOTYPE = ZHIZHAOTYPE;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public Date getZHIZHAODATEFROM() {
        return ZHIZHAODATEFROM;
    }

    public void setZHIZHAODATEFROM(Date ZHIZHAODATEFROM) {
        this.ZHIZHAODATEFROM = ZHIZHAODATEFROM;
    }

    public Date getZHIZHAODATETO() {
        return ZHIZHAODATETO;
    }

    public void setZHIZHAODATETO(Date ZHIZHAODATETO) {
        this.ZHIZHAODATETO = ZHIZHAODATETO;
    }
}
