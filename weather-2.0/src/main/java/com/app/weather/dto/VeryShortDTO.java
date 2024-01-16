package com.app.weather.dto;

import com.app.weather.entity.ShortEntity;
import com.app.weather.entity.VeryShortEntity;
import lombok.*;

import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeryShortDTO {
    private String baseDate;    // 발표일자
    private String baseTime;    // 발표시각
    private int nx;             // 예보지점 x좌표
    private int ny;             // 예보지점 y좌표
    private Header header;
    private ShortBody body;

    public static VeryShortDTO convertToDTO(VeryShortEntity veryShortEntity) {
        return VeryShortDTO.builder()
                .baseDate(veryShortEntity.getShortPk().getBaseDate())
                .baseTime(veryShortEntity.getShortPk().getBaseTime())
                .header(Header.builder()
                        .resultCode(veryShortEntity.getResultCode())
                        .resultMsg(veryShortEntity.getResultMsg()).build())
                .body(ShortBody.builder()
                        .dataType(veryShortEntity.getDataType())
                        .numOfRows(veryShortEntity.getNumOfRows())
                        .pageNo(veryShortEntity.getPageNo())
                        .totalCount(veryShortEntity.getTotalCount())
                        .items(ShortItems.builder()
                                .item(veryShortEntity.getVeryShortItemEntities().stream()
                                        .map(VeryShortItemEntity -> ShortItem.builder()
                                                .baseDate(VeryShortItemEntity.getVeryShortEntity().getShortPk().getBaseDate())
                                                .baseTime(VeryShortItemEntity.getVeryShortEntity().getShortPk().getBaseTime())
                                                .nx(VeryShortItemEntity.getVeryShortEntity().getShortPk().getNx())
                                                .ny(VeryShortItemEntity.getVeryShortEntity().getShortPk().getNx())
                                                .category(VeryShortItemEntity.getCategory())
                                                .fcstDate(VeryShortItemEntity.getFcstDate())
                                                .fcstTime(VeryShortItemEntity.getFcstTime())
                                                .fcstValue(VeryShortItemEntity.getFcstValue())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .build())
                .build();
    }
}
