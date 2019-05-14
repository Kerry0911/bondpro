package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name = "audit_attribute")
public class AuditAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;

    private String aName;

    private String aType;

    private String aJurisdiction;

    private String aCode;

    private Integer modelId;

    @Override
    public String toString() {
        return "AuditAttribute{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aType='" + aType + '\'' +
                ", aJurisdiction='" + aJurisdiction + '\'' +
                ", aCode='" + aCode + '\'' +
                ", modelId=" + modelId +
                '}';
    }

    public AuditAttribute(Integer aId, String aName, String aType, String aJurisdiction, String aCode, Integer modelId) {
        this.aId = aId;
        this.aName = aName;
        this.aType = aType;
        this.aJurisdiction = aJurisdiction;
        this.aCode = aCode;
        this.modelId = modelId;
    }

    public AuditAttribute() {
    }

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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}