package com.rtcab.bauamt.security;

import com.rtcab.bauamt.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "AntragstellerRole", code = AntragstellerRole.CODE)
public interface AntragstellerRole {
    String CODE = "antragsteller-role";

    @MenuPolicy(menuIds = "Antrag.list")
    @ViewPolicy(viewIds = {"Antrag.detail", "Antrag.list", "Bauherr.detail", "Bauvorlage.detail", "Entwurfsverfasser.detail", "LoginView", "Abweichung.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Antrag.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Antrag.class, actions = EntityPolicyAction.ALL)
    void antrag();

    @EntityAttributePolicy(entityClass = Bauherr.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Bauherr.class, actions = EntityPolicyAction.ALL)
    void bauherr();

    @EntityAttributePolicy(entityClass = Bauvorlage.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Bauvorlage.class, actions = EntityPolicyAction.ALL)
    void bauvorlage();

    @EntityAttributePolicy(entityClass = Entwurfsverfasser.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Entwurfsverfasser.class, actions = EntityPolicyAction.ALL)
    void entwurfsverfasser();

    @EntityAttributePolicy(entityClass = Bauvorlagenkonfiguration.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Bauvorlagenkonfiguration.class, actions = EntityPolicyAction.READ)
    void bauvorlagenkonfiguration();

    @EntityAttributePolicy(entityClass = Abweichungsunterkategorie.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Abweichungsunterkategorie.class, actions = EntityPolicyAction.READ)
    void abweichungsunterkategorie();

    @EntityAttributePolicy(entityClass = Abweichung.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Abweichung.class, actions = EntityPolicyAction.ALL)
    void abweichung();
}
