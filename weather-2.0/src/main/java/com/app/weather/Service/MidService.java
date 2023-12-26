package com.app.weather.Service;

import com.app.weather.repository.MidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MidService {
    private final MidRepository midRepository;
}
