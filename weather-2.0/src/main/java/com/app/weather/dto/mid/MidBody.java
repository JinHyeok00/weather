package com.app.weather.dto.mid;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidBody {
    private int pageNo;
    private String dataType;
    private int totalCount;
    private int numOfRows;
    private MidItems items;
}
