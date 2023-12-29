package com.app.weather.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Header {
    private String resultCode;
    private String resultMsg;
}
