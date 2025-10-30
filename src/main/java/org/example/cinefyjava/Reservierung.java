package org.example.cinefyjava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Repräsentiert eine Reservierung für eine bestimmte Vorführung und Sitzplätze.
 */
@Entity
@Table(name = "reservierung")
@Getter
@Setter
@NoArgsConstructor
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reservierungsnummer", nullable = false, unique = true)
    private String reservierungsnummer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vorfuehrung_id", nullable = false)
    private Vorfuehrung vorfuehrung;

    @Column(name = "erstellt_am", nullable = false)
    private LocalDateTime erstelltAm = LocalDateTime.now();

    @OneToMany(mappedBy = "reservierung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ReservierungSitzplatz> sitzplaetze = new HashSet<>();

    public Reservierung(String reservierungsnummer, Vorfuehrung vorfuehrung) {
        this.reservierungsnummer = reservierungsnummer;
        this.vorfuehrung = vorfuehrung;
    }
}
