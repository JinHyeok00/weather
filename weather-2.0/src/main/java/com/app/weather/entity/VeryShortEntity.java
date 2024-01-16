package com.app.weather.entity;

import com.app.weather.dto.ShortDTO;
import com.app.weather.dto.VeryShortDTO;
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
@Table(name = "tbl_veryShort")
public class VeryShortEntity {
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

    @OneToMany(mappedBy = "veryShortEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<VeryShortItemEntity> veryShortItemEntities = new ArrayList<>();

    public static VeryShortEntity convertToEntity(VeryShortDTO veryShortDTO) {
        VeryShortEntity veryShortEntity = VeryShortEntity.builder()
                .shortPk(new ShortPk(veryShortDTO.getBaseDate(), veryShortDTO.getBaseTime(), veryShortDTO.getNx(), veryShortDTO.getNy()))
                .pageNo(veryShortDTO.getBody().getPageNo())
                .dataType(veryShortDTO.getBody().getDataType())
                .totalCount(veryShortDTO.getBody().getTotalCount())
                .numOfRows(veryShortDTO.getBody().getNumOfRows())
                .resultCode(veryShortDTO.getHeader().getResultCode())
                .resultMsg(veryShortDTO.getHeader().getResultMsg())
                .veryShortItemEntities(new ArrayList<>())
                .build();

        return veryShortEntity;
    }
}
