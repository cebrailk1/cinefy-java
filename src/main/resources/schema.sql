CREATE TABLE IF NOT EXISTS saal (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    reihen INTEGER NOT NULL,
    sitze_pro_reihe INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS sitzplatz (
    id SERIAL PRIMARY KEY,
    saal_id INTEGER NOT NULL,
    reihe INTEGER NOT NULL,
    platznummer INTEGER NOT NULL,
    CONSTRAINT fk_sitzplatz_saal FOREIGN KEY (saal_id) REFERENCES saal(id) ON DELETE CASCADE,
    CONSTRAINT uk_sitzplatz UNIQUE (saal_id, reihe, platznummer)
);

CREATE TABLE IF NOT EXISTS vorfuehrung (
    id SERIAL PRIMARY KEY,
    saal_id INTEGER NOT NULL,
    datum DATE NOT NULL,
    uhrzeit TIME NOT NULL,
    CONSTRAINT fk_vorfuehrung_saal FOREIGN KEY (saal_id) REFERENCES saal(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS reservierung (
    id SERIAL PRIMARY KEY,
    reservierungsnummer VARCHAR(255) UNIQUE NOT NULL,
    vorfuehrung_id INTEGER NOT NULL,
    erstellt_am TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_reservierung_vorfuehrung FOREIGN KEY (vorfuehrung_id) REFERENCES vorfuehrung(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS reservierung_sitzplatz (
    reservierung_id INTEGER NOT NULL,
    sitzplatz_id INTEGER NOT NULL,
    PRIMARY KEY (reservierung_id, sitzplatz_id),
    CONSTRAINT fk_rs_reservierung FOREIGN KEY (reservierung_id) REFERENCES reservierung(id) ON DELETE CASCADE,
    CONSTRAINT fk_rs_sitzplatz FOREIGN KEY (sitzplatz_id) REFERENCES sitzplatz(id) ON DELETE CASCADE
);
