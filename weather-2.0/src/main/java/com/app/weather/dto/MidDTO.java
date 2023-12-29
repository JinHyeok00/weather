package com.app.weather.dto;

import com.app.weather.entity.MidEntity;
import lombok.*;

import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class MidDTO {
    private String stnId;
    private String tmFc;
    private Header header;
    private Body body;

    public static MidDTO convertToMidDTO(MidEntity midEntity){
        return MidDTO.builder()
                .stnId(midEntity.getMidPk().getStnId())
                .tmFc(midEntity.getMidPk().getTmFc())
                .header(Header.builder()
                        .resultCode(midEntity.getHeader().getResultCode())
                        .resultMsg(midEntity.getHeader().getResultMsg())
                        .build())
                .body(Body.builder()
                        .pageNo(midEntity.getMidBody().getPageNo())
                        .dataType(midEntity.getMidBody().getDataType())
                        .totalCount(midEntity.getMidBody().getTotalCount())
                        .items(midEntity.getMidBody().getItems().stream()
                                .map(itemEntity -> Item.builder().wfSv(itemEntity.getWfSv()).build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }
}
