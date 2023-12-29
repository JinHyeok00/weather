package com.app.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MidBody {
    private static final long serialVersionUID = 1L;

    private String dataType;

    @Builder.Default
    @OneToMany(mappedBy = "midEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MidItemEntity> items = new ArrayList<>();

    private int pageNo;
    private int numOfRows;
    private int totalCount;

    @Builder(toBuilder = true)
    public MidBody(String dataType, int pageNo, int numOfRows, int totalCount) {
        this.dataType = dataType;
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;
        this.totalCount = totalCount;
    }
}
