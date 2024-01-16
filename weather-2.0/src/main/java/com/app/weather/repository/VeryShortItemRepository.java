package com.app.weather.repository;

import com.app.weather.entity.VeryShortItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeryShortItemRepository extends JpaRepository<VeryShortItemEntity, Long> {
}
