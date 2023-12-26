package com.app.weather.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MidDTO {
    private String stnId;       // 지점번호
    private String tmFc;        // 발표시각
    private String response;    // 응답값
}
