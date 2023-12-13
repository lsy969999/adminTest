package com.example.admin.samplemvc.apicontroller;

import com.example.admin.samplemvc.entity.SampleEntity;
import com.example.admin.samplemvc.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/sample")
public class SampleRestController {
    private final SampleService sampleService;

    @GetMapping
    public ResponseEntity hi(Model model){
        log.debug("SampleRestController / hi");
        String sampleCon = this.sampleService.sampleConstString();
        List<SampleEntity> allSampleEntity = this.sampleService.getAllSampleEntity();
        List<SampleEntity> allSampleEntityDsl = this.sampleService.getAllSampleEntityDsl();
        model.addAttribute("sampleCon", sampleCon);
        model.addAttribute("sample", allSampleEntity);
        model.addAttribute("sampleDsl", allSampleEntityDsl);
        model.addAttribute("test", "test");
        model.addAttribute("name", "Lsy");
        return ResponseEntity.ok(allSampleEntityDsl);
    }
}
