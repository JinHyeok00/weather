package com.app.weather.service.shorts;

import com.app.weather.dao.ShortDao;
import com.app.weather.domain.vo.ShortVO;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortServiceImpl implements ShortService {
    private final ShortDao shoutDao;

    //기상청 단기 예보
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<ShortVO> shoutService(String baseDate, String baseTime, int nx, int ny) {
        //  요청한값 DB 조회
        final Optional<ShortVO> foundShout = shoutDao.find(baseDate, baseTime, nx, ny);
        //  만약 DB에 값이 없다면 기상청 api를 통해 데이터를 받아온다
        if (!foundShout.isPresent()) {
            String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

            URI uri = URI.create("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" +
                    "?serviceKey=" + key +
                    "&pageNo=1" +
                    "&numOfRows=1000" +
                    "&dataType=JSON" +
                    "&base_date=" + baseDate+
                    "&base_time=" + baseTime+
                    "&nx=" + nx +
                    "&ny=" + ny);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-type", "application/json")
                    .build();
            try{
                HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
                // 응답 값 저장
                JSONObject response = new JSONObject(httpResponse.body()).getJSONObject("response");
                // 에러 코드 저장
                String resultCode = response.getJSONObject("header").getString("resultCode");
                //  응답값이 적절하다면 DB에 저장하고 값을 반환 한다
                if(resultCode.equals("00")){
                    ShortVO shortVO = new ShortVO();
                    shortVO.setBaseTime(baseTime);
                    shortVO.setBaseDate(baseDate);
                    shortVO.setNx(nx);
                    shortVO.setNy(ny);
                    shortVO.setResponse(response.toString());
                    //  DB에 저장
                    shoutDao.save(shortVO);
                    //  저장된 값 찾아서 반환
                    return shoutDao.find(baseDate, baseTime, nx, ny);
                }
            }
            catch (Exception e){}
        }
        return foundShout;
    }
}
