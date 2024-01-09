package com.app.weather;

import com.app.weather.Service.ShortService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShortServiceTest {
    @Autowired
    private ShortService shortService;

    @Test
    public void saveTest(){
        String baseDate = "20240109";
        String baseTime = "0800";
        int nx = 55;
        int ny = 127;
        shortService.save(baseDate, baseTime, nx, ny);
    }
}
