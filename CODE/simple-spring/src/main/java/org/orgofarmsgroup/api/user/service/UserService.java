package org.orgofarmsgroup.api.user.service;

import org.orgofarmsgroup.api.user.model.ChangePasswordModel;
import org.orgofarmsgroup.api.user.model.User;

public interface UserService {
    void changePassword(ChangePasswordModel changePasswordModel);
    User authenticate(User user);
}
