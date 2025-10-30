package org.example.cinefyjava;

import org.example.cinefyjava.Saal;
import org.example.cinefyjava.SaalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Konfigurationsklasse zum Initialisieren der Kinosaal-Daten beim Start der Anwendung.
 * Führt die Initialisierung nur durch, wenn noch keine Säle existieren.
 */
@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(SaalRepository saalRepository) {
        return args -> {
            // Prüfen, ob bereits Daten vorhanden sind
            if (saalRepository.count() == 0) {

                // Saal 1: 15 Reihen mit je 25 Sitzen
                Saal saal1 = new Saal("Saal 1 (Premium)", 15, 25);

                // Saal 2: 20 Reihen mit je 25 Sitzen
                Saal saal2 = new Saal("Saal 2 (Groß)", 20, 25);

                // Saal 3: 10 Reihen mit je 15 Sitzen
                Saal saal3 = new Saal("Saal 3 (Klein)", 10, 15);

                List<Saal> saele = Arrays.asList(saal1, saal2, saal3);
                saalRepository.saveAll(saele);

                System.out.println("Saal-Daten erfolgreich initialisiert: " + saele.size() + " Säle gespeichert.");
            } else {
                System.out.println("Saal-Daten existieren bereits, keine Initialisierung notwendig.");
            }
        };
    }
}
