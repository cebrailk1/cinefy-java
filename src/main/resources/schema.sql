PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS saal (
                                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                                    name TEXT NOT NULL,
                                    reihen INTEGER NOT NULL,
                                    sitze_pro_reihe INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS sitzplatz (
                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                                         saal_id INTEGER NOT NULL,
                                         reihe INTEGER NOT NULL,
                                         platznummer INTEGER NOT NULL,
                                         FOREIGN KEY (saal_id) REFERENCES saal(id)
    );

CREATE TABLE IF NOT EXISTS vorfuehrung (
                                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                                           saal_id INTEGER NOT NULL,
                                           datum DATE NOT NULL,
                                           uhrzeit TIME NOT NULL,
                                           FOREIGN KEY (saal_id) REFERENCES saal(id)
    );

CREATE TABLE IF NOT EXISTS reservierung (
                                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                                            reservierungsnummer TEXT UNIQUE NOT NULL,
                                            vorfuehrung_id INTEGER NOT NULL,
                                            erstellt_am DATETIME DEFAULT CURRENT_TIMESTAMP,
                                            FOREIGN KEY (vorfuehrung_id) REFERENCES vorfuehrung(id)
    );

CREATE TABLE IF NOT EXISTS reservierung_sitzplatz (
                                                      reservierung_id INTEGER NOT NULL,
                                                      sitzplatz_id INTEGER NOT NULL,
                                                      PRIMARY KEY (reservierung_id, sitzplatz_id),
    FOREIGN KEY (reservierung_id) REFERENCES reservierung(id),
    FOREIGN KEY (sitzplatz_id) REFERENCES sitzplatz(id)
    );
