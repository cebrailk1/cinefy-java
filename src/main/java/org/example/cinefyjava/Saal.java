package org.example.cinefyjava;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Repräsentiert einen Kinosaal mit seinen Kapazitätsdetails.
 * Entspricht der SAAL-Tabelle im ER-Diagramm.
 */
@Entity
@Table(name = "saal")
@Getter
@Setter
@NoArgsConstructor // Lombok generiert einen Konstruktor ohne Argumente
public class Saal {

    /**
     * Die ID des Saals (PK). Wir verwenden GenerationType.IDENTITY, da die ID
     * vom Benutzer (Saal 1, 2, 3) zugewiesen werden kann, aber in der DB auto-generiert wird.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saal_id")
    private Integer id;

    /**
     * Der Name des Saals (z.B. "Saal 1").
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Gesamtzahl der Reihen im Saal.
     */
    @Column(name = "anzahl_reihen", nullable = false)
    private Integer anzahlReihen;

    /**
     * Anzahl der Sitze pro Reihe.
     */
    @Column(name = "sitze_pro_reihe", nullable = false)
    private Integer sitzeProReihe;

    // Konstruktor für die Initialisierung der Daten
    public Saal(String name, Integer anzahlReihen, Integer sitzeProReihe) {
        this.name = name;
        this.anzahlReihen = anzahlReihen;
        this.sitzeProReihe = sitzeProReihe;
    }
}
