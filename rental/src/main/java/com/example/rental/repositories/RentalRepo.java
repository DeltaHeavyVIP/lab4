package com.example.rental.repositories;

import com.example.rental.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Integer> {

    List<Rental> findAllByUsername(String username);

    Optional<Rental> findByRentalUidAndUsername(UUID rentalUID, String userName);

}
