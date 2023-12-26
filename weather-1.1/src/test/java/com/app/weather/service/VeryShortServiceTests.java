package com.app.weather.service;

import com.app.weather.service.veryShort.VeryShortService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VeryShortServiceTests {
    @Autowired
    private VeryShortService veryShortService;

    // 기상청 초단기 예보
    @Test
    public void veryShortServiceTest() {
        String baseDate = "20231216";
        String baseTime = "2330";
        int nx = 55;
        int ny = 127;
        if(veryShortService.veryShoutService(baseDate, baseTime, nx, ny).isPresent()){
            System.out.println(veryShortService.veryShoutService(baseDate, baseTime, nx, ny).get().toString());
        }
    }
}
