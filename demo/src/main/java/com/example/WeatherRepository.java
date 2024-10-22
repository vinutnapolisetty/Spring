package com.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherRecord,Long> {
    Optional<WeatherRecord> findByCity(String city);
}
