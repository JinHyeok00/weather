package com.app.weather.Service;

import com.app.weather.dto.ShortItem;
import com.app.weather.dto.VeryShortDTO;
import com.app.weather.entity.*;
import com.app.weather.repository.VeryShortItemRepository;
import com.app.weather.repository.VeryShortRepository;
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
public class VeryShortService {
    private final VeryShortRepository veryShortRepository;
    private final VeryShortItemRepository veryShortItemRepository;

    //조회
    public VeryShortDTO findById(String baseDate, String baseTime, int nx, int ny){
        ShortPk shortPk = new ShortPk(baseDate, baseTime, nx, ny);
        Optional<VeryShortEntity> optionalVeryShortEntity = veryShortRepository.findById(shortPk);
        if(optionalVeryShortEntity.isPresent()){
            // 조회 값이 있으면
            VeryShortEntity veryshortEntity = optionalVeryShortEntity.get();
            VeryShortDTO veryShortDTO = VeryShortDTO.convertToDTO(veryshortEntity);
            return veryShortDTO;
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
            VeryShortDTO veryShortDTO = objectMapper.readValue(response, new TypeReference<VeryShortDTO>() {});
            veryShortDTO.setBaseDate(baseDate);
            veryShortDTO.setBaseTime(baseTime);
            veryShortDTO.setNx(nx);
            veryShortDTO.setNy(ny);
            VeryShortEntity veryShortEntity = VeryShortEntity.convertToEntity(veryShortDTO);
            veryShortRepository.save(veryShortEntity);
            List<ShortItem> shortItems = veryShortDTO.getBody().getItems().getItem();
            for(ShortItem shortItem : shortItems){
                veryShortItemRepository.save(VeryShortItemEntity.convertToEntity(shortItem, veryShortEntity));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
