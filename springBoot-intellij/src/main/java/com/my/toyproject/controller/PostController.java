package com.my.toyproject.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @GetMapping({"", "/"})
    public String getPostList(@RequestParam("username") Optional<String> name, Model model) {
        if(name.isPresent()) model.addAttribute("username", name.get());

        return "welcome";
    }
}
