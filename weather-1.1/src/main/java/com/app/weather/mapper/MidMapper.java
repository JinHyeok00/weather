package com.app.weather.mapper;

import com.app.weather.domain.vo.MidVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MidMapper {
    // C
    public void insert(MidVO midVO);

    // R
    public Optional<MidVO> select(String stnId, String tmFc);
}
