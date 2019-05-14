package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelId;

    private String modelName;

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    public Model(Integer modelId, String modelName) {
        this.modelId = modelId;
        this.modelName = modelName;
    }

    public Model() {
    }

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
}