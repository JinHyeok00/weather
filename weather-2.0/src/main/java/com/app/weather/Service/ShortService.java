package com.app.weather.Service;

import com.app.weather.dto.MidDTO;
import com.app.weather.dto.ShortDTO;
import com.app.weather.entity.MidEntity;
import com.app.weather.entity.ShortEntity;
import com.app.weather.entity.ShortPk;
import com.app.weather.repository.ShortItemRepository;
import com.app.weather.repository.ShortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
