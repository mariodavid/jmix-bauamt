package com.rtcab.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Abweichungskategorie implements EnumClass<String> {

    ABBRUCH("ABBRUCH"),
    EINBAU("EINBAU"),
    UMBAU("UMBAU"),
    NUTZUNGSAENDERUNG("NUTZUNGSAENDERUNG");

    private final String id;

    Abweichungskategorie(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Abweichungskategorie fromId(String id) {
        for (Abweichungskategorie at : Abweichungskategorie.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
