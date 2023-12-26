package com.app.weather.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ShortVO {
    //    결과를 도출할때 필요한 값 (발표일자, 발표시각, 예보지점 x좌표, y좌표)
    private String resultCode;      // 결과코드 (00이여야지 프로그램 잘 돌아간거)
    private String resultMsg;       // 결과메세지 (NORMAL_SERVICE이면 잘돌아간거)
    private int numOfRows;          // 한 페이지 결과 수   (1000)
    private int pageNo;             // 페이지 번호   ()
    private int totalCount;         // 전체 결과 수
    private String dataType;        // 데이터 타입   (JSON)
    private String baseDate;        // 발표일자
    private String baseTime;        // 발표시각
    private int nx;                 // 예보지점 X좌표
    private int ny;                 // 예보지점 Y좌표
    private String items;           // 발표 내역
}
