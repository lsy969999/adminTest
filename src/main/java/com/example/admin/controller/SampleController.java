package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
  @GetMapping
  public String hi(Model model){ 
    model.addAttribute("test", "test");
    model.addAttribute("name", "Lsy");
    return "pages/test";
  }
}
