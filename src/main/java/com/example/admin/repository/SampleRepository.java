package com.example.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.SampleEntity;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long>, SampleRepositoryCustom{
  
}
