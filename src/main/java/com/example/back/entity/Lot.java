package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="lot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Lot {

    @Id
    private Integer lotNo;
    private String lotCode;
    private Integer lotItemNo;

}
