package com.app.weather.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Header {
    private static final long serialVersionUID = 1L;

    private String resultCode;
    private String resultMsg;

}
