package org.orgofarmsgroup.api.user.service.impl;

import org.orgofarmsgroup.api.user.model.ChangePasswordModel;
import org.orgofarmsgroup.api.user.model.User;
import org.orgofarmsgroup.api.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void changePassword(ChangePasswordModel changePasswordModel) {

    }
    private static final String qryAuthenticateUser = new StringBuilder("SELECT * FROM T_USER_SECURE ")
                                                    .append("WHERE USER_ID = ? ")
                                                    .append("AND AUTH_STRING = ? ")
                                                    .toString();
    private static final String qryUpdateAuthenticatedUser = new StringBuilder("UPDATE T_USER_SECURE ")
                                                    .append("SET LAST_LOGIN_TIME_DATE = CURRENT_TIMESTAMP ")
                                                    .append("WHERE USER_ID = ? ")
                                                    .toString();
    private static final String qryUpdateUserAuthenticationFailedFields = new StringBuilder("UPDATE T_USER_SECURE ")
                                                    .append("SET LAST_LOGIN_FAILED_TIME_DATE = CURRENT_TIMESTAMP ")
                                                    .append("WHERE USER_ID = ? ")
                                                    .toString();
    @Override
    public User authenticate(User user) {
        try{
            User verifiedUser = jdbcTemplate.queryForObject(
                    qryAuthenticateUser,
                    new BeanPropertyRowMapper<>(User.class),
                    new Object[]{
                            user.getUserId(),
                            user.getAuthString()
                    }
            );
            verifiedUser.setAuthString(null);
            jdbcTemplate.update(qryUpdateAuthenticatedUser, verifiedUser.getUserId());
            return verifiedUser;
        }catch (Exception e){
            jdbcTemplate.update(qryUpdateUserAuthenticationFailedFields, user.getUserId());
            user.setAdditionalInfo("Invalid username or password!");
            return user;
        }
    }

}
