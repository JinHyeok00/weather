package com.app.weather.dto.mid;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidHeader {
    private String resultCode;
    private String resultMsg;
}
