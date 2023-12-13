package com.example.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.admin.entity.SampleEntity;
import com.example.admin.repository.SampleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {
  private final SampleRepository sampleRepository;

  public String sampleConstString() {
    return "im sample";
  }

  public List<SampleEntity> getAllSampleEntity() {
    List<SampleEntity> allSampleEntity = this.sampleRepository.findAll();
    return allSampleEntity;
  }
}
