package de.bunge.bauamt.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ANTRAG", indexes = {
        @Index(name = "IDX_ANTRAG_BAUHERR", columnList = "BAUHERR_ID"),
        @Index(name = "IDX_ANTRAG_ENTWURFSVERFASSER", columnList = "ENTWURFSVERFASSER_ID")
})
@Entity
public class Antrag {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "ANTRAGSART", nullable = false)
    @NotNull
    private String antragsart;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private String status;

    @Column(name = "AKTENZEICHEN", nullable = false)
    @NotNull
    private String aktenzeichen;

    @Column(name = "ANTRAGSEINGANG", nullable = false)
    @NotNull
    private LocalDate antragseingang;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BAUHERR_ID")
    private Bauherr bauherr;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "antrag")
    private List<Bauvorlage> bauvorlagen;

    @Column(name = "VORHABENTEXT")
    @Lob
    private String vorhabentext;

    @JoinColumn(name = "ENTWURFSVERFASSER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Entwurfsverfasser entwurfsverfasser;

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

    public Entwurfsverfasser getEntwurfsverfasser() {
        return entwurfsverfasser;
    }

    public void setEntwurfsverfasser(Entwurfsverfasser entwurfsverfasser) {
        this.entwurfsverfasser = entwurfsverfasser;
    }

    public String getVorhabentext() {
        return vorhabentext;
    }

    public void setVorhabentext(String vorhabentext) {
        this.vorhabentext = vorhabentext;
    }

    public List<Bauvorlage> getBauvorlagen() {
        return bauvorlagen;
    }

    public void setBauvorlagen(List<Bauvorlage> bauvorlagen) {
        this.bauvorlagen = bauvorlagen;
    }

    public Bauherr getBauherr() {
        return bauherr;
    }

    public void setBauherr(Bauherr bauherr) {
        this.bauherr = bauherr;
    }

    public LocalDate getAntragseingang() {
        return antragseingang;
    }

    public void setAntragseingang(LocalDate antragseingang) {
        this.antragseingang = antragseingang;
    }

    public String getAktenzeichen() {
        return aktenzeichen;
    }

    public void setAktenzeichen(String aktenzeichen) {
        this.aktenzeichen = aktenzeichen;
    }

    public Antragsstatus getStatus() {
        return status == null ? null : Antragsstatus.fromId(status);
    }

    public void setStatus(Antragsstatus status) {
        this.status = status == null ? null : status.getId();
    }

    public Antragsart getAntragsart() {
        return antragsart == null ? null : Antragsart.fromId(antragsart);
    }

    public void setAntragsart(Antragsart antragsart) {
        this.antragsart = antragsart == null ? null : antragsart.getId();
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
}
