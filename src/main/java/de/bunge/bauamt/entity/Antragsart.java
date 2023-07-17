package de.bunge.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Antragsart implements EnumClass<String> {

    BAUANTRAG("BAUANTRAG", Antrag.class),
    ABBRUCHANZEIGE("ABBRUCHANZEIGE", Antrag.class),
    ABWEICHUNG_AUSNAHME("ABWEICHUNG_AUSNAHME", Abweichung.class),
    ANZEIGEVERFAHREN("ANZEIGEVERFAHREN", Antrag.class);

    private final String id;
    private final Class<? extends Antrag> antragClass;

    Antragsart(String id, Class<? extends Antrag> antragClass) {
        this.id = id;
        this.antragClass = antragClass;
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

    public Class<? extends Antrag> getAntragClass() {
        return antragClass;
    }
}
