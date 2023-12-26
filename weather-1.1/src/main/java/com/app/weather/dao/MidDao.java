package com.app.weather.dao;

import com.app.weather.domain.vo.MidVO;
import com.app.weather.mapper.MidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MidDao {
    private final MidMapper midMapper;

    //  추가
    public void save(MidVO midVO){
        midMapper.insert(midVO);
    }

    //  조회
    public Optional<MidVO> find(String stnId, String tmFc){
        return midMapper.select(stnId, tmFc);
    }
}
