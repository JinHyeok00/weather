package com.app.weather.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "tbl_mid")
public class MidEntity{
    @EmbeddedId
    private MidPk midPk;            //key값

    @Embedded
    private Header header;          //

    @Embedded
    private MidBody midBody;
}
