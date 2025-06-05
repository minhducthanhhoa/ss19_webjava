package com.data.sesson19_webjava.controller;

import com.data.sesson19_webjava.entity.Theater;
import com.data.sesson19_webjava.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
    @Autowired
    private TheaterService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("theaters", service.getAll());
        return "listTheater";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("theater", new Theater());
        model.addAttribute("formAction", "/theaters/add");
        return "formTheater";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("theater") Theater theater,
                       BindingResult result,
                       Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formAction", "/theaters/add");
            return "formTheater";
        }
        service.save(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("theater", service.getById(id));
        model.addAttribute("formAction", "/theaters/edit");
        return "formTheater";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("theater") Theater theater,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formAction", "/theaters/edit");
            return "formTheater";
        }
        service.update(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteOrDeactivate(id);
        return "redirect:/theaters";
    }
}
