package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="audit_joblog" )
public class AuditJoblog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jId;

    private Date jTime;

    private String jInfo;

    private String jProblem;

    private String iNothing;

    private String jTomorrowplan;

    private Integer uId;

    private Date jSubmittime;

    private String jProjectname;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Date getjTime() {
        return jTime;
    }

    public void setjTime(Date jTime) {
        this.jTime = jTime;
    }

    public String getjInfo() {
        return jInfo;
    }

    public void setjInfo(String jInfo) {
        this.jInfo = jInfo == null ? null : jInfo.trim();
    }

    public String getjProblem() {
        return jProblem;
    }

    public void setjProblem(String jProblem) {
        this.jProblem = jProblem == null ? null : jProblem.trim();
    }

    public String getiNothing() {
        return iNothing;
    }

    public void setiNothing(String iNothing) {
        this.iNothing = iNothing == null ? null : iNothing.trim();
    }

    public String getjTomorrowplan() {
        return jTomorrowplan;
    }

    public void setjTomorrowplan(String jTomorrowplan) {
        this.jTomorrowplan = jTomorrowplan == null ? null : jTomorrowplan.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getjSubmittime() {
        return jSubmittime;
    }

    public void setjSubmittime(Date jSubmittime) {
        this.jSubmittime = jSubmittime;
    }

    public String getjProjectname() {
        return jProjectname;
    }

    public void setjProjectname(String jProjectname) {
        this.jProjectname = jProjectname == null ? null : jProjectname.trim();
    }
}