package com.app.weather.dao;

import com.app.weather.domain.vo.VeryShortVO;
import com.app.weather.mapper.VeryShortMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VeryShortDao {
    private final VeryShortMapper veryShortMapper;

    // 추가
    public void save(VeryShortVO veryShortVO) {
        veryShortMapper.insert(veryShortVO);
    }

    // 조회
    public Optional<VeryShortVO> find(String baseDate, String baseTime, int nx, int ny) {
        return veryShortMapper.select(baseDate, baseTime, nx, ny);
    }
}
