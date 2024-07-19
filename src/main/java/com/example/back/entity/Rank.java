package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="rank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rank {

    @Id
    private Integer rankNo;
    private String rankCode;
    private String rankName;
    
}
