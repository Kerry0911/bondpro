package com.bond.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_plan")
public class AuditPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    private String pNd;

    private String pName;

    private Integer aId;

    private String pType;

    private String pState;

    private Integer uId;

    private Date pTime;

    @Override
    public String toString() {
        return "AuditPlan{" +
                "pId=" + pId +
                ", pNd='" + pNd + '\'' +
                ", pName='" + pName + '\'' +
                ", aId=" + aId +
                ", pType='" + pType + '\'' +
                ", pState='" + pState + '\'' +
                ", uId=" + uId +
                ", pTime=" + pTime +
                '}';
    }

    public AuditPlan(Integer pId, String pNd, String pName, Integer aId, String pType, String pState, Integer uId, Date pTime) {
        this.pId = pId;
        this.pNd = pNd;
        this.pName = pName;
        this.aId = aId;
        this.pType = pType;
        this.pState = pState;
        this.uId = uId;
        this.pTime = pTime;
    }

    public AuditPlan() {
    }

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

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
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