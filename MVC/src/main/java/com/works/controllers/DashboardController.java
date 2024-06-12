package com.works.controllers;

import com.works.entities.Category;
import com.works.entities.Film;
import com.works.services.CategoryService;
import com.works.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    final CategoryService categoryService;
    final FilmService filmService;

    @GetMapping("dashboard")
    public String dashboard(Model model){
        List<Category> categories = categoryService.categoryList();
        List<Film> films = filmService.allFilm();
        model.addAttribute("categories", categories);
        model.addAttribute("films", films);
        return "dashboard";
    }

    @PostMapping("filmAdd")
    public String filmAdd(Film film) {
        filmService.add(film);
        System.out.println(film);
        return "redirect:/dashboard";
    }

    @GetMapping("filmDelete/{fid}")
    public String filmDelete(@PathVariable Long fid) {
        System.out.println("fid :" + fid);
        filmService.deleteFilm(fid);
        return "redirect:/dashboard";
    }

}
