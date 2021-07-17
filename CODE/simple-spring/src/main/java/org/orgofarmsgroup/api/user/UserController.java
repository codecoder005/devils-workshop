package org.orgofarmsgroup.api.user;

import org.orgofarmsgroup.api.user.model.ChangePasswordModel;
import org.orgofarmsgroup.api.user.model.User;
import org.orgofarmsgroup.api.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/authorized/change-password")
    public String changePassword(@RequestBody ChangePasswordModel changePasswordModel){
        LOGGER.info("change-password request");
        userService.changePassword(changePasswordModel);
        return "Password changed successfully!";
    }
    @GetMapping("/authorized")
    public String pingAuth(){
        return "AUTHORIZED page API";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String userId, @RequestParam String password){
        LOGGER.info("new login request");
        return "SUCCESS";
    }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody  User user){
        LOGGER.info("TRYING TO AUTHENTICATE");
        try{
            if(user.getUserId() != null && user.getAuthString() != null){
                user.setAuthString(Sha512DigestUtils.shaHex(user.getAuthString()));
                userService.authenticate(user);
            }
        }catch (Exception e){
            user.setAdditionalInfo("Invalid username or password!");
        }
        return user;
    }

    @GetMapping
    public String pingUser(){
        return "USER API page";
    }

}
