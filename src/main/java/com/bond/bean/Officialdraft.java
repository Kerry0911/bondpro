package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "officialdraft")
public class Officialdraft implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oId;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Daibanthing.class)
    @JoinColumn(name = "dId",referencedColumnName = "dId")
    private Daibanthing daibanthing;
    private String oJieshoudept;
    private String oCaozuo;
    private String oJianyi;
    private Integer state;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Daibanthing getDaibanthing() {
        return daibanthing;
    }

    public void setDaibanthing(Daibanthing daibanthing) {
        this.daibanthing = daibanthing;
    }

    public String getoJieshoudept() {
        return oJieshoudept;
    }

    public void setoJieshoudept(String oJieshoudept) {
        this.oJieshoudept = oJieshoudept;
    }

    public String getoCaozuo() {
        return oCaozuo;
    }

    public void setoCaozuo(String oCaozuo) {
        this.oCaozuo = oCaozuo;
    }

    public String getoJianyi() {
        return oJianyi;
    }

    public void setoJianyi(String oJianyi) {
        this.oJianyi = oJianyi;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
