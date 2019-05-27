package com.bond.bean;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "projectrole")
public class Projectrole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = AuditPlanproject.class)
    @JoinColumn(name = "ppid",referencedColumnName = "ppId")
    private AuditPlanproject auditPlanproject;
    private String zhushen;
    private String zhushenrole;
    private String zhushenpqualification;
    private String zs;
    private String zsrole;
    private String zspqualification;
    private String jd;

    public Projectrole(AuditPlanproject auditPlanproject, String zhushen, String zhushenrole, String zhushenpqualification, String zs, String zsrole, String zspqualification, String jd) {
        this.auditPlanproject = auditPlanproject;
        this.zhushen = zhushen;
        this.zhushenrole = zhushenrole;
        this.zhushenpqualification = zhushenpqualification;
        this.zs = zs;
        this.zsrole = zsrole;
        this.zspqualification = zspqualification;
        this.jd = jd;
    }

    public Projectrole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuditPlanproject getAuditPlanproject() {
        return auditPlanproject;
    }

    public void setAuditPlanproject(AuditPlanproject auditPlanproject) {
        this.auditPlanproject = auditPlanproject;
    }

    public String getZhushen() {
        return zhushen;
    }

    public void setZhushen(String zhushen) {
        this.zhushen = zhushen;
    }

    public String getZhushenrole() {
        return zhushenrole;
    }

    public void setZhushenrole(String zhushenrole) {
        this.zhushenrole = zhushenrole;
    }

    public String getZhushenpqualification() {
        return zhushenpqualification;
    }

    public void setZhushenpqualification(String zhushenpqualification) {
        this.zhushenpqualification = zhushenpqualification;
    }

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    public String getZsrole() {
        return zsrole;
    }

    public void setZsrole(String zsrole) {
        this.zsrole = zsrole;
    }

    public String getZspqualification() {
        return zspqualification;
    }

    public void setZspqualification(String zspqualification) {
        this.zspqualification = zspqualification;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }
}
