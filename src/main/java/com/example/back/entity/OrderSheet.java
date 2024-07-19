package com.example.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="order_sheet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderSheet {

    @Id
    private Integer orderSheetNo;
    private Integer orderSheetMemberNo;
    private Integer orderSheetClientNo;
    private String orderSheetDay;
    private Integer orderSheetStatus;
    private String orderSheetOutDay;

}
