package com.rhanem.backend.persistence.model;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "BADGE")
public class Badge {

    @Id
    @Column(name = "BADGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="TYPE_BADGE_ID")
    private TypeBadge typebadge;

    @Column(name = "SERIAL_NUMBER_BADGE")
    private Integer NrSerie;

    @Column(name = "ETAT_BADGE")
    private Boolean Activation;

    @OneToMany(mappedBy = "badge")
    private Set<ProfilInfo> profilInfo;



    public Badge() {
    }

    public Badge(TypeBadge typebadge, Integer nrSerie, Boolean activation, Set<ProfilInfo> profilInfo) {
        this.typebadge = typebadge;
        NrSerie = nrSerie;
        Activation = activation;
        this.profilInfo = profilInfo;
    }

    public Badge(TypeBadge typebadge, Integer nrSerie, Boolean activation) {
        this.typebadge = typebadge;
        NrSerie = nrSerie;
        Activation = activation;
    }

    public Set<ProfilInfo> getProfilInfo() {
        return profilInfo;
    }

    public void setProfilInfo(Set<ProfilInfo> profilInfo) {
        this.profilInfo = profilInfo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeBadge getTypeBadge() {
        return typebadge;
    }

    public void setTypeBadge(TypeBadge typeBadge) {
        this.typebadge = typeBadge;
    }

    public Integer getNrSerie() {
        return NrSerie;
    }

    public void setNrSerie(Integer nrSerie) {
        NrSerie = nrSerie;
    }

    public Boolean getActivation() {
        return Activation;
    }

    public void setActivation(Boolean activation) {
        Activation = activation;
    }

    public TypeBadge getTypebadge() {
        return typebadge;
    }

    public void setTypebadge(TypeBadge typebadge) {
        this.typebadge = typebadge;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", typeBadge=" + typebadge +
                ", NrSerie=" + NrSerie +
                ", Activation=" + Activation +
                '}';
    }
}
