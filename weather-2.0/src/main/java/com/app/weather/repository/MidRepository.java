package com.app.weather.repository;

import com.app.weather.entity.MidEntity;
import com.app.weather.entity.MidPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MidRepository extends JpaRepository<MidEntity, MidPk> {
}
