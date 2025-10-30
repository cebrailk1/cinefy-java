package org.example.cinefyjava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Repräsentiert einen Sitzplatz in einem bestimmten Saal.
 */
@Entity
@Table(
        name = "sitzplatz",
        uniqueConstraints = @UniqueConstraint(columnNames = {"saal_id", "reihe", "platznummer"})
)
@Getter
@Setter
@NoArgsConstructor
public class Sitzplatz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saal_id", nullable = false)
    @JsonIgnore
    private Saal saal;

    @Column(name = "reihe", nullable = false)
    private Integer reihe;

    @Column(name = "platznummer", nullable = false)
    private Integer platznummer;

    @OneToMany(mappedBy = "sitzplatz", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ReservierungSitzplatz> reservierungen = new HashSet<>();

    public Sitzplatz(Saal saal, Integer reihe, Integer platznummer) {
        this.saal = saal;
        this.reihe = reihe;
        this.platznummer = platznummer;
    }
}
