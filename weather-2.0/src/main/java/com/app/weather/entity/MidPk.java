package com.app.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
//복합키 설정
@Embeddable
//DB영속성 때문에 Serializable 상속받기
@NoArgsConstructor
@AllArgsConstructor
public class MidPk implements Serializable{
    private static final long serialVersionUID = 1L;

    private String stnId;           // 지점번호
    private String tmFc;            // 발표시각
}
