package com.app.weather.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortItems {
    private List<ShortItem> item;
}
