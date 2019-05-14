package com.bond.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_knowledge_base")
public class AuditKnowledgeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kbId;

    private String kpInfo;

    private String kpName;

    private Date time;

    private String kpState;

    @Override
    public String toString() {
        return "AuditKnowledgeBase{" +
                "kbId=" + kbId +
                ", kpInfo='" + kpInfo + '\'' +
                ", kpName='" + kpName + '\'' +
                ", time=" + time +
                ", kpState='" + kpState + '\'' +
                '}';
    }

    public AuditKnowledgeBase(Integer kbId, String kpInfo, String kpName, Date time, String kpState) {
        this.kbId = kbId;
        this.kpInfo = kpInfo;
        this.kpName = kpName;
        this.time = time;
        this.kpState = kpState;
    }

    public AuditKnowledgeBase() {
    }

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