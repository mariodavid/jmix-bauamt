package de.bunge.bauamt.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
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
@Table(name = "BAUVORLAGE", indexes = {
        @Index(name = "IDX_BAUVORLAGE_ANTRAG", columnList = "ANTRAG_ID")
})
@Entity
public class Bauvorlage {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "TYP", nullable = false)
    @NotNull
    private String typ;

    @Column(name = "PFLICHT", nullable = false)
    @NotNull
    private Boolean pflicht = false;

    @Column(name = "DATEI")
    @Lob
    private FileRef datei;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ANTRAG_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Antrag antrag;

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }

    public FileRef getDatei() {
        return datei;
    }

    public void setDatei(FileRef datei) {
        this.datei = datei;
    }

    public Boolean getPflicht() {
        return pflicht;
    }

    public void setPflicht(Boolean pflicht) {
        this.pflicht = pflicht;
    }

    public Bauvorlagentyp getTyp() {
        return typ == null ? null : Bauvorlagentyp.fromId(typ);
    }

    public void setTyp(Bauvorlagentyp typ) {
        this.typ = typ == null ? null : typ.getId();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
