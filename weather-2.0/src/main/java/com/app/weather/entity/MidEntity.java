package com.app.weather.entity;

import com.app.weather.dto.MidDTO;
import com.app.weather.dto.MidItem;
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
@Table(name = "tbl_mid")
public class MidEntity{
    @EmbeddedId
    private MidPk midPk;            //key값

    @Column
    private int pageNo;

    @Column
    private String dataType;

    @Column
    private int totalCount;

    @Column
    private int numOfRows;

    @Column
    private String resultCode;

    @Column
    private String resultMsg;

    @OneToMany(mappedBy = "midEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MidItemEntity> midItemEntities = new ArrayList<>();


    public static MidEntity convertToEntity(MidDTO midDTO) {
        MidEntity midEntity = MidEntity.builder()
                .midPk(new MidPk(midDTO.getStnId(), midDTO.getTmFc()))
                .pageNo(midDTO.getBody().getPageNo())
                .dataType(midDTO.getBody().getDataType())
                .totalCount(midDTO.getBody().getTotalCount())
                .numOfRows(midDTO.getBody().getNumOfRows())
                .resultCode(midDTO.getHeader().getResultCode())
                .resultMsg(midDTO.getHeader().getResultMsg())
                .midItemEntities(new ArrayList<>())
                .build();

        List<MidItem> midItems = midDTO.getBody().getItems().getItem();
        for (MidItem midItem : midItems) {
            midEntity.getMidItemEntities().add(MidItemEntity.convertToEntity(midItem, midEntity));
        }

        return midEntity;
    }
}
