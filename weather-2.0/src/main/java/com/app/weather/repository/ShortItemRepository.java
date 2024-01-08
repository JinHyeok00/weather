package com.app.weather.repository;

import com.app.weather.entity.ShortItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortItemRepository extends JpaRepository<ShortItemEntity, Long> {
}
