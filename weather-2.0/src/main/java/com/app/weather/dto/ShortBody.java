package com.app.weather.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortBody {
    private int pageNo;             //페이지 번호
    private String dataType;        //데이터 타입
    private int totalCount;         //전체 결과 수
    private int numOfRows;          //한 페이지 결과 수
    private ShortItems items;
}
