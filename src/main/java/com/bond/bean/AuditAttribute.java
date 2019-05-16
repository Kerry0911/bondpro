package com.bond.bean;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="audit_attribute" )
public class AuditAttribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;

    private String aName;

    private String aType;

    private String aJurisdiction;

    private String aCode;

    public AuditAttribute() {
    }

    public AuditAttribute(String aName, String aType, String aJurisdiction, String aCode, Model model) {
        this.aName = aName;
        this.aType = aType;
        this.aJurisdiction = aJurisdiction;
        this.aCode = aCode;
        this.model = model;
    }

    public AuditAttribute(String aName, String aType) {
        this.aName = aName;
        this.aType = aType;
    }

    private Model model;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType == null ? null : aType.trim();
    }

    public String getaJurisdiction() {
        return aJurisdiction;
    }

    public void setaJurisdiction(String aJurisdiction) {
        this.aJurisdiction = aJurisdiction == null ? null : aJurisdiction.trim();
    }

    public String getaCode() {
        return aCode;
    }

    public void setaCode(String aCode) {
        this.aCode = aCode == null ? null : aCode.trim();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}