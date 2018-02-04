package com.rhanem.backend.persistence.model;


import javax.persistence.*;

@Entity(name = "COMPAGNIE")
public class Compagnie {

    @Id
    @Column(name = "COMPAGNIE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "COMPAGNIE")
    private String compagnie;

//    @ManyToOne
//    @JoinColumn(name="REGION_ID")
//    private Region Region;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    /**###########################################################################################################*/


    public Compagnie() {
    }

    public Compagnie(String compagnie, Region region) {
        this.compagnie = compagnie;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
