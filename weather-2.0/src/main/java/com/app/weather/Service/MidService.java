package com.app.weather.Service;

import com.app.weather.dto.MidDTO;
import com.app.weather.entity.MidEntity;
import com.app.weather.entity.MidPk;
import com.app.weather.repository.MidRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MidService {
    private final MidRepository midRepository;

    //조회
    public MidDTO findById(String stnId, String tmFc){
        MidPk midPk = new MidPk(stnId, tmFc);
        Optional<MidEntity> optionalMidEntity = midRepository.findById(midPk);
        if(optionalMidEntity.isPresent()){
            // 조회 값이 있으면
            MidEntity midEntity = optionalMidEntity.get();
            MidDTO midDTO = MidDTO.convertToMidDTO(midEntity);
            return midDTO;
        }
        //없으면
        return null;
    }

    //추가
    public void save(String stnId, String tmFc){
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
            String response = new JSONObject(httpResponse.body()).getString("response");
            System.out.println("1");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("2");
            MidDTO midDTO = objectMapper.readValue(response, MidDTO.class);
            System.out.println("3");
            MidEntity midEntity = MidEntity.convertToMidEntity(midDTO);
            System.out.println("4");
            midRepository.save(midEntity);
            System.out.println("5");
        }catch (Exception e){
            System.out.println("잡았다");
        }
    }
}
