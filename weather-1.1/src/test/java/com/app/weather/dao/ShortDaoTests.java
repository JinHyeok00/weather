package com.app.weather.dao;

import com.app.weather.domain.vo.ShortVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShortDaoTests {
    @Autowired
    private ShortDao shoutDao;

    //  추가
    @Test
    public void saveTest(){
        ShortVO shortVO = new ShortVO();
        JSONObject jsonObject = new JSONObject();
        shortVO.setNx(2);
        shortVO.setNy(2);
        shortVO.setBaseDate("2");
        shortVO.setBaseTime("2");
        shortVO.setResponse(jsonObject.toString());
        shoutDao.save(shortVO);
    }

    // 조회
    @Test
    public void findTest(){
        String baseDate = "1";
        String baseTime = "1";
        int nx = 1;
        int ny = 1;
        if(shoutDao.find(baseDate, baseTime, nx, ny).isPresent()){
            System.out.println(shoutDao.find(baseDate, baseTime, nx, ny ).toString());
        }
    }
}
