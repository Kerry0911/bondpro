package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name = "audit_body")
public class AuditBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer abId;

    private String abName;

    private String abHigher;

    @Override
    public String toString() {
        return "AuditBody{" +
                "abId=" + abId +
                ", abName='" + abName + '\'' +
                ", abHigher='" + abHigher + '\'' +
                '}';
    }

    public AuditBody(Integer abId, String abName, String abHigher) {
        this.abId = abId;
        this.abName = abName;
        this.abHigher = abHigher;
    }

    public AuditBody() {
    }

    public Integer getAbId() {
        return abId;
    }

    public void setAbId(Integer abId) {
        this.abId = abId;
    }

    public String getAbName() {
        return abName;
    }

    public void setAbName(String abName) {
        this.abName = abName == null ? null : abName.trim();
    }

    public String getAbHigher() {
        return abHigher;
    }

    public void setAbHigher(String abHigher) {
        this.abHigher = abHigher == null ? null : abHigher.trim();
    }
}