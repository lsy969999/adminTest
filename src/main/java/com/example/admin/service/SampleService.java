package com.example.admin.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.admin.entity.SampleEntity;
import com.example.admin.repository.SampleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleService {
  private final SampleRepository sampleRepository;

  public String sampleConstString() {
    return "im sample";
  }

  public List<SampleEntity> getAllSampleEntity() {
    log.debug("getAllSampleEntity");
    List<SampleEntity> allSampleEntity = this.sampleRepository.findAll();
    return allSampleEntity;
  }

  public List<SampleEntity> getAllSampleEntityDsl(){
    log.debug("getAllSampleEntityDsl");
    List<SampleEntity> allSampleEntity = this.sampleRepository.getAll();
    return  allSampleEntity;
  }
}
