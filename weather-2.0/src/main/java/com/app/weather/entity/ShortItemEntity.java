package com.app.weather.entity;

import com.app.weather.dto.ShortItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_shortItem")
public class ShortItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;            //자료구분문자

    @Column
    private String fcstDate;            //예보일자

    @Column
    private String fcstTime;            //예보시각

    @Column
    private String fcstValue;           //예보 값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "baseDate", referencedColumnName = "baseDate"),
            @JoinColumn(name = "baseTime", referencedColumnName = "baseTime"),
            @JoinColumn(name = "nx", referencedColumnName = "nx"),
            @JoinColumn(name = "ny", referencedColumnName = "ny")
    })
    private ShortEntity shortEntity;

    public static ShortItemEntity convertToEntity(ShortItem shortItem, ShortEntity shortEntity) {
        ShortItemEntity shortItemEntity = ShortItemEntity.builder()
                .category(shortItem.getCategory())
                .fcstDate(shortItem.getFcstDate())
                .fcstTime(shortItem.getFcstTime())
                .fcstValue(shortItem.getFcstValue())
                .shortEntity(shortEntity)
                .build();

        return shortItemEntity;
    }
}
