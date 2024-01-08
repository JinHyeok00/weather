package com.app.weather.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortItem {
    private String baseDate;            //발표일자
    private String baseTime;            //발표시각
    private int nx;                     //예보지점 x좌표
    private int ny;                     //예보지점 y좌표
    private String category;            //자료구분문자
    private String fcstDate;            //예보일자
    private String fcstTime;            //예보시각
    private String fcstValue;           //예보 값
}
