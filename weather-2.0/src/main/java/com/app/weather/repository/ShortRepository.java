package com.app.weather.repository;

import com.app.weather.entity.ShortEntity;
import com.app.weather.entity.ShortPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortRepository extends JpaRepository<ShortEntity, ShortPk> {
}
