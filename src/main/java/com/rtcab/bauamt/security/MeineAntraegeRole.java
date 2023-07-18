package com.rtcab.bauamt.security;

import com.rtcab.bauamt.entity.Antrag;
import com.rtcab.bauamt.entity.Bauherr;
import com.rtcab.bauamt.entity.Bauvorlage;
import com.rtcab.bauamt.entity.Entwurfsverfasser;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "MeineAntraegeRole", code = MeineAntraegeRole.CODE)
public interface MeineAntraegeRole {
    String CODE = "meine-antraege-role";

    @JpqlRowLevelPolicy(entityClass = Antrag.class, where = "{E}.createdBy = :current_user_username")
    void antrag();

    @JpqlRowLevelPolicy(entityClass = Bauherr.class, where = "{E}.createdBy = :current_user_username")
    void bauherr();

    @JpqlRowLevelPolicy(entityClass = Bauvorlage.class, where = "{E}.createdBy = :current_user_username")
    void bauvorlage();

    @JpqlRowLevelPolicy(entityClass = Entwurfsverfasser.class, where = "{E}.createdBy = :current_user_username")
    void entwurfsverfasser();
}
