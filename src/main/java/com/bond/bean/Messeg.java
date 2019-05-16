package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="messeg" )
public class Messeg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;

    private String mType;

    private String mInfo;

    private String mSend;

    private String mReception;

    private Date mSendtime;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public String getmInfo() {
        return mInfo;
    }

    public void setmInfo(String mInfo) {
        this.mInfo = mInfo == null ? null : mInfo.trim();
    }

    public String getmSend() {
        return mSend;
    }

    public void setmSend(String mSend) {
        this.mSend = mSend == null ? null : mSend.trim();
    }

    public String getmReception() {
        return mReception;
    }

    public void setmReception(String mReception) {
        this.mReception = mReception == null ? null : mReception.trim();
    }

    public Date getmSendtime() {
        return mSendtime;
    }

    public void setmSendtime(Date mSendtime) {
        this.mSendtime = mSendtime;
    }
}