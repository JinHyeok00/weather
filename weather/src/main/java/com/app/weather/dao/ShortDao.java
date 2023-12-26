package com.app.weather.dao;

import com.app.weather.domain.vo.ShortVO;
import com.app.weather.mapper.ShortMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ShortDao {
    private final ShortMapper shortMapper;

    // 추가
    public void save(ShortVO shortVO) {
        shortMapper.insert(shortVO);
    }

    // 조회
    public Optional<ShortVO> find(String baseDate, String baseTime, int nx, int ny) {
        return shortMapper.select(baseDate, baseTime, nx, ny);
    }
}
