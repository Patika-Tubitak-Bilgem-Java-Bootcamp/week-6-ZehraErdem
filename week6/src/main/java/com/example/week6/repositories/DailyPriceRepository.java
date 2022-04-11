package com.example.week6.repositories;

import com.example.week6.components.DailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyPriceRepository extends JpaRepository<DailyPrice,Long> {
}
