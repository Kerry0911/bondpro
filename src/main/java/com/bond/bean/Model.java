package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="model" )
public class Model  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelId;

    private String modelName;

    @OneToMany(fetch =FetchType.LAZY,targetEntity = AuditAttribute.class,mappedBy = "model")
    private List<AuditAttribute> auditAttributes=new ArrayList<>();

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public List<AuditAttribute> getAuditAttributes() {
        return auditAttributes;
    }

    public void setAuditAttributes(List<AuditAttribute> auditAttributes) {
        this.auditAttributes = auditAttributes;
    }

    public Model() {
    }

    public Model(String modelName) {
        this.modelName = modelName;
    }
}