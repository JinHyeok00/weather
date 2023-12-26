package com.app.weather.service.mid;

import com.app.weather.dao.MidDao;
import com.app.weather.domain.vo.MidVO;
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
public class MidServiceImpl implements MidService {
    private final MidDao midDao;

    // 기상청 중기 예보
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<MidVO> midService(String stnId, String tmFc) {
        //  요청한값 DB 조회
        final Optional<MidVO> foundMid = midDao.find(stnId, tmFc);
        //  만약 DB에 값이 없다면 기상청 api를 통해 데이터를 받아온다
        if (!foundMid.isPresent()) {
            String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

            URI uri = URI.create("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst" +
                    "?serviceKey=" + key +
                    "&pageNo=1" +
                    "&numOfRows=10" +
                    "&dataType=JSON" +
                    "&stnId=" + stnId +
                    "&tmFc=" + tmFc);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-type", "application/json")
                    .build();
            try {
                HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
                // 응답 값 저장
                JSONObject response = new JSONObject(httpResponse.body()).getJSONObject("response");
                // 에러 코드 저장
                String resultCode = response.getJSONObject("header").getString("resultCode");

                //  응답값이 적절하다면 DB에 저장하고 값을 반환 한다
                if(resultCode.equals("00")){
                    MidVO midVO = new MidVO();
                    midVO.setStnId(stnId);
                    midVO.setTmFc(tmFc);
                    midVO.setResponse(response.toString());
                    //  DB에 저장
                    midDao.save(midVO);
                    // 저장된 값 찾아서 반환
                    return midDao.find(stnId, tmFc);
                }
            }catch (Exception e){ }
        }
        // 저장된 값 찾아서 반환
        return foundMid;
    }
}
