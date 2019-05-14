package com.bond.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_audited_institutions")
public class AuditAuditedInstitutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditedId;

    private String auditedHigher;

    private String auditedCode;

    private String auditedName;

    private Date auditedCreatetime;

    private String auditedBusiness;

    private Date auditedBeforetime;

    private String auditedLevel;

    private String auditedCreditCode;

    private String auditedAccounting;

    public Integer getAuditedId() {
        return auditedId;
    }

    public void setAuditedId(Integer auditedId) {
        this.auditedId = auditedId;
    }

    public String getAuditedHigher() {
        return auditedHigher;
    }

    @Override
    public String toString() {
        return "AuditAuditedInstitutions{" +
                "auditedId=" + auditedId +
                ", auditedHigher='" + auditedHigher + '\'' +
                ", auditedCode='" + auditedCode + '\'' +
                ", auditedName='" + auditedName + '\'' +
                ", auditedCreatetime=" + auditedCreatetime +
                ", auditedBusiness='" + auditedBusiness + '\'' +
                ", auditedBeforetime=" + auditedBeforetime +
                ", auditedLevel='" + auditedLevel + '\'' +
                ", auditedCreditCode='" + auditedCreditCode + '\'' +
                ", auditedAccounting='" + auditedAccounting + '\'' +
                '}';
    }

    public AuditAuditedInstitutions(Integer auditedId, String auditedHigher, String auditedCode, String auditedName, Date auditedCreatetime, String auditedBusiness, Date auditedBeforetime, String auditedLevel, String auditedCreditCode, String auditedAccounting) {
        this.auditedId = auditedId;
        this.auditedHigher = auditedHigher;
        this.auditedCode = auditedCode;
        this.auditedName = auditedName;
        this.auditedCreatetime = auditedCreatetime;
        this.auditedBusiness = auditedBusiness;
        this.auditedBeforetime = auditedBeforetime;
        this.auditedLevel = auditedLevel;
        this.auditedCreditCode = auditedCreditCode;
        this.auditedAccounting = auditedAccounting;
    }

    public AuditAuditedInstitutions() {
    }

    public void setAuditedHigher(String auditedHigher) {
        this.auditedHigher = auditedHigher == null ? null : auditedHigher.trim();
    }

    public String getAuditedCode() {
        return auditedCode;
    }

    public void setAuditedCode(String auditedCode) {
        this.auditedCode = auditedCode == null ? null : auditedCode.trim();
    }

    public String getAuditedName() {
        return auditedName;
    }

    public void setAuditedName(String auditedName) {
        this.auditedName = auditedName == null ? null : auditedName.trim();
    }

    public Date getAuditedCreatetime() {
        return auditedCreatetime;
    }

    public void setAuditedCreatetime(Date auditedCreatetime) {
        this.auditedCreatetime = auditedCreatetime;
    }

    public String getAuditedBusiness() {
        return auditedBusiness;
    }

    public void setAuditedBusiness(String auditedBusiness) {
        this.auditedBusiness = auditedBusiness == null ? null : auditedBusiness.trim();
    }

    public Date getAuditedBeforetime() {
        return auditedBeforetime;
    }

    public void setAuditedBeforetime(Date auditedBeforetime) {
        this.auditedBeforetime = auditedBeforetime;
    }

    public String getAuditedLevel() {
        return auditedLevel;
    }

    public void setAuditedLevel(String auditedLevel) {
        this.auditedLevel = auditedLevel == null ? null : auditedLevel.trim();
    }

    public String getAuditedCreditCode() {
        return auditedCreditCode;
    }

    public void setAuditedCreditCode(String auditedCreditCode) {
        this.auditedCreditCode = auditedCreditCode == null ? null : auditedCreditCode.trim();
    }

    public String getAuditedAccounting() {
        return auditedAccounting;
    }

    public void setAuditedAccounting(String auditedAccounting) {
        this.auditedAccounting = auditedAccounting == null ? null : auditedAccounting.trim();
    }
}