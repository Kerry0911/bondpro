package com.bond.bean;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="audit_attribute" )
public class AuditAttribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;

    private String aName;

    private String aType;

    private String aJurisdiction;

    @Column(insertable = false,updatable = false)
    private Integer modelId;


    public AuditAttribute(String aName, Integer modelId) {
        this.aName = aName;
        this.modelId = modelId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @OneToMany(fetch = FetchType.LAZY,targetEntity = AuditSonattribute.class,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "aId",referencedColumnName ="aId" )
    private List<AuditSonattribute> sonattributes=new ArrayList<>();

   // @ManyToOne(fetch = FetchType.LAZY,targetEntity = Model.class)
    private Model model;

    public AuditAttribute() {
    }

    public AuditAttribute(String aName, String aType, String aJurisdiction, List<AuditSonattribute> sonattributes, Model model) {
        this.aName = aName;
        this.aType = aType;
        this.aJurisdiction = aJurisdiction;
        this.sonattributes = sonattributes;
        this.model = model;
    }

    public AuditAttribute(String aName, String aType) {
        this.aName = aName;
        this.aType = aType;
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
        this.aName = aName;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public String getaJurisdiction() {
        return aJurisdiction;
    }

    public void setaJurisdiction(String aJurisdiction) {
        this.aJurisdiction = aJurisdiction;
    }

    public List<AuditSonattribute> getSonattributes() {
        return sonattributes;
    }

    public void setSonattributes(List<AuditSonattribute> sonattributes) {
        this.sonattributes = sonattributes;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}