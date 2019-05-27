package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "daibanthing")
public class Daibanthing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;
    private String dType;
    private String dThing;
    private String dSendpeople;
    private Date dSendtime;
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = AuditFangan.class)
    @JoinColumn(name = "fId",referencedColumnName = "fId")
    private AuditFangan auditFangan;
    private String state;
    //一个待办事项对应多个处理人
    @OneToMany(fetch = FetchType.LAZY,targetEntity =Officialdraft.class,mappedBy = "daibanthing")
    private List<Officialdraft> officialdrafts = new ArrayList<Officialdraft>();
    public Daibanthing(String dType, String dThing, String dSendpeople, Date dSendtime, int id, AuditFangan auditFangan, String state) {
        this.dType = dType;
        this.dThing = dThing;
        this.dSendpeople = dSendpeople;
        this.dSendtime = dSendtime;
        this.id = id;
        this.auditFangan = auditFangan;
        this.state = state;
    }

    public AuditFangan getAuditFangan() {
        return auditFangan;
    }

    public void setAuditFangan(AuditFangan auditFangan) {
        this.auditFangan = auditFangan;
    }

    public Daibanthing() {
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String getdThing() {
        return dThing;
    }

    public void setdThing(String dThing) {
        this.dThing = dThing;
    }

    public String getdSendpeople() {
        return dSendpeople;
    }

    public void setdSendpeople(String dSendpeople) {
        this.dSendpeople = dSendpeople;
    }

    public Date getdSendtime() {
        return dSendtime;
    }

    public void setdSendtime(Date dSendtime) {
        this.dSendtime = dSendtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
