package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="sale_checkitem" )
public class SaleCheckitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;

    private String cProjectname;

    private String cCheck;

    private String cDept;

    private String cState;

    private String cCount;

    private String cBeijihe;

    private String cShenji;

    private String cBeizhu;

    private String cCalculateddeduction;

    private String cActualdeduction;

    private String cCheckname;

    private Date cChecktime;

    private Integer ppId;

    private String cIs;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcProjectname() {
        return cProjectname;
    }

    public void setcProjectname(String cProjectname) {
        this.cProjectname = cProjectname == null ? null : cProjectname.trim();
    }

    public String getcCheck() {
        return cCheck;
    }

    public void setcCheck(String cCheck) {
        this.cCheck = cCheck == null ? null : cCheck.trim();
    }

    public String getcDept() {
        return cDept;
    }

    public void setcDept(String cDept) {
        this.cDept = cDept == null ? null : cDept.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public String getcCount() {
        return cCount;
    }

    public void setcCount(String cCount) {
        this.cCount = cCount == null ? null : cCount.trim();
    }

    public String getcBeijihe() {
        return cBeijihe;
    }

    public void setcBeijihe(String cBeijihe) {
        this.cBeijihe = cBeijihe == null ? null : cBeijihe.trim();
    }

    public String getcShenji() {
        return cShenji;
    }

    public void setcShenji(String cShenji) {
        this.cShenji = cShenji == null ? null : cShenji.trim();
    }

    public String getcBeizhu() {
        return cBeizhu;
    }

    public void setcBeizhu(String cBeizhu) {
        this.cBeizhu = cBeizhu == null ? null : cBeizhu.trim();
    }

    public String getcCalculateddeduction() {
        return cCalculateddeduction;
    }

    public void setcCalculateddeduction(String cCalculateddeduction) {
        this.cCalculateddeduction = cCalculateddeduction == null ? null : cCalculateddeduction.trim();
    }

    public String getcActualdeduction() {
        return cActualdeduction;
    }

    public void setcActualdeduction(String cActualdeduction) {
        this.cActualdeduction = cActualdeduction == null ? null : cActualdeduction.trim();
    }

    public String getcCheckname() {
        return cCheckname;
    }

    public void setcCheckname(String cCheckname) {
        this.cCheckname = cCheckname == null ? null : cCheckname.trim();
    }

    public Date getcChecktime() {
        return cChecktime;
    }

    public void setcChecktime(Date cChecktime) {
        this.cChecktime = cChecktime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getcIs() {
        return cIs;
    }

    public void setcIs(String cIs) {
        this.cIs = cIs == null ? null : cIs.trim();
    }
}