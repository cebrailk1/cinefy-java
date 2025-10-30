package org.example.cinefyjava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {

    Optional<Reservierung> findByReservierungsnummer(String reservierungsnummer);
}
