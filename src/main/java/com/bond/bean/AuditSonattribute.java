package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name ="audit_osnattribute" )
public class AuditSonattribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sonaId;

    private String sonaCode;

    private Integer aId;

    private String sonaName;

    public Integer getSonaId() {
        return sonaId;
    }

    public void setSonaId(Integer sonaId) {
        this.sonaId = sonaId;
    }

    public String getSonaCode() {
        return sonaCode;
    }

    public void setSonaCode(String sonaCode) {
        this.sonaCode = sonaCode == null ? null : sonaCode.trim();
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getSonaName() {
        return sonaName;
    }

    public void setSonaName(String sonaName) {
        this.sonaName = sonaName == null ? null : sonaName.trim();
    }
}