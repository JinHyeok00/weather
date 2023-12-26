package com.app.weather.dto;

import com.app.weather.entity.MidEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MidDTO {
    private String stnId;       // 지점번호
    private String tmFc;        // 발표시각
    private String response;    // 응답값

    public static MidDTO toMidDTO(MidEntity midEntity) {
        MidDTO midDTO = new MidDTO();
        midDTO.setStnId(midEntity.getMidPk().getStnId());
        midDTO.setTmFc(midEntity.getMidPk().getTmFc());
        midDTO.setResponse(midEntity.getResponse());
        return midDTO;
    }
}
