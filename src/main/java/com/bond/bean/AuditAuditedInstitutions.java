package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="audit_audited_institutions" )
public class AuditAuditedInstitutions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditedId;
    private Integer preId;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = AuditUser.class,mappedBy = "ins")
    private List<AuditUser> users;

    public List<AuditUser> getUsers() {
        return users;
    }

    public void setUsers(List<AuditUser> users) {
        this.users = users;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

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