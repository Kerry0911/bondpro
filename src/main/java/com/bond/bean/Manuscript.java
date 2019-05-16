package com.bond.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name ="manuscript" )
public class Manuscript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msId;

    private String msInfo;

    private String msAdvice;

    private String msChecktype;

    private String msState;

    private String msTitle;

    private String msPeople;

    private Date msTime;

    public Integer getMsId() {
        return msId;
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public String getMsInfo() {
        return msInfo;
    }

    public void setMsInfo(String msInfo) {
        this.msInfo = msInfo == null ? null : msInfo.trim();
    }

    public String getMsAdvice() {
        return msAdvice;
    }

    public void setMsAdvice(String msAdvice) {
        this.msAdvice = msAdvice == null ? null : msAdvice.trim();
    }

    public String getMsChecktype() {
        return msChecktype;
    }

    public void setMsChecktype(String msChecktype) {
        this.msChecktype = msChecktype == null ? null : msChecktype.trim();
    }

    public String getMsState() {
        return msState;
    }

    public void setMsState(String msState) {
        this.msState = msState == null ? null : msState.trim();
    }

    public String getMsTitle() {
        return msTitle;
    }

    public void setMsTitle(String msTitle) {
        this.msTitle = msTitle == null ? null : msTitle.trim();
    }

    public String getMsPeople() {
        return msPeople;
    }

    public void setMsPeople(String msPeople) {
        this.msPeople = msPeople == null ? null : msPeople.trim();
    }

    public Date getMsTime() {
        return msTime;
    }

    public void setMsTime(Date msTime) {
        this.msTime = msTime;
    }
}