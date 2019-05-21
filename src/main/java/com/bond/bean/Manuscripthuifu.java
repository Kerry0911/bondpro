package com.bond.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="manuscripthuifu" )
public class Manuscripthuifu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mhId;

    private String mhName;

    private String mhInfo;

    private Integer msId;

    private Date msTime;

    public Integer getMhId() {
        return mhId;
    }

    public void setMhId(Integer mhId) {
        this.mhId = mhId;
    }

    public String getMhName() {
        return mhName;
    }

    public void setMhName(String mhName) {
        this.mhName = mhName == null ? null : mhName.trim();
    }

    public String getMhInfo() {
        return mhInfo;
    }

    public void setMhInfo(String mhInfo) {
        this.mhInfo = mhInfo == null ? null : mhInfo.trim();
    }

    public Integer getMsId() {
        return msId;
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public Date getMsTime() {
        return msTime;
    }

    public void setMsTime(Date msTime) {
        this.msTime = msTime;
    }
}