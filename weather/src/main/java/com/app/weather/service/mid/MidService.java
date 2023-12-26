package com.app.weather.service.mid;

import com.app.weather.domain.vo.MidVO;

import java.io.IOException;
import java.util.Optional;

public interface MidService {
    //  기상청 중기 예보
    public Optional<MidVO> midService(String stnId, String tmFc);
}
