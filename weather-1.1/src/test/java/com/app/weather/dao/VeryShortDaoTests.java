package com.app.weather.dao;

import com.app.weather.domain.vo.ShortVO;
import com.app.weather.domain.vo.VeryShortVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VeryShortDaoTests {
    @Autowired
    private VeryShortDao veryShortDao;

    //  추가
    @Test
    public void saveTest(){
        VeryShortVO veryShortVO = new VeryShortVO();
        JSONObject jsonObject = new JSONObject();
        veryShortVO.setNx(2);
        veryShortVO.setNy(2);
        veryShortVO.setBaseDate("2");
        veryShortVO.setBaseTime("2");
        veryShortVO.setResponse(jsonObject.toString());
        veryShortDao.save(veryShortVO);
    }

    // 조회
    @Test
    public void findTest(){
        String baseDate = "1";
        String baseTime = "1";
        int nx = 1;
        int ny = 1;
        if(veryShortDao.find(baseDate, baseTime, nx, ny).isPresent()){
            System.out.println(veryShortDao.find(baseDate, baseTime, nx, ny ).toString());
        }
    }
}
