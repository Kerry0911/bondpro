package com.bond.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lId;

    private String lName;

    private Date lTime;

    private String lDept;

    private String lMk;

    private String lType;

    private String lInfo;

    @Override
    public String toString() {
        return "AuditLog{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", lTime=" + lTime +
                ", lDept='" + lDept + '\'' +
                ", lMk='" + lMk + '\'' +
                ", lType='" + lType + '\'' +
                ", lInfo='" + lInfo + '\'' +
                '}';
    }

    public AuditLog(Integer lId, String lName, Date lTime, String lDept, String lMk, String lType, String lInfo) {
        this.lId = lId;
        this.lName = lName;
        this.lTime = lTime;
        this.lDept = lDept;
        this.lMk = lMk;
        this.lType = lType;
        this.lInfo = lInfo;
    }

    public AuditLog() {
    }

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public Date getlTime() {
        return lTime;
    }

    public void setlTime(Date lTime) {
        this.lTime = lTime;
    }

    public String getlDept() {
        return lDept;
    }

    public void setlDept(String lDept) {
        this.lDept = lDept == null ? null : lDept.trim();
    }

    public String getlMk() {
        return lMk;
    }

    public void setlMk(String lMk) {
        this.lMk = lMk == null ? null : lMk.trim();
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType == null ? null : lType.trim();
    }

    public String getlInfo() {
        return lInfo;
    }

    public void setlInfo(String lInfo) {
        this.lInfo = lInfo == null ? null : lInfo.trim();
    }
}