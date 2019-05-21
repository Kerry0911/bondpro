package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="audit_knowledge_base" )
public class AuditKnowledgeBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kbId;

    private String kpInfo;

    private String kpName;

    private Date time;

    private String kpState;

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
    }

    public String getKpInfo() {
        return kpInfo;
    }

    public void setKpInfo(String kpInfo) {
        this.kpInfo = kpInfo == null ? null : kpInfo.trim();
    }

    public String getKpName() {
        return kpName;
    }

    public void setKpName(String kpName) {
        this.kpName = kpName == null ? null : kpName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getKpState() {
        return kpState;
    }

    public void setKpState(String kpState) {
        this.kpState = kpState == null ? null : kpState.trim();
    }
}