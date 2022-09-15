package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "/people")
public class UserController {

    private final UserService us;
    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", us.findAll());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", us.findById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user")  User user){
            us.createUser(user);
            return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", us.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user){
            us.createUser(user);
            return "redirect:/people";
        }


    @GetMapping("user-delete/{id}")
    public String delete(@PathVariable("id") Long id){
        us.deleteById(id);
        return "redirect:/people";
    }
}
