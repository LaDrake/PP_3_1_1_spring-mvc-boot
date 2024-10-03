package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    private final UserService userService;
        @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String findUser(@RequestParam() Model model) {
        model.addAttribute("list", userService.findAll());
        return "user";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
            model.addAttribute("user", new User());
            return "info";
    }
    @GetMapping("/{id}/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
            model.addAttribute("user", userService.findById(id));
            return "edit";
    }
    @PostMapping("{id}")
    public String update(@ModelAttribute("user") User user) {
            userService.update(user);
            return "redirect:/";
    }
    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute int id) {
            userService.delete(id);
            return "redirect:/";
    }
}
