package com.app.weather.entity.mid;

import com.app.weather.dto.mid.MidItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_midItem")
public class MidItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String wfSv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "stnId", referencedColumnName = "stnId"),
            @JoinColumn(name = "tmFc", referencedColumnName = "tmFc")
    })
    private MidEntity midEntity;

    public static MidItemEntity convertToEntity(MidItem midItem, MidEntity midEntity) {
        MidItemEntity midItemEntity = MidItemEntity.builder()
                .wfSv(midItem.getWfSv())
                .midEntity(midEntity)
                .build();
        return midItemEntity;
    }
}
