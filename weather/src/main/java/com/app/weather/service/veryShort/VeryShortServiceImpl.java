package com.app.weather.service.veryShort;

import com.app.weather.dao.VeryShortDao;
import com.app.weather.domain.vo.VeryShortVO;
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
public class VeryShortServiceImpl implements VeryShortService {
    public final VeryShortDao veryShortDao;

    //  기상청 초단기 예보
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<VeryShortVO> veryShortService(String baseDate, String baseTime, int nx, int ny) {
        Optional<VeryShortVO> foundShort = veryShortDao.find(baseDate, baseTime, nx, ny);
//        만약 foundShort이 비어있다면
        if (!foundShort.isPresent()) {
            String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

            URI uri = URI.create("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst" +
                    "?serviceKey=" + key +
                    "&pageNo=1" +
                    "&numOfRows=1000" +
                    "&dataType=JSON" +
                    "&base_date=" + baseDate +
                    "&base_time=" + baseTime +
                    "&nx=" + nx +
                    "&ny=" + ny);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-type", "application/json")
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String s = response.body();
                JSONObject jsonObject = new JSONObject(s);
                JSONObject response1 = jsonObject.getJSONObject("response");
                JSONObject header = response1.getJSONObject("header");
                JSONObject body = response1.getJSONObject("body");
                JSONObject items = body.getJSONObject("items");
                VeryShortVO veryShortVO = new VeryShortVO();
//                가져온 정보를 ShortVO에담기
                veryShortVO.setBaseDate(baseDate);
                veryShortVO.setBaseTime(baseTime);
                veryShortVO.setResultCode(header.getString("resultCode"));
                veryShortVO.setResultMsg(header.getString("resultMsg"));
                veryShortVO.setNumOfRows(1000);
                veryShortVO.setPageNo(1);
                veryShortVO.setTotalCount(body.getInt("totalCount"));
                veryShortVO.setDataType("JSON");
                veryShortVO.setNx(nx);
                veryShortVO.setNy(ny);
//                JSON형태의 값을 toString으로 변환에서 저장
                veryShortVO.setItems(items.toString());
//                DB에 저장해주기
                veryShortDao.save(veryShortVO);
//                가져온 정보 리턴하기 (한번에 못찾았을때)
                return veryShortDao.find(baseDate, baseTime, nx, ny);
            } catch (Exception e) {
            }
        }
//        가져온 정보 리턴하기 (한번에 찾았을때)
        return foundShort;
    }
}
