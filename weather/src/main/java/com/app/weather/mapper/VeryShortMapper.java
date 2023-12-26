package com.app.weather.mapper;

import com.app.weather.domain.vo.VeryShortVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface VeryShortMapper {
    // C
    public void insert(VeryShortVO veryShortVO);

    // R
    public Optional<VeryShortVO> select(String baseDate, String baseTime, int nx, int ny);
}
