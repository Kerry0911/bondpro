package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "approachmeeting")
public class Approachmeeting{
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer amId;

    private Integer ppId;

    private String amName;

    private Date amStarttime;

    private Date amStoptime;

    private String amFuzeren;

    private String amLujing;

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getAmName() {
        return amName;
    }

    public void setAmName(String amName) {
        this.amName = amName == null ? null : amName.trim();
    }

    public Date getAmStarttime() {
        return amStarttime;
    }

    public void setAmStarttime(Date amStarttime) {
        this.amStarttime = amStarttime;
    }

    public Date getAmStoptime() {
        return amStoptime;
    }

    public void setAmStoptime(Date amStoptime) {
        this.amStoptime = amStoptime;
    }

    public String getAmFuzeren() {
        return amFuzeren;
    }

    public void setAmFuzeren(String amFuzeren) {
        this.amFuzeren = amFuzeren == null ? null : amFuzeren.trim();
    }

    public String getAmLujing() {
        return amLujing;
    }

    public void setAmLujing(String amLujing) {
        this.amLujing = amLujing == null ? null : amLujing.trim();
    }
}