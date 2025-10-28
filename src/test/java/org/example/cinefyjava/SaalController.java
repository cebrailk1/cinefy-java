package org.example.cinefyjava;

import org.example.cinefyjava.Saal;
import org.example.cinefyjava.SaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller für die Verwaltung der Kinosaal-Daten.
 * Endpunkt: /api/v1/saele
 */
@RestController
@RequestMapping("/api/v1/saele")
// @CrossOrigin ist wichtig, damit das Vue Frontend (das auf einem anderen Port läuft) zugreifen kann.
@CrossOrigin(origins = "http://localhost:8081") // Ersetzen durch den tatsächlichen Vue-Port
public class SaalController {

    private final SaalRepository saalRepository;

    @Autowired
    public SaalController(SaalRepository saalRepository) {
        this.saalRepository = saalRepository;
    }

    /**
     * Ruft alle Kinosaal-Konfigurationen ab.
     * GET /api/v1/saele
     * @return Liste aller Säle.
     */
    @GetMapping
    public ResponseEntity<List<Saal>> getAllSaele() {
        List<Saal> saele = saalRepository.findAll();
        return ResponseEntity.ok(saele);
    }
}
