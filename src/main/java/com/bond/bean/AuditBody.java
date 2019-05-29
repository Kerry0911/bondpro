package com.bond.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="audit_body" )
public class AuditBody  {
    @Id
    private String abId;

    private String abName;

    private String abHigher;

    public String getAbId() {
        return abId;
    }

    public void setAbId(String abId) {
        this.abId = abId == null ? null : abId.trim();
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