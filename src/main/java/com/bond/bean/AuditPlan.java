package com.bond.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "audit_plan")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class AuditPlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;
    @OneToMany(fetch = FetchType.LAZY,targetEntity =AuditPlanproject.class,mappedBy = "auditPlan")
    private List<AuditPlanproject> auditPlanprojects = new ArrayList<AuditPlanproject>();

    @Override
    public String toString() {
        return "AuditPlan{" +
                "pId=" + pId +
                ", auditPlanprojects=" + auditPlanprojects +
                ", pNd='" + pNd + '\'' +
                ", pName='" + pName + '\'' +
                ", pJigouname='" + pJigouname + '\'' +
                ", pType='" + pType + '\'' +
                ", pState='" + pState + '\'' +
                ", uId=" + uId +
                ", pTime=" + pTime +
                '}';
    }

    private String pNd;

    private String pName;

    private String pJigouname;

    private String pType;

    private String pState;

    private Integer uId;

    private Date pTime;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpNd() {
        return pNd;
    }

    public void setpNd(String pNd) {
        this.pNd = pNd == null ? null : pNd.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpJigouname() {
        return pJigouname;
    }

    public void setpJigouname(String pJigouname) {
        this.pJigouname = pJigouname == null ? null : pJigouname.trim();
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType == null ? null : pType.trim();
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState == null ? null : pState.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }
}