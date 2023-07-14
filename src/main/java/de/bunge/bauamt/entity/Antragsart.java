package de.bunge.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Antragsart implements EnumClass<String> {

    BAUANTRAG("BAUANTRAG"),
    ABBRUCHANZEIGE("ABBRUCHANZEIGE"),
    ABWEICHUNG_AUSNAHME("ABWEICHUNG_AUSNAHME"),
    ANZEIGEVERFAHREN("ANZEIGEVERFAHREN");

    private final String id;

    Antragsart(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Antragsart fromId(String id) {
        for (Antragsart at : Antragsart.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
