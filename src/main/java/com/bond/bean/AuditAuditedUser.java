package com.bond.bean;

import javax.persistence.*;

@Entity
@Table(name = "audit_audited_user")
public class AuditAuditedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String name;

    private String email;

    private String phone;

    private String rtx;

    private String state;

    private Integer auditedId;

    @Override
    public String toString() {
        return "AuditAuditedUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", rtx='" + rtx + '\'' +
                ", state='" + state + '\'' +
                ", auditedId=" + auditedId +
                '}';
    }

    public AuditAuditedUser(Integer id, String username, String name, String email, String phone, String rtx, String state, Integer auditedId) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rtx = rtx;
        this.state = state;
        this.auditedId = auditedId;
    }

    public AuditAuditedUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRtx() {
        return rtx;
    }

    public void setRtx(String rtx) {
        this.rtx = rtx == null ? null : rtx.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getAuditedId() {
        return auditedId;
    }

    public void setAuditedId(Integer auditedId) {
        this.auditedId = auditedId;
    }
}