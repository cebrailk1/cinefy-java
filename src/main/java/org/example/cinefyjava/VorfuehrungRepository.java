package org.example.cinefyjava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VorfuehrungRepository extends JpaRepository<Vorfuehrung, Integer> {
}
