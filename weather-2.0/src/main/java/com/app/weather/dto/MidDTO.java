package com.app.weather.dto;

import com.app.weather.entity.MidEntity;
import com.app.weather.entity.MidItemEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MidDTO {
    private String stnId;
    private String tmFc;
    private String resultCode;
    private String resultMsg;
    private String dataType;
    private List<MidItemDTO> items;
    private int pageNo;
    private int numOfRows;
    private int totalCount;

    private static MidDTO convertToMidDTO(MidEntity midEntity){
        MidDTO midDTO = new MidDTO();

        midDTO.setStnId(midEntity.getMidPk().getStnId());
        midDTO.setTmFc(midEntity.getMidPk().getTmFc());
        midDTO.setResultCode(midEntity.getHeader().getResultCode());
        midDTO.setResultMsg(midEntity.getHeader().getResultMsg());
        midDTO.setDataType(midEntity.getMidBody().getDataType());
        midDTO.setPageNo(midEntity.getMidBody().getPageNo());
        midDTO.setNumOfRows(midEntity.getMidBody().getNumOfRows());
        midDTO.setTotalCount(midEntity.getMidBody().getTotalCount());

        List<MidItemEntity> midItems = midEntity.getMidBody().getItems();
        List<MidItemDTO> midItemDTOs = new ArrayList<>();

        for (MidItemEntity item : midItems) {
            MidItemDTO midItemDTO = new MidItemDTO();
            midItemDTO.setWfSv(item.getWfSv());
            midItemDTOs.add(midItemDTO);
        }
        midDTO.setItems(midItemDTOs);

        return midDTO;
    }
}
