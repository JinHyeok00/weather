package com.app.weather.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Embeddable
public class MidBody {
    private String dataType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tbl_mid_midPK")
    private List<MidItemEntity> items;

    private int pageNo;
    private int numOfRows;
    private int totalCount;
}
