package com.app.weather.service;

import com.app.weather.domain.vo.MidVO;
import com.app.weather.service.mid.MidService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MidServiceTests {
    @Autowired
    private MidService midService;

    //  기상청 중기 예보
    @Test
    public void midServiceTest() {
        String stnId = "109";               //지역입력
        String tmFc = "202312150600";       //발표시간 입력

        System.out.println(midService.midService(stnId, tmFc).toString());
    }
}
