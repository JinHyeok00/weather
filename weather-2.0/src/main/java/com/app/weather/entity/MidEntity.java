package com.app.weather.entity;

import com.app.weather.dto.MidDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@Getter
@Builder
@Table(name = "tbl_mid")
public class MidEntity{
    @EmbeddedId
    private MidPk midPk;            //key값

    @Embedded
    private Header header;          //

    @Embedded
    private MidBody midBody;

    public static MidEntity convertToMidEntity(MidDTO midDTO) {

        return MidEntity.builder()
                .midPk(new MidPk(midDTO.getStnId(), midDTO.getTmFc()))
                .header(Header.builder()
                        .resultCode(midDTO.getHeader().getResultCode())
                        .resultMsg(midDTO.getHeader().getResultMsg())
                        .build())
                .midBody(MidBody.builder()
                        .dataType(midDTO.getBody().getDataType())
                        .pageNo(midDTO.getBody().getPageNo())
                        .numOfRows(midDTO.getBody().getItems().size())
                        .totalCount(midDTO.getBody().getTotalCount())
                        .items(midDTO.getBody().getItems().stream()
                                .map(item -> MidItemEntity.builder().wfSv(item.getWfSv()).build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }
}
