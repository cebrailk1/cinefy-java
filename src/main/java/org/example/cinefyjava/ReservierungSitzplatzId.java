package org.example.cinefyjava;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Zusammengesetzter Primärschlüssel für {@link ReservierungSitzplatz}.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReservierungSitzplatzId implements Serializable {

    @Column(name = "reservierung_id")
    private Integer reservierungId;

    @Column(name = "sitzplatz_id")
    private Integer sitzplatzId;

    public ReservierungSitzplatzId(Integer reservierungId, Integer sitzplatzId) {
        this.reservierungId = reservierungId;
        this.sitzplatzId = sitzplatzId;
    }
}
