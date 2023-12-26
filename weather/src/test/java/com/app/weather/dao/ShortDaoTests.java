package com.app.weather.dao;

import com.app.weather.domain.vo.ShortVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class ShortDaoTests {
    @Autowired
    private ShortDao shortDao;

    // 추가
    @Test
    public void saveTest() {
        ShortVO shortVO = new ShortVO();
        shortVO.setBaseDate("20231215");
        shortVO.setBaseTime("0800");
        shortVO.setNx(55);
        shortVO.setNy(128);
        shortDao.save(shortVO);
    }

    // 조회
    @Test
    public void findTest() {
        String baseDate = "20231215";
        String baseTime = "0800";
        int nx = 55;
        int ny = 128;
        System.out.println(shortDao.find(baseDate, baseTime, nx, ny).isPresent());
    }


}
