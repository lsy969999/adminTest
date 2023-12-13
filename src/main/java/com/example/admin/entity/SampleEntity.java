package com.example.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(
  name = "SAMPLE_SEQ_GENERATOR",
  sequenceName = "SAMPLE_SEQ",
  initialValue = 1,
  allocationSize = 1
)
public class SampleEntity {
  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "SAMPLE_SEQ_GENERATOR"
  )
  private Long id;

  @Column
  private String name;
}