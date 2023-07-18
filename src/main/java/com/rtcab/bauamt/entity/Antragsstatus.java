package com.rtcab.bauamt.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Antragsstatus implements EnumClass<String> {

    ERFASSUNG("ERFASSUNG");

    private final String id;

    Antragsstatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Antragsstatus fromId(String id) {
        for (Antragsstatus at : Antragsstatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
