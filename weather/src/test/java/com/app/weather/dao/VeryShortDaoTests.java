package com.app.weather.dao;

import com.app.weather.domain.vo.VeryShortVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class VeryShortDaoTests {
    @Autowired
    private VeryShortDao veryShortDao;

    // 추가
    @Test
    public void saveTest() {
        VeryShortVO veryShortVO = new VeryShortVO();
        veryShortVO.setBaseDate("20231215");
        veryShortVO.setBaseTime("0900");
        veryShortVO.setNx(55);
        veryShortVO.setNy(128);
        veryShortDao.save(veryShortVO);
    }

    // 조회
    @Test
    public void findTest() {
        String baseDate = "20231215";
        String baseTime = "0900";
        int nx = 55;
        int ny = 128;
        System.out.println(veryShortDao.find(baseDate, baseTime, nx, ny).isPresent());
    }
}
