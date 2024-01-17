package com.app.weather.entity;

import com.app.weather.dto.ShortDTO;
import com.app.weather.dto.ShortItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_short")
public class ShortEntity {
    @EmbeddedId
    private ShortPk shortPk;            //key값

    @Column
    private String resultCode;      //결과코드

    @Column
    private String resultMsg;       //결과메세지

    @Column
    private int numOfRows;          //한 페이지 결과 수

    @Column
    private int pageNo;             //페이지 번호

    @Column
    private int totalCount;         //전체 결과 수

    @Column
    private String dataType;        //데이터 타입

    @OneToMany(mappedBy = "shortEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<ShortItemEntity> shortItemEntities = new ArrayList<>();

    public static ShortEntity convertToEntity(ShortDTO shortDTO) {
        ShortEntity shortEntity = ShortEntity.builder()
                .shortPk(new ShortPk(shortDTO.getBaseDate(), shortDTO.getBaseTime(), shortDTO.getNx(), shortDTO.getNy()))
                .resultCode(shortDTO.getHeader().getResultCode())
                .resultMsg(shortDTO.getHeader().getResultMsg())
                .pageNo(shortDTO.getBody().getPageNo())
                .dataType(shortDTO.getBody().getDataType())
                .totalCount(shortDTO.getBody().getTotalCount())
                .numOfRows(shortDTO.getBody().getNumOfRows())
                .shortItemEntities(new ArrayList<>())
                .build();

        return shortEntity;
    }
}
