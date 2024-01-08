package com.app.weather.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    private String resultCode;
    private String resultMsg;
}
