package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="sale_detailedaudit" )
public class SaleDetailedaudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ddId;

    private String ddCheckxiang;

    private String ddName;

    private String ddViolation;

    private String ddIstrue;

    private String ddDeduction;

    private String ddShoud;

    private String ddBeizhu;

    private String ddCalculateddeduction;

    private String ddActualdeduction;

    private Date ddChecktime;

    private Integer ppId;

    private String ddIs;

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public String getDdCheckxiang() {
        return ddCheckxiang;
    }

    public void setDdCheckxiang(String ddCheckxiang) {
        this.ddCheckxiang = ddCheckxiang == null ? null : ddCheckxiang.trim();
    }

    public String getDdName() {
        return ddName;
    }

    public void setDdName(String ddName) {
        this.ddName = ddName == null ? null : ddName.trim();
    }

    public String getDdViolation() {
        return ddViolation;
    }

    public void setDdViolation(String ddViolation) {
        this.ddViolation = ddViolation == null ? null : ddViolation.trim();
    }

    public String getDdIstrue() {
        return ddIstrue;
    }

    public void setDdIstrue(String ddIstrue) {
        this.ddIstrue = ddIstrue == null ? null : ddIstrue.trim();
    }

    public String getDdDeduction() {
        return ddDeduction;
    }

    public void setDdDeduction(String ddDeduction) {
        this.ddDeduction = ddDeduction == null ? null : ddDeduction.trim();
    }

    public String getDdShoud() {
        return ddShoud;
    }

    public void setDdShoud(String ddShoud) {
        this.ddShoud = ddShoud == null ? null : ddShoud.trim();
    }

    public String getDdBeizhu() {
        return ddBeizhu;
    }

    public void setDdBeizhu(String ddBeizhu) {
        this.ddBeizhu = ddBeizhu == null ? null : ddBeizhu.trim();
    }

    public String getDdCalculateddeduction() {
        return ddCalculateddeduction;
    }

    public void setDdCalculateddeduction(String ddCalculateddeduction) {
        this.ddCalculateddeduction = ddCalculateddeduction == null ? null : ddCalculateddeduction.trim();
    }

    public String getDdActualdeduction() {
        return ddActualdeduction;
    }

    public void setDdActualdeduction(String ddActualdeduction) {
        this.ddActualdeduction = ddActualdeduction == null ? null : ddActualdeduction.trim();
    }

    public Date getDdChecktime() {
        return ddChecktime;
    }

    public void setDdChecktime(Date ddChecktime) {
        this.ddChecktime = ddChecktime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getDdIs() {
        return ddIs;
    }

    public void setDdIs(String ddIs) {
        this.ddIs = ddIs == null ? null : ddIs.trim();
    }
}