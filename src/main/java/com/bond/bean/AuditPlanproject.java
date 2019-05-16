package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="audit_planproject" )
public class AuditPlanproject {
    @Id
    private Integer ppId;

    private String ppName;

    private String ppAudit;

    private String ppAudited;

    private String ppSpecific;

    private String ppType;

    private String ppCreatepeople;

    private Date ppCreatedate;

    private String ppZhushen;

    private String ppZhushenrole;

    private String ppZs;

    private String ppZszrole;

    private String ppGeneratepeople;

    private Integer pId;

    private Date ppStarttime;

    private Date ppEndstart;

    private String ppJieduan;

    private String ppCheck;

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName == null ? null : ppName.trim();
    }

    public String getPpAudit() {
        return ppAudit;
    }

    public void setPpAudit(String ppAudit) {
        this.ppAudit = ppAudit == null ? null : ppAudit.trim();
    }

    public String getPpAudited() {
        return ppAudited;
    }

    public void setPpAudited(String ppAudited) {
        this.ppAudited = ppAudited == null ? null : ppAudited.trim();
    }

    public String getPpSpecific() {
        return ppSpecific;
    }

    public void setPpSpecific(String ppSpecific) {
        this.ppSpecific = ppSpecific == null ? null : ppSpecific.trim();
    }

    public String getPpType() {
        return ppType;
    }

    public void setPpType(String ppType) {
        this.ppType = ppType == null ? null : ppType.trim();
    }

    public String getPpCreatepeople() {
        return ppCreatepeople;
    }

    public void setPpCreatepeople(String ppCreatepeople) {
        this.ppCreatepeople = ppCreatepeople == null ? null : ppCreatepeople.trim();
    }

    public Date getPpCreatedate() {
        return ppCreatedate;
    }

    public void setPpCreatedate(Date ppCreatedate) {
        this.ppCreatedate = ppCreatedate;
    }

    public String getPpZhushen() {
        return ppZhushen;
    }

    public void setPpZhushen(String ppZhushen) {
        this.ppZhushen = ppZhushen == null ? null : ppZhushen.trim();
    }

    public String getPpZhushenrole() {
        return ppZhushenrole;
    }

    public void setPpZhushenrole(String ppZhushenrole) {
        this.ppZhushenrole = ppZhushenrole == null ? null : ppZhushenrole.trim();
    }

    public String getPpZs() {
        return ppZs;
    }

    public void setPpZs(String ppZs) {
        this.ppZs = ppZs == null ? null : ppZs.trim();
    }

    public String getPpZszrole() {
        return ppZszrole;
    }

    public void setPpZszrole(String ppZszrole) {
        this.ppZszrole = ppZszrole == null ? null : ppZszrole.trim();
    }

    public String getPpGeneratepeople() {
        return ppGeneratepeople;
    }

    public void setPpGeneratepeople(String ppGeneratepeople) {
        this.ppGeneratepeople = ppGeneratepeople == null ? null : ppGeneratepeople.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getPpStarttime() {
        return ppStarttime;
    }

    public void setPpStarttime(Date ppStarttime) {
        this.ppStarttime = ppStarttime;
    }

    public Date getPpEndstart() {
        return ppEndstart;
    }

    public void setPpEndstart(Date ppEndstart) {
        this.ppEndstart = ppEndstart;
    }

    public String getPpJieduan() {
        return ppJieduan;
    }

    public void setPpJieduan(String ppJieduan) {
        this.ppJieduan = ppJieduan == null ? null : ppJieduan.trim();
    }

    public String getPpCheck() {
        return ppCheck;
    }

    public void setPpCheck(String ppCheck) {
        this.ppCheck = ppCheck == null ? null : ppCheck.trim();
    }
}