package com.data.sesson19_webjava.controller;

import com.data.sesson19_webjava.entity.Movie;
import com.data.sesson19_webjava.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("movies", movieService.getAll());
        return "listMovie";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("formAction", "/movies/add");
        return "formMovie";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("movie") Movie movie,
                       BindingResult result,
                       Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formAction", "/movies/add");
            return "formMovie";
        }
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        model.addAttribute("formAction", "/movies/edit");
        return "formMovie";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("movie") Movie movie,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formAction", "/movies/edit");
            return "formMovie";
        }
        movieService.update(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieService.deleteOrDeactivate(id); // xóa hoặc chuyển status = false
        return "redirect:/movies";
    }
}
