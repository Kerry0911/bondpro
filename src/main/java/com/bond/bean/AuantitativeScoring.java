package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="auantitative_scoring" )
public class AuantitativeScoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asId;

    private String asName;

    private String asDeductionstandard;

    private String asActualdeduction;

    private String asCalculationdeduction;

    private String asFillpersonid;

    private String asDeduction;

    private String asIsnormal;

    private Date asFilltime;

    private String asProjectname;

    private String asDept;

    private Integer asColumnnumber;

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName == null ? null : asName.trim();
    }

    public String getAsDeductionstandard() {
        return asDeductionstandard;
    }

    public void setAsDeductionstandard(String asDeductionstandard) {
        this.asDeductionstandard = asDeductionstandard == null ? null : asDeductionstandard.trim();
    }

    public String getAsActualdeduction() {
        return asActualdeduction;
    }

    public void setAsActualdeduction(String asActualdeduction) {
        this.asActualdeduction = asActualdeduction == null ? null : asActualdeduction.trim();
    }

    public String getAsCalculationdeduction() {
        return asCalculationdeduction;
    }

    public void setAsCalculationdeduction(String asCalculationdeduction) {
        this.asCalculationdeduction = asCalculationdeduction == null ? null : asCalculationdeduction.trim();
    }

    public String getAsFillpersonid() {
        return asFillpersonid;
    }

    public void setAsFillpersonid(String asFillpersonid) {
        this.asFillpersonid = asFillpersonid == null ? null : asFillpersonid.trim();
    }

    public String getAsDeduction() {
        return asDeduction;
    }

    public void setAsDeduction(String asDeduction) {
        this.asDeduction = asDeduction == null ? null : asDeduction.trim();
    }

    public String getAsIsnormal() {
        return asIsnormal;
    }

    public void setAsIsnormal(String asIsnormal) {
        this.asIsnormal = asIsnormal == null ? null : asIsnormal.trim();
    }

    public Date getAsFilltime() {
        return asFilltime;
    }

    public void setAsFilltime(Date asFilltime) {
        this.asFilltime = asFilltime;
    }

    public String getAsProjectname() {
        return asProjectname;
    }

    public void setAsProjectname(String asProjectname) {
        this.asProjectname = asProjectname == null ? null : asProjectname.trim();
    }

    public String getAsDept() {
        return asDept;
    }

    public void setAsDept(String asDept) {
        this.asDept = asDept == null ? null : asDept.trim();
    }

    public Integer getAsColumnnumber() {
        return asColumnnumber;
    }

    public void setAsColumnnumber(Integer asColumnnumber) {
        this.asColumnnumber = asColumnnumber;
    }
}