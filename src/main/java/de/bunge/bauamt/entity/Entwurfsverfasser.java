package de.bunge.bauamt.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "ENTWURFSVERFASSER")
@Entity
public class Entwurfsverfasser {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VORNAME")
    private String vorname;

    @Column(name = "NACHNAME")
    private String nachname;

    @Column(name = "NAMESZUSATZ1")
    private String nameszusatz1;

    @Column(name = "NAMESZUSATZ2")
    private String nameszusatz2;

    @Column(name = "BERUFSBEZEICHNUNG")
    private String berufsbezeichnung;

    @Column(name = "STRASSE", nullable = false)
    @NotNull
    private String strasse;

    @Column(name = "HAUSNUMMER", nullable = false)
    @NotNull
    private String hausnummer;

    @Column(name = "POSTLEITZAHL", nullable = false)
    @NotNull
    private String postleitzahl;

    @Column(name = "ORT", nullable = false)
    @NotNull
    private String ort;

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
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "entwurfsverfasser")
    private Antrag antrag;

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
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

    public String getBerufsbezeichnung() {
        return berufsbezeichnung;
    }

    public void setBerufsbezeichnung(String berufsbezeichnung) {
        this.berufsbezeichnung = berufsbezeichnung;
    }

    public String getNameszusatz2() {
        return nameszusatz2;
    }

    public void setNameszusatz2(String nameszusatz2) {
        this.nameszusatz2 = nameszusatz2;
    }

    public String getNameszusatz1() {
        return nameszusatz1;
    }

    public void setNameszusatz1(String nameszusatz1) {
        this.nameszusatz1 = nameszusatz1;
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
    @DependsOnProperties({"vorname", "nachname"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s %s",
                metadataTools.format(vorname),
                metadataTools.format(nachname));
    }
}
