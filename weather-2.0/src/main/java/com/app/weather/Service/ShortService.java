package com.app.weather.Service;

import com.app.weather.dto.MidItem;
import com.app.weather.dto.ShortDTO;
import com.app.weather.dto.ShortItem;
import com.app.weather.entity.MidItemEntity;
import com.app.weather.entity.ShortEntity;
import com.app.weather.entity.ShortItemEntity;
import com.app.weather.entity.ShortPk;
import com.app.weather.repository.ShortItemRepository;
import com.app.weather.repository.ShortRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortService {
    private final ShortRepository shortRepository;
    private final ShortItemRepository shortItemRepository;

    //조회
    public ShortDTO findById(String baseDate, String baseTime, int nx, int ny){
        ShortPk shortPk = new ShortPk(baseDate, baseTime, nx, ny);
        Optional<ShortEntity> optionalMidEntity = shortRepository.findById(shortPk);
        if(optionalMidEntity.isPresent()){
            // 조회 값이 있으면
            ShortEntity shortEntity = optionalMidEntity.get();
            ShortDTO shortDTO = ShortDTO.convertToDTO(shortEntity);
            return shortDTO;
        }
        //없으면
        return null;
    }

    //추가
    @Transactional
    public void save(String baseDate, String baseTime, int nx, int ny){
        String key = "Ro42m3hfgXWsb0ZtX%2FVATvRW%2F027tmCoXL2ODMTYHH9IehqBIU9%2BoPraT67HNlst7MsbISk0CxiLTyYjdB1IaA%3D%3D";

        URI uri = URI.create("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst" +
                "?serviceKey=" + key +
                "&pageNo=1" +
                "&numOfRows=100" +
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
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            String response = new JSONObject(httpResponse.body()).getString("response");
            ObjectMapper objectMapper = new ObjectMapper();
            ShortDTO shortDTO = objectMapper.readValue(response, new TypeReference<ShortDTO>() {});
            shortDTO.setBaseDate(baseDate);
            shortDTO.setBaseTime(baseTime);
            shortDTO.setNx(nx);
            shortDTO.setNy(ny);
            ShortEntity shortEntity = ShortEntity.convertToEntity(shortDTO);
            shortRepository.save(shortEntity);
            List<ShortItem> shortItems = shortDTO.getBody().getItems().getItem();
            for(ShortItem shortItem : shortItems){
                shortItemRepository.save(ShortItemEntity.convertToEntity(shortItem, shortEntity));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
