package com.example.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.admin.entity.SampleEntity;
import com.example.admin.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SampleController {
  private final SampleService sampleService;

  @GetMapping
  public String hi(Model model){
    log.debug("SampleController / hi");
    String sampleCon = this.sampleService.sampleConstString();
    List<SampleEntity> allSampleEntity = this.sampleService.getAllSampleEntity();
    model.addAttribute("sampleCon", sampleCon);
    model.addAttribute("sample", allSampleEntity);
    model.addAttribute("test", "test");
    model.addAttribute("name", "Lsy");
    return "pages/test";
  }
}
