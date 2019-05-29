package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "projectfile")
public class Projectfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filename;
    private Date shangchuantime;
    private String filelujing;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = AuditPlanproject.class)
    @JoinColumn(name = "ppId",referencedColumnName = "ppId")
    private AuditPlanproject auditPlanproject;
    private Integer filetype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getShangchuantime() {
        return shangchuantime;
    }

    public void setShangchuantime(Date shangchuantime) {
        this.shangchuantime = shangchuantime;
    }

    public String getFilelujing() {
        return filelujing;
    }

    public void setFilelujing(String filelujing) {
        this.filelujing = filelujing;
    }

    public AuditPlanproject getAuditPlanproject() {
        return auditPlanproject;
    }

    public void setAuditPlanproject(AuditPlanproject auditPlanproject) {
        this.auditPlanproject = auditPlanproject;
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }
}
