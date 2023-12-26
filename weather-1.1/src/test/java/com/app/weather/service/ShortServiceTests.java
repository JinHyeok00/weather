package com.app.weather.service;

import com.app.weather.service.shorts.ShortService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShortServiceTests {
    @Autowired
    private ShortService shortService;

    // 기상청 단기 예보
    @Test
    public void shortServiceTest() {
        String baseDate = "20231216";
        String baseTime = "0800";
        int nx = 55;
        int ny = 127;
        if(shortService.shoutService(baseDate, baseTime, nx, ny).isPresent()){
            System.out.println(shortService.shoutService(baseDate, baseTime, nx, ny).get().toString());
        }
    }
}
