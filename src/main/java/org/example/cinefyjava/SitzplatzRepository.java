package org.example.cinefyjava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitzplatzRepository extends JpaRepository<Sitzplatz, Integer> {
}
