package com.app.weather.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MidVO {
    private String stnId;           // 지점번호
    private String tmFc;            // 발표시각
    private String response;        // 응답값
}
