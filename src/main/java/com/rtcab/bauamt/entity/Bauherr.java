package com.rtcab.bauamt.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "BAUHERR")
@Entity
public class Bauherr {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "JURISTISCHE_PERSON")
    private Boolean juristischePerson;

    @Column(name = "ANREDE")
    private String anrede;

    @Column(name = "TITEL")
    private String titel;

    @NotNull
    @Column(name = "VORNAME", nullable = false)
    private String vorname;

    @NotNull
    @Column(name = "NACHNAME", nullable = false)
    private String nachname;

    @Column(name = "NAMENSZUSATZ1")
    private String namenszusatz1;

    @Column(name = "NAMESZUSATZ2")
    private String nameszusatz2;

    @NotNull
    @Column(name = "STRASSE", nullable = false)
    private String strasse;

    @NotNull
    @Column(name = "HAUSNUMMER", nullable = false)
    private String hausnummer;

    @NotNull
    @Column(name = "POSTLEITZAHL", nullable = false)
    private String postleitzahl;

    @NotNull
    @Column(name = "ORT", nullable = false)
    private String ort;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "MOBIL")
    private String mobil;

    @NotNull
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bauherr")
    private Antrag antrag;

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }

    public Anrede getAnrede() {
        return anrede == null ? null : Anrede.fromId(anrede);
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede == null ? null : anrede.getId();
    }

    public Boolean getJuristischePerson() {
        return juristischePerson;
    }

    public void setJuristischePerson(Boolean juristischePerson) {
        this.juristischePerson = juristischePerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNameszusatz2() {
        return nameszusatz2;
    }

    public void setNameszusatz2(String nameszusatz2) {
        this.nameszusatz2 = nameszusatz2;
    }

    public String getNamenszusatz1() {
        return namenszusatz1;
    }

    public void setNamenszusatz1(String namenszusatz1) {
        this.namenszusatz1 = namenszusatz1;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"titel", "vorname", "nachname"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s %s %s",
                metadataTools.format(titel),
                metadataTools.format(vorname),
                metadataTools.format(nachname));
    }
}
