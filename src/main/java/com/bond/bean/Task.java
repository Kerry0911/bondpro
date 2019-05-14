package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name ="task" )
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;

    private Integer ppId;

    private String tName;

    private String tAuditpoints;

    private String tCode;

    private String tState;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettAuditpoints() {
        return tAuditpoints;
    }

    public void settAuditpoints(String tAuditpoints) {
        this.tAuditpoints = tAuditpoints == null ? null : tAuditpoints.trim();
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode == null ? null : tCode.trim();
    }

    public String gettState() {
        return tState;
    }

    public void settState(String tState) {
        this.tState = tState == null ? null : tState.trim();
    }
}