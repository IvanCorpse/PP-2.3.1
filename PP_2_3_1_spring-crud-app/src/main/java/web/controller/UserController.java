package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller("userController")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap model) {
        model.addAttribute("usersList", userService.getUsers());
        return "userTable";
    }

    @GetMapping("/showUser")
    public String showUser(@RequestParam("id") Integer id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("id") Integer id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "editUser";
    }

    @PutMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/removeUser")
    public String removeUser(@RequestParam("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

}
