package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {

    @Id
    private Integer orderDetailNo;
    private Integer orderDetailOrderNo;
    private Integer orderDetailItemNo;
    private Integer orderDetailAmount;
}
