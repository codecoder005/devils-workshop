package org.orgofarmsgroup.api.admin;

import org.orgofarmsgroup.api.admin.model.Admin;
import org.orgofarmsgroup.api.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String ping(){
        return "ADMIN Page API";
    }

    @GetMapping("/authorized")
    public String authorized(){
        return "Admin Authorized";
    }
    @GetMapping("/authorized/sub")
    public String authorizedSub(){
        return "Admin Authorized/Sub";
    }

    @PostMapping("/authenticate")
    public Admin authenticate(@RequestBody Admin admin){
        try{
            if(admin.getAdminId()!=null && admin.getAuthString()!=null){
                admin.setAuthString(Sha512DigestUtils.shaHex(admin.getAuthString()));
                return adminService.authenticate(admin);
            }
        }catch (Exception e){
            admin.setAdditionalInfo("Unable to process login!");
        }
        return admin;
    }
}
