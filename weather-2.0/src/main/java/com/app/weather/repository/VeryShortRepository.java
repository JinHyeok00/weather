package com.app.weather.repository;

import com.app.weather.entity.ShortPk;
import com.app.weather.entity.VeryShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeryShortRepository extends JpaRepository<VeryShortEntity, ShortPk> {
}
