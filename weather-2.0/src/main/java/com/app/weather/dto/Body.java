package com.app.weather.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Body {
    private int pageNo;
    private String dataType;
    private int totalCount;
    private List<Item> items;
}
