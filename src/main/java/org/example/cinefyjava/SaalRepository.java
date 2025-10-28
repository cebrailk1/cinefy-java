package org.example.cinefyjava;

import org.example.cinefyjava.Saal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenzugriff auf die Saal-Entität.
 * Erweitert JpaRepository für automatische CRUD-Funktionen.
 */
@Repository
public interface SaalRepository extends JpaRepository<Saal, Integer> {
    // Hier können benutzerdefinierte Abfragen hinzugefügt werden, falls nötig.
}
