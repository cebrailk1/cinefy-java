package org.example.cinefyjava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert einen Kinosaal mit seinen Kapazitätsdetails.
 * Entspricht der Tabelle {@code saal} im Datenbankschema.
 */
@Entity
@Table(name = "saal")
@Getter
@Setter
@NoArgsConstructor
public class Saal {

    /**
     * Primärschlüssel des Saals.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Der Name des Saals (z. B. "Saal 1").
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Gesamtzahl der Reihen im Saal.
     */
    @Column(name = "reihen", nullable = false)
    private Integer reihen;

    /**
     * Anzahl der Sitze pro Reihe.
     */
    @Column(name = "sitze_pro_reihe", nullable = false)
    private Integer sitzeProReihe;

    @OneToMany(mappedBy = "saal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Sitzplatz> sitzplaetze = new ArrayList<>();

    @OneToMany(mappedBy = "saal")
    @JsonIgnore
    private List<Vorfuehrung> vorfuehrungen = new ArrayList<>();

    public Saal(String name, Integer reihen, Integer sitzeProReihe) {
        this.name = name;
        this.reihen = reihen;
        this.sitzeProReihe = sitzeProReihe;
    }
}
