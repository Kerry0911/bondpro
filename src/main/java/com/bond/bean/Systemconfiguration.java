package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="systemconfiguration" )
public class Systemconfiguration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String configcode;

    private String configname;

    private String configvalueid;

    private String configvaluename;

    private Integer isstart;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigcode() {
        return configcode;
    }

    public void setConfigcode(String configcode) {
        this.configcode = configcode == null ? null : configcode.trim();
    }

    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname == null ? null : configname.trim();
    }

    public String getConfigvalueid() {
        return configvalueid;
    }

    public void setConfigvalueid(String configvalueid) {
        this.configvalueid = configvalueid == null ? null : configvalueid.trim();
    }

    public String getConfigvaluename() {
        return configvaluename;
    }

    public void setConfigvaluename(String configvaluename) {
        this.configvaluename = configvaluename == null ? null : configvaluename.trim();
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}