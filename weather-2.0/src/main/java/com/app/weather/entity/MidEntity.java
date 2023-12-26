package com.app.weather.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "tbl_mid")
public class MidEntity{
    @EmbeddedId
    private MidPk midPk;            //key값

    @Column
    private String response;        // 응답값
}
