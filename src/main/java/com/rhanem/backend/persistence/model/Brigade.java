package com.rhanem.backend.persistence.model;




import javax.persistence.*;


@Entity(name = "BRIGADE_TERRITORIALE")
public class Brigade {

    @Id
    @Column(name = "BT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BRIGADE_TERRITORIALE")
    private String Brigade;

    @ManyToOne
    @JoinColumn(name="COMPAGNIE_ID")
    private Compagnie  compagnie ;

    /**###########################################################################################################*/

    public Brigade() {
    }

    public Brigade(Long id, String brigade, Compagnie compagnie) {
        this.id = id;
        Brigade = brigade;
        this.compagnie = compagnie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrigade() {
        return Brigade;
    }

    public void setBrigade(String brigade) {
        Brigade = brigade;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }
}
