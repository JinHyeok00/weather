package com.app.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ShortPk implements Serializable {
    private static final long serialVersionUID = 1L;

    private String baseDate;    //발표일자
    private String baseTime;    //발표시각
    private int nx;             //예보지점 x좌표
    private int ny;             //예보지점 y좌표
}
