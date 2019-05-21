package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="auditchecklist" )
public class Auditchecklist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String acCheckxiang;

    private String acDataclassdeduction;

    private String acComprehensivededuction;

    private String acProblem;

    private String acProblementry;

    private String acPeoblemname;

    private String acCalculateddeduction;

    private String acActualdeduction;

    private String acJiherenyuan;

    private Date acJihetime;

    private Integer ppId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcCheckxiang() {
        return acCheckxiang;
    }

    public void setAcCheckxiang(String acCheckxiang) {
        this.acCheckxiang = acCheckxiang == null ? null : acCheckxiang.trim();
    }

    public String getAcDataclassdeduction() {
        return acDataclassdeduction;
    }

    public void setAcDataclassdeduction(String acDataclassdeduction) {
        this.acDataclassdeduction = acDataclassdeduction == null ? null : acDataclassdeduction.trim();
    }

    public String getAcComprehensivededuction() {
        return acComprehensivededuction;
    }

    public void setAcComprehensivededuction(String acComprehensivededuction) {
        this.acComprehensivededuction = acComprehensivededuction == null ? null : acComprehensivededuction.trim();
    }

    public String getAcProblem() {
        return acProblem;
    }

    public void setAcProblem(String acProblem) {
        this.acProblem = acProblem == null ? null : acProblem.trim();
    }

    public String getAcProblementry() {
        return acProblementry;
    }

    public void setAcProblementry(String acProblementry) {
        this.acProblementry = acProblementry == null ? null : acProblementry.trim();
    }

    public String getAcPeoblemname() {
        return acPeoblemname;
    }

    public void setAcPeoblemname(String acPeoblemname) {
        this.acPeoblemname = acPeoblemname == null ? null : acPeoblemname.trim();
    }

    public String getAcCalculateddeduction() {
        return acCalculateddeduction;
    }

    public void setAcCalculateddeduction(String acCalculateddeduction) {
        this.acCalculateddeduction = acCalculateddeduction == null ? null : acCalculateddeduction.trim();
    }

    public String getAcActualdeduction() {
        return acActualdeduction;
    }

    public void setAcActualdeduction(String acActualdeduction) {
        this.acActualdeduction = acActualdeduction == null ? null : acActualdeduction.trim();
    }

    public String getAcJiherenyuan() {
        return acJiherenyuan;
    }

    public void setAcJiherenyuan(String acJiherenyuan) {
        this.acJiherenyuan = acJiherenyuan == null ? null : acJiherenyuan.trim();
    }

    public Date getAcJihetime() {
        return acJihetime;
    }

    public void setAcJihetime(Date acJihetime) {
        this.acJihetime = acJihetime;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }
}