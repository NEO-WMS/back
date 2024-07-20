package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="rack")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rackNo;
    private Integer rackAreaNo;
    private String rackCode;
    private String rackName;

}
