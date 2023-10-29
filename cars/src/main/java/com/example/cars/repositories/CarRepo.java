package com.example.cars.repositories;

import com.example.cars.models.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    List<Car> findAllByAvailability(boolean availability, Pageable pageable);

    Optional<Car> findByCarUid(UUID carUid);
}
