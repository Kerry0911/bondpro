package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="audit_fangan" )
public class AuditFangan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fId;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = AuditPlanproject.class)
    @JoinColumn(name = "ppId",referencedColumnName = "ppId")
    private AuditPlanproject auditPlanproject;

    private String fDes;
    @OneToMany(fetch = FetchType.LAZY,targetEntity =Daibanthing.class,mappedBy = "auditFangan")
    private List<Daibanthing> daibanthings = new ArrayList<Daibanthing>();
    public String getfDes() {
        return fDes;
    }

    public void setfDes(String fDes) {
        this.fDes = fDes;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public AuditPlanproject getAuditPlanproject() {
        return auditPlanproject;
    }

    public void setAuditPlanproject(AuditPlanproject auditPlanproject) {
        this.auditPlanproject = auditPlanproject;
    }
}