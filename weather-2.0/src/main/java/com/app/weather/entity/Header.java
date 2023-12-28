package com.app.weather.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Header {
    private static final long serialVersionUID = 1L;

    private String resultCode;
    private String resultMsg;
}
