package org.example.cinefyjava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert eine Filmvorführung in einem bestimmten Saal.
 */
@Entity
@Table(name = "vorfuehrung")
@Getter
@Setter
@NoArgsConstructor
public class Vorfuehrung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saal_id", nullable = false)
    private Saal saal;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "uhrzeit", nullable = false)
    private LocalTime uhrzeit;

    @OneToMany(mappedBy = "vorfuehrung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservierung> reservierungen = new ArrayList<>();

    public Vorfuehrung(Saal saal, LocalDate datum, LocalTime uhrzeit) {
        this.saal = saal;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
    }
}
