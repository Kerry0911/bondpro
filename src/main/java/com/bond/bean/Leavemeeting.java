package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "leavemeeting")
public class Leavemeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lmId;

    private Integer ppId;

    private String lmName;

    private Date lmStarttime;

    private Date lmStoptime;

    private String lmFuzeren;

    private String lmLujing;

    @Override
    public String toString() {
        return "Leavemeeting{" +
                "lmId=" + lmId +
                ", ppId=" + ppId +
                ", lmName='" + lmName + '\'' +
                ", lmStarttime=" + lmStarttime +
                ", lmStoptime=" + lmStoptime +
                ", lmFuzeren='" + lmFuzeren + '\'' +
                ", lmLujing='" + lmLujing + '\'' +
                '}';
    }

    public Leavemeeting(Integer lmId, Integer ppId, String lmName, Date lmStarttime, Date lmStoptime, String lmFuzeren, String lmLujing) {
        this.lmId = lmId;
        this.ppId = ppId;
        this.lmName = lmName;
        this.lmStarttime = lmStarttime;
        this.lmStoptime = lmStoptime;
        this.lmFuzeren = lmFuzeren;
        this.lmLujing = lmLujing;
    }

    public Leavemeeting() {
    }

    public Integer getLmId() {
        return lmId;
    }

    public void setLmId(Integer lmId) {
        this.lmId = lmId;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getLmName() {
        return lmName;
    }

    public void setLmName(String lmName) {
        this.lmName = lmName == null ? null : lmName.trim();
    }

    public Date getLmStarttime() {
        return lmStarttime;
    }

    public void setLmStarttime(Date lmStarttime) {
        this.lmStarttime = lmStarttime;
    }

    public Date getLmStoptime() {
        return lmStoptime;
    }

    public void setLmStoptime(Date lmStoptime) {
        this.lmStoptime = lmStoptime;
    }

    public String getLmFuzeren() {
        return lmFuzeren;
    }

    public void setLmFuzeren(String lmFuzeren) {
        this.lmFuzeren = lmFuzeren == null ? null : lmFuzeren.trim();
    }

    public String getLmLujing() {
        return lmLujing;
    }

    public void setLmLujing(String lmLujing) {
        this.lmLujing = lmLujing == null ? null : lmLujing.trim();
    }
}