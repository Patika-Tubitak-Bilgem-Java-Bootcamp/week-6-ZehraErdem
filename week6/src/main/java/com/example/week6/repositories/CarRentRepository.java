package com.example.week6.repositories;

import com.example.week6.components.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentRepository extends JpaRepository <CarRent,Long> {
}
