package com.app.weather.repository;

import com.app.weather.entity.mid.MidEntity;
import com.app.weather.entity.mid.MidPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MidRepository extends JpaRepository<MidEntity, MidPk> {
}
