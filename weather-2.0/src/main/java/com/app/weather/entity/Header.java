package com.app.weather.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Header {
    private String resultCode;
    private String resultMsg;
}
