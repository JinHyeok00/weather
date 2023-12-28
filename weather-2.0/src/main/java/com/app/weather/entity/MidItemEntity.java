package com.app.weather.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="tbl_midItem")
public class MidItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String wfSv;
}
