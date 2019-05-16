package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="audit_log" )
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