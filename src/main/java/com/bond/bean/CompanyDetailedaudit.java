package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="company_detailedaudit" )
public class CompanyDetailedaudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cddId;

    private String cddCheckxiang;

    private String cddName;

    private String cddRiskthings;

    private String cddIstrue;

    private String cddBeizhu;

    private String cddAddriskthings;

    private Date cddChecktime;

    private Integer ppId;

    private String cddIs;

    public Integer getCddId() {
        return cddId;
    }

    public void setCddId(Integer cddId) {
        this.cddId = cddId;
    }

    public String getCddCheckxiang() {
        return cddCheckxiang;
    }

    public void setCddCheckxiang(String cddCheckxiang) {
        this.cddCheckxiang = cddCheckxiang == null ? null : cddCheckxiang.trim();
    }

    public String getCddName() {
        return cddName;
    }

    public void setCddName(String cddName) {
        this.cddName = cddName == null ? null : cddName.trim();
    }

    public String getCddRiskthings() {
        return cddRiskthings;
    }

    public void setCddRiskthings(String cddRiskthings) {
        this.cddRiskthings = cddRiskthings == null ? null : cddRiskthings.trim();
    }

    public String getCddIstrue() {
        return cddIstrue;
    }

    public void setCddIstrue(String cddIstrue) {
        this.cddIstrue = cddIstrue == null ? null : cddIstrue.trim();
    }

    public String getCddBeizhu() {
        return cddBeizhu;
    }

    public void setCddBeizhu(String cddBeizhu) {
        this.cddBeizhu = cddBeizhu == null ? null : cddBeizhu.trim();
    }

    public String getCddAddriskthings() {
        return cddAddriskthings;
    }

    public void setCddAddriskthings(String cddAddriskthings) {
        this.cddAddriskthings = cddAddriskthings == null ? null : cddAddriskthings.trim();
    }

    public Date getCddChecktime() {
        return cddChecktime;
    }

    public void setCddChecktime(Date cddChecktime) {
        this.cddChecktime = cddChecktime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getCddIs() {
        return cddIs;
    }

    public void setCddIs(String cddIs) {
        this.cddIs = cddIs == null ? null : cddIs.trim();
    }
}