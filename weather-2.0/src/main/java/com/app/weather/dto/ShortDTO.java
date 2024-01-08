package com.app.weather.dto;

import com.app.weather.entity.ShortEntity;
import lombok.*;

import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortDTO {
    private String baseDate;    // 발표일자
    private String baseTime;    // 발표시각
    private int nx;             // 예보지점 x좌표
    private int ny;             // 예보지점 y좌표
    private Header header;
    private ShortBody body;

    public static ShortDTO convertToDTO(ShortEntity shortEntity) {
        return ShortDTO.builder()
                .baseDate(shortEntity.getShortPk().getBaseDate())
                .baseTime(shortEntity.getShortPk().getBaseTime())
                .header(Header.builder()
                        .resultCode(shortEntity.getResultCode())
                        .resultMsg(shortEntity.getResultMsg()).build())
                .body(ShortBody.builder()
                        .dataType(shortEntity.getDataType())
                        .numOfRows(shortEntity.getNumOfRows())
                        .pageNo(shortEntity.getPageNo())
                        .totalCount(shortEntity.getTotalCount())
                        .items(ShortItems.builder()
                                .item(shortEntity.getShortItemEntities().stream()
                                        .map(shortItemEntity -> ShortItem.builder()
                                                .baseDate(shortItemEntity.getShortEntity().getShortPk().getBaseDate())
                                                .baseTime(shortItemEntity.getShortEntity().getShortPk().getBaseTime())
                                                .nx(shortItemEntity.getShortEntity().getShortPk().getNx())
                                                .ny(shortItemEntity.getShortEntity().getShortPk().getNx())
                                                .category(shortItemEntity.getCategory())
                                                .fcstDate(shortItemEntity.getFcstDate())
                                                .fcstTime(shortItemEntity.getFcstTime())
                                                .fcstValue(shortItemEntity.getFcstValue())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .build())
                .build();
    }
}
