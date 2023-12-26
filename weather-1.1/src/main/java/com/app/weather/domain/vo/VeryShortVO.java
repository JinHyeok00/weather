package com.app.weather.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class VeryShortVO {
    private String baseDate;        // 발표일자
    private String baseTime;        // 발표시각
    private int nx;                 // 예보지점 X좌표
    private int ny;                 // 예보지점 Y좌표
    private String response;        // 응답값
}
