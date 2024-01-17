package com.app.weather;

import com.app.weather.Service.VeryShortService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VeryShortServiceTest {
    @Autowired
    private VeryShortService veryShortService;

    @Test
    public void saveTest(){
        String baseDate = "20240117";
        String baseTime = "0900";
        int nx = 55;        int ny = 127;
        veryShortService.save(baseDate, baseTime, nx, ny);
    }
}
