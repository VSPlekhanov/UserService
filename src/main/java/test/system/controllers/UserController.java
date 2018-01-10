package test.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.system.model.User;
import test.system.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    String getAllUsers(){
        String users = "";
        for (User user : userService.getAllUsers()) users = users.concat(user.toString());
        return users;
    }
}
