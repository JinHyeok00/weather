package com.app.weather.service.shorts;

import com.app.weather.domain.vo.ShortVO;

import java.util.Optional;

public interface ShortService {
    //  기상청 단기 예보
    public Optional<ShortVO> shoutService(String baseDate, String baseTime, int nx, int ny);
}
