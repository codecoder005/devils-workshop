package org.orgofarmsgroup.api.admin.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Admin implements Comparable<Admin>, Serializable {
    private String adminId;
    private String emailId;
    private String authString;
    private String accountLocked;
    private Timestamp lastAccountLockedTimeDate;
    private Timestamp lastLoginTimeDate;
    private Timestamp lastLoginFailedTimeDate;
    private Timestamp lastPasswordChangedTimeDate;
    private String additionalInfo;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }

    public String getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(String accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Timestamp getLastAccountLockedTimeDate() {
        return lastAccountLockedTimeDate;
    }

    public void setLastAccountLockedTimeDate(Timestamp lastAccountLockedTimeDate) {
        this.lastAccountLockedTimeDate = lastAccountLockedTimeDate;
    }

    public Timestamp getLastLoginTimeDate() {
        return lastLoginTimeDate;
    }

    public void setLastLoginTimeDate(Timestamp lastLoginTimeDate) {
        this.lastLoginTimeDate = lastLoginTimeDate;
    }

    public Timestamp getLastLoginFailedTimeDate() {
        return lastLoginFailedTimeDate;
    }

    public void setLastLoginFailedTimeDate(Timestamp lastLoginFailedTimeDate) {
        this.lastLoginFailedTimeDate = lastLoginFailedTimeDate;
    }

    public Timestamp getLastPasswordChangedTimeDate() {
        return lastPasswordChangedTimeDate;
    }

    public void setLastPasswordChangedTimeDate(Timestamp lastPasswordChangedTimeDate) {
        this.lastPasswordChangedTimeDate = lastPasswordChangedTimeDate;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminId.equals(admin.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId);
    }

    @Override
    public int compareTo(@NotNull Admin o) {
        return 0;
    }
}
