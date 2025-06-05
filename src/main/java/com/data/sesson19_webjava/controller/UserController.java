package com.data.sesson19_webjava.controller;

import com.data.sesson19_webjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size) {
        long totalUsers = userService.countUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", userService.getUsers(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "userList";
    }

    @GetMapping("/toggle/{id}")
    public String toggleUserStatus(@PathVariable("id") Long id,
                                   @RequestParam(defaultValue = "1") int page) {
        userService.toggleActive(id);
        return "redirect:/users?page=" + page;
    }
}
