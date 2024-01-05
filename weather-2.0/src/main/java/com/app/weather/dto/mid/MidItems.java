package com.app.weather.dto.mid;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidItems {
    private List<MidItem> item;
}