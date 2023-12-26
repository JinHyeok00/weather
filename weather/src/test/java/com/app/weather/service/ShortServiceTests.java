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

    //  기상청 단기 예보
    @Test
    public void shortServiceTest() {
        String baseDate = "20231215";   //날짜 입력
        String baseTime = "0800";       //시간 입력
        int nx = 58;                     //x좌표
        int ny = 127;                    //y좌표

        System.out.println(shortService.shortService(baseDate, baseTime, nx, ny).toString());
    }
}
