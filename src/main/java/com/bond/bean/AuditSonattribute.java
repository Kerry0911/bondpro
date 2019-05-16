package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="audit_sonattribute" )
public class AuditSonattribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sonaId;

    private String sonaCode;

    private Integer aId;

    public AuditSonattribute(String sonaCode, Integer aId, String sonaName) {
        this.sonaCode = sonaCode;
        this.aId = aId;
        this.sonaName = sonaName;
    }

    public AuditSonattribute() {
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = AuditAttribute.class)
    //@JoinColumn(name = "sonaId",referencedColumnName ="aId" )
    private AuditAttribute attribute;

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


    public AuditAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(AuditAttribute attribute) {
        this.attribute = attribute;
    }

    public String getSonaName() {
        return sonaName;
    }

    public void setSonaName(String sonaName) {
        this.sonaName = sonaName == null ? null : sonaName.trim();
    }
}