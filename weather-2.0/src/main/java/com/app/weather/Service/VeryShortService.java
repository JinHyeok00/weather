package com.app.weather.Service;

import com.app.weather.dto.VeryShortDTO;
import com.app.weather.entity.ShortPk;
import com.app.weather.entity.VeryShortEntity;
import com.app.weather.repository.VeryShortItemRepository;
import com.app.weather.repository.VeryShortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
