package com.app.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MidPk implements Serializable {
    private static final long serialVersionUID = 1L;

    private String stnId;           // 지점번호
    private String tmFc;            // 발표시각
}
