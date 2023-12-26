package com.app.weather.mapper;

import com.app.weather.domain.vo.ShortVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class ShortMapperTests {

    @Autowired
    private ShortMapper shortMapper;

    // C
    @Test
    public void insertTest() {
        ShortVO shortVO = new ShortVO();
        shortVO.setBaseDate("20231215");
        shortVO.setBaseTime("0800");
        shortVO.setNx(55);
        shortVO.setNy(127);
        shortMapper.insert(shortVO);
    }

    // R
    @Test
    public void selectTest() {
        String baseDate = "20231215";
        String baseTime = "0800";
        int nx = 55;
        int ny = 127;
        System.out.println(shortMapper.select(baseDate, baseTime, nx, ny).isPresent());
    }
}
