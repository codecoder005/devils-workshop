package org.orgofarmsgroup.api.admin.service;

import org.orgofarmsgroup.api.admin.model.Admin;

public interface AdminService {
    Admin authenticate(Admin user);
}
