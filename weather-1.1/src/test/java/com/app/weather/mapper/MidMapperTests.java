package com.app.weather.mapper;

import com.app.weather.domain.vo.MidVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MidMapperTests {
    @Autowired
    private MidMapper midMapper;

    // C
    @Test
    public void insertTest(){
        MidVO midVO = new MidVO();
        JSONObject jsonObject = new JSONObject();
        midVO.setStnId("1");
        midVO.setTmFc("1");
        midVO.setResponse(jsonObject.toString());
        midMapper.insert(midVO);
    }

    // R
    @Test
    public void selectTest(){
        String stnId = "1";
        String tmFc = "1";
        if(midMapper.select(stnId,tmFc).isPresent()){
            System.out.println(midMapper.select(stnId, tmFc).get().toString());
        }
    }
}
