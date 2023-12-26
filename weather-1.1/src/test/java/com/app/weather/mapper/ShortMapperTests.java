package com.app.weather.mapper;

import com.app.weather.domain.vo.ShortVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShortMapperTests {
    @Autowired
    private ShortMapper shoutMapper;

    //  C
    @Test
    public void insertTest(){
        ShortVO shortVO = new ShortVO();
        JSONObject jsonObject = new JSONObject();
        shortVO.setNx(1);
        shortVO.setNy(1);
        shortVO.setBaseDate("1");
        shortVO.setBaseTime("1");
        shortVO.setResponse(jsonObject.toString());
        shoutMapper.insert(shortVO);
    }

    //  R
    @Test
    public void select(){
        String baseDate = "1";
        String baseTime = "1";
        int nx = 1;
        int ny = 1;
        if(shoutMapper.select(baseDate,baseTime,nx,ny).isPresent()){
            System.out.println(shoutMapper.select(baseDate,baseTime,nx,ny).get().toString());
        }
    }
}
