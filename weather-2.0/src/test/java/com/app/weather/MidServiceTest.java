package com.app.weather;

import com.app.weather.Service.MidService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class MidServiceTest {
    @Autowired
    private MidService midService;

    @Test
    public void saveTest(){
        String stnId = "109";
        String tmFc = "202312290600";
        midService.save(stnId, tmFc);
    }
}
