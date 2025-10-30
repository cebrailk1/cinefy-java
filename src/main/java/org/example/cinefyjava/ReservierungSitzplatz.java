package org.example.cinefyjava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Verknüpft eine Reservierung mit einem Sitzplatz.
 */
@Entity
@Table(name = "reservierung_sitzplatz")
@Getter
@Setter
@NoArgsConstructor
public class ReservierungSitzplatz {

    @EmbeddedId
    private ReservierungSitzplatzId id = new ReservierungSitzplatzId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("reservierungId")
    @JoinColumn(name = "reservierung_id", nullable = false)
    @JsonIgnore
    private Reservierung reservierung;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sitzplatzId")
    @JoinColumn(name = "sitzplatz_id", nullable = false)
    private Sitzplatz sitzplatz;

    public ReservierungSitzplatz(Reservierung reservierung, Sitzplatz sitzplatz) {
        this.reservierung = reservierung;
        this.sitzplatz = sitzplatz;
    }
}
