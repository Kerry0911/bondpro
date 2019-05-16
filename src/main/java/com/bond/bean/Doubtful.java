package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="doubtful" )
public class Doubtful {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dId;

    private String dCheckxiang;

    private String dName;

    private String dViolation;

    private String dIstrue;

    private String dCalculateddeduction;

    private Date dChecktime;

    private Integer ppId;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdCheckxiang() {
        return dCheckxiang;
    }

    public void setdCheckxiang(String dCheckxiang) {
        this.dCheckxiang = dCheckxiang == null ? null : dCheckxiang.trim();
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdViolation() {
        return dViolation;
    }

    public void setdViolation(String dViolation) {
        this.dViolation = dViolation == null ? null : dViolation.trim();
    }

    public String getdIstrue() {
        return dIstrue;
    }

    public void setdIstrue(String dIstrue) {
        this.dIstrue = dIstrue == null ? null : dIstrue.trim();
    }

    public String getdCalculateddeduction() {
        return dCalculateddeduction;
    }

    public void setdCalculateddeduction(String dCalculateddeduction) {
        this.dCalculateddeduction = dCalculateddeduction == null ? null : dCalculateddeduction.trim();
    }

    public Date getdChecktime() {
        return dChecktime;
    }

    public void setdChecktime(Date dChecktime) {
        this.dChecktime = dChecktime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }
}