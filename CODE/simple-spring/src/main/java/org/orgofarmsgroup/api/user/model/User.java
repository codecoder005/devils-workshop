package org.orgofarmsgroup.api.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class User implements Comparable<User>, Serializable {
    private String userId;
    private String emailId;
    private String authString;
    private String accountLocked;
    private Timestamp lastAccountLockedTimeDate;
    private Timestamp lastLoginTimeDate;
    private Timestamp lastLoginFailedTimeDate;
    private Timestamp lastPasswordChangedTimeDate;
    private String additionalInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    public int compareTo(@NotNull User o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", authString='" + authString + '\'' +
                ", accountLocked='" + accountLocked + '\'' +
                ", lastAccountLockedTimeDate=" + lastAccountLockedTimeDate +
                ", lastLoginTimeDate=" + lastLoginTimeDate +
                ", lastLoginFailedTimeDate=" + lastLoginFailedTimeDate +
                ", lastPasswordChangedTimeDate=" + lastPasswordChangedTimeDate +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
