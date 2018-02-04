package com.rhanem.backend.persistence.model;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "REGION")
public class Region {

    @Id
    @Column(name = "REGION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "REGION")
    private String region;



    @OneToMany(targetEntity = Compagnie.class, mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Compagnie> compagnie;



    public Region() {
    }

    public Region(String region) {
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Compagnie> getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Set<Compagnie> compagnie) {
        this.compagnie = compagnie;
    }
}
