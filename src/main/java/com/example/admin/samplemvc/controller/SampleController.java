package com.example.admin.samplemvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.admin.samplemvc.entity.SampleEntity;
import com.example.admin.samplemvc.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {
  private final SampleService sampleService;

  @GetMapping
  public String hi(Model model){
    log.debug("SampleController / hi");
    String sampleCon = this.sampleService.sampleConstString();
    List<SampleEntity> allSampleEntity = this.sampleService.getAllSampleEntity();
    List<SampleEntity> allSampleEntityDsl = this.sampleService.getAllSampleEntityDsl();
    model.addAttribute("sampleCon", sampleCon);
    model.addAttribute("sample", allSampleEntity);
    model.addAttribute("sampleDsl", allSampleEntityDsl);
    model.addAttribute("test", "test");
    model.addAttribute("name", "Lsy");
    return "pages/sample";
  }
}
