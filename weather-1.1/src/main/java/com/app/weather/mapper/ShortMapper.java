package com.app.weather.mapper;

import com.app.weather.domain.vo.ShortVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ShortMapper {
    //  C
    public void insert(ShortVO shortVO);

    //  R
    public Optional<ShortVO> select(String baseDate, String baseTime, int nx, int ny);
}
