package de.bunge.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Anrede implements EnumClass<String> {

    HERRN("HERRN"),
    AN_DIE("AN_DIE"),
    EHELEUTE("EHELEUTE"),
    FAMILIE("FAMILIE"),
    FIRMA("FIRMA"),
    FRAU("FRAU"),
    FRAU_HERRN("FRAU_HERRN"),
    FRAUEN("FRAUEN"),
    HERREN("HERREN");

    private final String id;

    Anrede(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Anrede fromId(String id) {
        for (Anrede at : Anrede.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
