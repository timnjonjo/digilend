package com.timnjonjo.digilend.authprovider.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timnjonjo.digilend.infra.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "UniqueUserNameConstraint", columnNames = "user_name")
})
@Builder
@AllArgsConstructor
public class User extends Auditable implements Serializable {
    private static final long serialVersionUID = 8819401178958465483L;
    @Column(name = "user_name", unique = true)
    private String username;
    private String fullname;
    @JsonIgnore
    private String password;
    private boolean enabled;
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean accountLocked = false;
    private boolean tokenExpired;
    @Column(name = "credentials_expiry_date", nullable = false)
    private Date credentialsExpiryDate = new Date();
    private Integer loginAttempts = 0;
    private Date lastLogin;

    @ManyToOne(optional = false)
    private Role role;


    public User() {
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getCredentialsExpiryDate() {
        return credentialsExpiryDate;
    }

    public void setCredentialsExpiryDate(Date credentialsExpiryDate) {
        this.credentialsExpiryDate = credentialsExpiryDate;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }


}
