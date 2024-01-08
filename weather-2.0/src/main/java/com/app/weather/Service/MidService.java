package com.app.weather.Service;

import com.app.weather.dto.MidDTO;
import com.app.weather.dto.MidItem;
import com.app.weather.entity.MidEntity;
import com.app.weather.entity.MidItemEntity;
import com.app.weather.entity.MidPk;
import com.app.weather.repository.MidItemRepository;
import com.app.weather.repository.MidRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MidService {
    private final MidRepository midRepository;
    private final MidItemRepository midItemRepository;

    //조회
    public MidDTO findById(String stnId, String tmFc){
        MidPk midPk = new MidPk(stnId, tmFc);
        Optional<MidEntity> optionalMidEntity = midRepository.findById(midPk);
        if(optionalMidEntity.isPresent()){
            // 조회 값이 있으면
            MidEntity midEntity = optionalMidEntity.get();
            MidDTO midDTO = MidDTO.convertToDTO(midEntity);
            return midDTO;
        }
        //없으면
        return null;
    }

    //추가
    @Transactional
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
            ObjectMapper objectMapper = new ObjectMapper();
            MidDTO midDTO = objectMapper.readValue(response, new TypeReference<MidDTO>() {});
            midDTO.setStnId(stnId);
            midDTO.setTmFc(tmFc);
            MidEntity midEntity = MidEntity.convertToEntity(midDTO);
            midRepository.save(midEntity);
            List<MidItem> midItems = midDTO.getBody().getItems().getItem();
            for(MidItem midItem : midItems){
                midItemRepository.save(MidItemEntity.convertToEntity(midItem, midEntity));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
