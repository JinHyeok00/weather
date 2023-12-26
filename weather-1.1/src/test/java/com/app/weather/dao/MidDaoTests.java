package com.app.weather.dao;

import com.app.weather.domain.vo.MidVO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MidDaoTests {
    @Autowired
    private MidDao midDao;

    //  추가
    @Test
    public void saveTest(){
        MidVO midVO = new MidVO();
        JSONObject jsonObject = new JSONObject();

        midVO.setStnId("2");
        midVO.setTmFc("2");
        midVO.setResponse(jsonObject.toString());

        midDao.save(midVO);
    }

    // 조회
    @Test
    public void findTest(){
        String stnId = "2";
        String tmFc = "2";

        if(midDao.find(stnId, tmFc).isPresent()){
            System.out.println(midDao.find(stnId,tmFc).get().toString());
        }
    }
}
