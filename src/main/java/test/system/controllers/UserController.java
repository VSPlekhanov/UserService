package test.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import test.system.model.User;
import test.system.services.UserService;

import java.util.HashSet;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    String getAllUsers() {
        String users = "";
        for (User user : userService.getAllUsers()) users = users.concat(user.toString());
        return users;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView checkUser(@ModelAttribute("userFromServer") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName((new HashSet<>(userService.getAllUsers()).contains(user) ? "valid" : "invalid"));
        return modelAndView;
    }
}
