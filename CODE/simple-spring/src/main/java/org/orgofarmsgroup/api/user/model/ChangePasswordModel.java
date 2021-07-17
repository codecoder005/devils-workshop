package org.orgofarmsgroup.api.user.model;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ChangePasswordModel {
    private String userId;
    private String currentPassword;
    private String newPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
