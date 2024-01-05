package com.app.weather.dto.mid;

import com.app.weather.entity.mid.MidEntity;
import com.app.weather.entity.mid.MidItemEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidDTO {
    private String stnId;
    private String tmFc;
    private MidHeader header;
    private MidBody body;

    public static MidDTO convertToDTO(MidEntity midEntity) {
        return MidDTO.builder()
                .stnId(midEntity.getMidPk().getStnId())
                .tmFc(midEntity.getMidPk().getTmFc())
                .header(MidHeader.builder()
                        .resultCode(midEntity.getResultCode())
                        .resultMsg(midEntity.getResultMsg())
                        .build())
                .body(MidBody.builder()
                        .pageNo(midEntity.getPageNo())
                        .dataType(midEntity.getDataType())
                        .totalCount(midEntity.getTotalCount())
                        .numOfRows(midEntity.getNumOfRows())
                        .items(MidItems.builder()
                                .item(midEntity.getMidItemEntities().stream()
                                        .map(midItemEntity -> MidItem.builder()
                                                .wfSv(midItemEntity.getWfSv())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .build())
                .build();
    }
}
