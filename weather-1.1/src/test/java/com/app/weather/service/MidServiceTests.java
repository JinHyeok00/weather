package com.app.weather.service;

import com.app.weather.service.mid.MidService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MidServiceTests {
    @Autowired
    private MidService midService;

    // 기상청 중기 예보
    @Test
    public void midServiceTest() {
        String stnId = "109";
        String tmFc = "202312160600";
        if(midService.midService(stnId, tmFc).isPresent()){
            System.out.println(midService.midService(stnId, tmFc).get().toString());
        }
    }
}
