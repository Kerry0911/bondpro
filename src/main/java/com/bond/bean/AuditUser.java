package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name ="audit_user" )
public class AuditUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uId;

    private String uUsercode;

    private String uPassword;

    private String state;

    private String uPqualification;

    private String uUsername;

    private String uCode;

    private String uRole;

    private String uPost;

    private String uDept;

    private String uEmail;

    private String uPhone;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsercode() {
        return uUsercode;
    }

    public void setuUsercode(String uUsercode) {
        this.uUsercode = uUsercode == null ? null : uUsercode.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getuPqualification() {
        return uPqualification;
    }

    public void setuPqualification(String uPqualification) {
        this.uPqualification = uPqualification == null ? null : uPqualification.trim();
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode == null ? null : uCode.trim();
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole == null ? null : uRole.trim();
    }

    public String getuPost() {
        return uPost;
    }

    public void setuPost(String uPost) {
        this.uPost = uPost == null ? null : uPost.trim();
    }

    public String getuDept() {
        return uDept;
    }

    public void setuDept(String uDept) {
        this.uDept = uDept == null ? null : uDept.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }
}