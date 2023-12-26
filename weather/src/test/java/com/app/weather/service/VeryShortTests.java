package com.app.weather.service;

import com.app.weather.domain.vo.VeryShortVO;
import com.app.weather.service.veryShort.VeryShortService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class VeryShortTests {
    @Autowired
    private VeryShortService veryShortService;

    //  기상청 초단기 예보
    @Test
    public void veryShortServiceTest() {
        String baseDate = "20231215";   //날짜 입력
        String baseTime = "0800";       //시간 입력
        int nx = 58;                     //x좌표
        int ny = 127;                    //y좌표

        System.out.println(veryShortService.veryShortService(baseDate, baseTime, nx, ny).toString());
    }

}
