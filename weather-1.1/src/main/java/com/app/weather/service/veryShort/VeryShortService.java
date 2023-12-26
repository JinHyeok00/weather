package com.app.weather.service.veryShort;

import com.app.weather.domain.vo.VeryShortVO;

import java.util.Optional;

public interface VeryShortService {
    //  기상청 초단기 예보
    public Optional<VeryShortVO> veryShoutService(String baseDate, String baseTime, int nx, int ny);
}
