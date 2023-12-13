package com.example.admin.samplemvc.repository.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.samplemvc.entity.SampleEntity;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long>, SampleRepositoryCustom{
  
}
