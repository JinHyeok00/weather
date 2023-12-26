package com.app.weather.service.mid;

import com.app.weather.dao.MidDao;
import com.app.weather.domain.vo.MidVO;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
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

    //기상청 중기 예보
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<MidVO> midService(String stnId, String tmFc) {
        Optional<MidVO> foundMid = midDao.find(stnId, tmFc);
//        만약 foundMid가 비어있다면
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
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String s = response.body();
                JSONObject jsonObject = new JSONObject(s);
                JSONObject response1 = jsonObject.getJSONObject("response");
                JSONObject header = response1.getJSONObject("header");
                JSONObject body = response1.getJSONObject("body");
                JSONObject items = body.getJSONObject("items");
                JSONArray item = items.getJSONArray("item");
                MidVO midVO = new MidVO();
//                가져온 정보를 midVO에담기
                midVO.setStnId(stnId);
                midVO.setTmFc(tmFc);
                midVO.setResultCode(header.getString("resultCode"));
                midVO.setResultMsg(header.getString("resultMsg"));
                midVO.setNumOfRows(10);
                midVO.setPageNo(1);
                midVO.setTotalCount(body.getInt("totalCount"));
                midVO.setDataType("JSON");
                midVO.setWfSv(item.getJSONObject(0).getString("wfSv"));
//                DB에 저장해주기
                midDao.save(midVO);
//                가져온 정보 리턴하기 (한번에 못찾았을때)
                return midDao.find(stnId, tmFc);
            } catch (Exception e) {
            }
        }
//        가져온 정보 리턴하기 (한번에 찾았을때)
        return foundMid;
    }
}
