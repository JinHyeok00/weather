package com.app.weather.mapper;

import com.app.weather.domain.vo.VeryShortVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class VersyShortMapperTests {
    @Autowired
    private VeryShortMapper veryShortMapper;

    // C
    @Test
    public void insertTest() {
        VeryShortVO veryShortVO = new VeryShortVO();
        veryShortVO.setBaseDate("20231215");
        veryShortVO.setBaseTime("0800");
        veryShortVO.setNx(55);
        veryShortVO.setNy(128);
        veryShortMapper.insert(veryShortVO);
    }

    // R
    @Test
    public void selectTest() {
        String baseDate = "20231215";
        String baseTime = "0800";
        int nx = 55;
        int ny = 128;
        System.out.println(veryShortMapper.select(baseDate, baseTime, nx, ny).isPresent());
    }
}
