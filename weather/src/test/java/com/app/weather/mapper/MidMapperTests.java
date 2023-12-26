package com.app.weather.mapper;

import com.app.weather.domain.vo.MidVO;
import lombok.extern.slf4j.Slf4j;
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
    public void insertTest() {
        MidVO midVO = new MidVO();
        midVO.setStnId("121");
        midVO.setTmFc("20231203");
        midMapper.insert(midVO);
    }

    // R
    @Test
    public void selectTest() {
        String stnId = "1";
        String tmFc = "1";
        System.out.println(midMapper.select(stnId, tmFc).isPresent());
    }

}
