package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="compoany_checkitem" )
public class CompanyCheckitem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ccId;

    private String ccProjectname;

    private String ccCheck;

    private String ccDept;

    private String ccState;

    private String ccBeijihe;

    private String ccShenji;

    private String ccBeizhu;

    private String ccCheckname;

    private Date ccChecktime;

    private Integer ppId;

    private String ccIs;

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCcProjectname() {
        return ccProjectname;
    }

    public void setCcProjectname(String ccProjectname) {
        this.ccProjectname = ccProjectname == null ? null : ccProjectname.trim();
    }

    public String getCcCheck() {
        return ccCheck;
    }

    public void setCcCheck(String ccCheck) {
        this.ccCheck = ccCheck == null ? null : ccCheck.trim();
    }

    public String getCcDept() {
        return ccDept;
    }

    public void setCcDept(String ccDept) {
        this.ccDept = ccDept == null ? null : ccDept.trim();
    }

    public String getCcState() {
        return ccState;
    }

    public void setCcState(String ccState) {
        this.ccState = ccState == null ? null : ccState.trim();
    }

    public String getCcBeijihe() {
        return ccBeijihe;
    }

    public void setCcBeijihe(String ccBeijihe) {
        this.ccBeijihe = ccBeijihe == null ? null : ccBeijihe.trim();
    }

    public String getCcShenji() {
        return ccShenji;
    }

    public void setCcShenji(String ccShenji) {
        this.ccShenji = ccShenji == null ? null : ccShenji.trim();
    }

    public String getCcBeizhu() {
        return ccBeizhu;
    }

    public void setCcBeizhu(String ccBeizhu) {
        this.ccBeizhu = ccBeizhu == null ? null : ccBeizhu.trim();
    }

    public String getCcCheckname() {
        return ccCheckname;
    }

    public void setCcCheckname(String ccCheckname) {
        this.ccCheckname = ccCheckname == null ? null : ccCheckname.trim();
    }

    public Date getCcChecktime() {
        return ccChecktime;
    }

    public void setCcChecktime(Date ccChecktime) {
        this.ccChecktime = ccChecktime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getCcIs() {
        return ccIs;
    }

    public void setCcIs(String ccIs) {
        this.ccIs = ccIs == null ? null : ccIs.trim();
    }
}