package com.app.weather.mapper;

import com.app.weather.domain.vo.VeryShortVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VeryShortMapperTests {
    @Autowired
    private VeryShortMapper veryShortMapper;

    @Test
    public void insertTest(){
        VeryShortVO veryShortVO = new VeryShortVO();
        JSONObject jsonObject = new JSONObject();
        veryShortVO.setNx(1);
        veryShortVO.setNy(1);
        veryShortVO.setBaseDate("1");
        veryShortVO.setBaseTime("1");
        veryShortVO.setResponse(jsonObject.toString());
        veryShortMapper.insert(veryShortVO);
    }

    //  R
    @Test
    public void select(){
        String baseDate = "1";
        String baseTime = "1";
        int nx = 1;
        int ny = 1;
        if(veryShortMapper.select(baseDate,baseTime,nx,ny).isPresent()){
            System.out.println(veryShortMapper.select(baseDate,baseTime,nx,ny).get().toString());
        }
    }
}
