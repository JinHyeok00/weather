package com.app.weather.dao;


import com.app.weather.domain.vo.MidVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MidDaoTests {
    @Autowired
    private MidDao midDao;

    // 추가
    @Test
    public void saveTest() {
        MidVO midVO = new MidVO();
        midVO.setStnId("182");
        midVO.setTmFc("20231203");
        midDao.save(midVO);
    }

    // 조회
    @Test
    public void findTest() {
        String stnId = "1";
        String tmFc = "1";
        System.out.println(midDao.find(stnId, tmFc).isPresent());
    }

}
