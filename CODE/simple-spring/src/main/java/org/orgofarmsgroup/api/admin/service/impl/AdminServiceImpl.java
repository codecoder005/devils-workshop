package org.orgofarmsgroup.api.admin.service.impl;

import org.orgofarmsgroup.api.admin.model.Admin;
import org.orgofarmsgroup.api.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String qryAuthenticateAdmin = new StringBuilder("SELECT * FROM T_ADMIN_SECURE ")
            .append("WHERE ADMIN_ID = ? ")
            .append("AND AUTH_STRING = ? ")
            .toString();
    private static final String qryUpdateAuthenticatedAdmin = new StringBuilder("UPDATE T_ADMIN_SECURE ")
            .append("SET LAST_LOGIN_TIME_DATE = CURRENT_TIMESTAMP ")
            .append("WHERE ADMIN_ID = ? ")
            .toString();
    private static final String qryUpdateAdminAuthenticationFailedFields = new StringBuilder("UPDATE T_ADMIN_SECURE ")
            .append("SET LAST_LOGIN_FAILED_TIME_DATE = CURRENT_TIMESTAMP ")
            .append("WHERE ADMIN_ID = ? ")
            .toString();
    
    @Override
    public Admin authenticate(Admin admin) {
        try{
            Admin verifiedAdmin = jdbcTemplate.queryForObject(
                    qryAuthenticateAdmin,
                    new BeanPropertyRowMapper<>(Admin.class),
                    admin.getAdminId(),
                    admin.getAuthString()
            );
            verifiedAdmin.setAuthString(null);
            jdbcTemplate.update(qryUpdateAuthenticatedAdmin, verifiedAdmin.getAdminId());
            verifiedAdmin.setAdditionalInfo("LOGIN SUCCESS");
            return verifiedAdmin;
        }catch (EmptyResultDataAccessException e){
            jdbcTemplate.update(qryUpdateAdminAuthenticationFailedFields, admin.getAdminId());
            admin.setAdditionalInfo("Invalid admin id or password!");
            return admin;
        }
    }
}
