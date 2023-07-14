package de.bunge.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Bauvorlagentyp implements EnumClass<String> {

    AUSZUG_AUS_LIEGENSCHAFTSKARTE("AUSZUG_AUS_LIEGENSCHAFTSKARTE"),
    BAUBESCHREIBUNG("BAUBESCHREIBUNG"),
    BAUANTRAGSFORMULAR("BAUANTRAGSFORMULAR"),
    ARCHITEKTENLAGEPLAN("ARCHITEKTENLAGEPLAN"),
    AUSZUG_AUS_GRUNDBUCH("AUSZUG_AUS_GRUNDBUCH"),
    AUSZUG_AUS_DEUTSCHER_GRUNDKARTE("AUSZUG_AUS_DEUTSCHER_GRUNDKARTE");

    private final String id;

    Bauvorlagentyp(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Bauvorlagentyp fromId(String id) {
        for (Bauvorlagentyp at : Bauvorlagentyp.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
