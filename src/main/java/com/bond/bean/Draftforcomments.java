package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name = "draftforcomments")
public class Draftforcomments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ppId;

    private Integer pId;

    @Override
    public String toString() {
        return "Draftforcomments{" +
                "id=" + id +
                ", ppId=" + ppId +
                ", pId=" + pId +
                '}';
    }

    public Draftforcomments(Integer id, Integer ppId, Integer pId) {
        this.id = id;
        this.ppId = ppId;
        this.pId = pId;
    }

    public Draftforcomments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}