package de.bunge.bauamt.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Table(name = "ABWEICHUNG", indexes = {
        @Index(name = "IDX_ABWEICHUNG_UNTERKATEGORIE", columnList = "UNTERKATEGORIE_ID")
})
@DiscriminatorValue("ABWEICHUNG")
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "ANTRAG_ID", referencedColumnName = "ID")
public class Abweichung extends Antrag {
    @NotNull
    @Column(name = "BEGRUENDUNG", nullable = false)
    private String begruendung;

    @Column(name = "KATEGORIE", nullable = false)
    @NotNull
    private String kategorie;

    @JoinColumn(name = "UNTERKATEGORIE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Abweichungsunterkategorie unterkategorie;

    public Abweichungsunterkategorie getUnterkategorie() {
        return unterkategorie;
    }

    public void setUnterkategorie(Abweichungsunterkategorie unterkategorie) {
        this.unterkategorie = unterkategorie;
    }

    public Abweichungskategorie getKategorie() {
        return kategorie == null ? null : Abweichungskategorie.fromId(kategorie);
    }

    public void setKategorie(Abweichungskategorie kategorie) {
        this.kategorie = kategorie == null ? null : kategorie.getId();
    }

    public String getBegruendung() {
        return begruendung;
    }

    public void setBegruendung(String begruendung) {
        this.begruendung = begruendung;
    }
}
