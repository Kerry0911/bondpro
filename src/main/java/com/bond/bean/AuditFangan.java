package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name ="audit_fangan" )
public class AuditFangan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fId;

    private Integer ppId;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }
}