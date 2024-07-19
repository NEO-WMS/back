package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="sell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Sell {

    @Id
    private Integer sellNo;
    private Integer sellMemberNo;
    private Integer sellOrderNo;
    private String sellDay;

}
