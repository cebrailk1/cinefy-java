package org.example.cinefyjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Konfigurationsklasse zum Initialisieren der Kinosaal- und Sitzplatz-Daten beim Start der Anwendung.
 */
@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(SaalRepository saalRepository, SitzplatzRepository sitzplatzRepository) {
        return args -> {
            if (saalRepository.count() == 0) {
                Saal saal1 = new Saal("Saal 1 (Premium)", 15, 25);
                Saal saal2 = new Saal("Saal 2 (Groß)", 20, 25);
                Saal saal3 = new Saal("Saal 3 (Klein)", 10, 15);

                List<Saal> saele = saalRepository.saveAll(Arrays.asList(saal1, saal2, saal3));

                List<Sitzplatz> sitzplaetze = new ArrayList<>();
                for (Saal saal : saele) {
                    for (int reihe = 1; reihe <= saal.getReihen(); reihe++) {
                        for (int platz = 1; platz <= saal.getSitzeProReihe(); platz++) {
                            sitzplaetze.add(new Sitzplatz(saal, reihe, platz));
                        }
                    }
                }
                sitzplatzRepository.saveAll(sitzplaetze);

                System.out.printf("Initialisierung abgeschlossen: %d Säle und %d Sitzplätze gespeichert.%n",
                        saele.size(), sitzplaetze.size());
            } else {
                System.out.println("Saal- und Sitzplatz-Daten existieren bereits, keine Initialisierung notwendig.");
            }
        };
    }
}
