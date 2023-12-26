package com.app.weather.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MidVO {
    //    결과를 도출할때 필요한 값 (지점번호, 발표시각)
    private String stnId;           // 지점번호 (지역번호 같은 느낌)
    private String tmFc;            // 발표시각
    private String resultCode;      // 결과코드 (00이여야지 프로그램 잘 돌아간거)
    private String resultMsg;       // 결과메세지 (NORMAL_SERVICE이면 잘돌아간거)
    private int numOfRows;          // 한 페이지 결과 수 (10)
    private int pageNo;             // 페이지 번호 (1)
    private int totalCount;         // 전체 결과 수
    private String dataType;        // 데이터 타입 (JSON)
    private String wfSv;            // 기상 전망
}


