package com.rhanem.backend.persistence.model;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "pointage_badge")
public class PointageBadge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pointage")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PADGE_ID")
    private Badge badge ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pointageDateIn;

    private int autorisation;

    private String pointageImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNITE_ID")
    private Service unite;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pointageDateOut;


    public PointageBadge() {
    }

    public PointageBadge(Badge badge, Date pointageDateIn, int autorisation, String pointageImage, Service unite, Date pointageDateOut) {
        this.badge = badge;
        this.pointageDateIn = pointageDateIn;
        this.autorisation = autorisation;
        this.pointageImage = pointageImage;
        this.unite = unite;
        this.pointageDateOut = pointageDateOut;
    }

    public PointageBadge(Badge badge, Date pointageDateIn, int autorisation, String pointageImage, Service unite) {
        this.badge = badge;
        this.pointageDateIn = pointageDateIn;
        this.autorisation = autorisation;
        this.pointageImage = pointageImage;
        this.unite = unite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Date getPointageDateIn() {
        return pointageDateIn;
    }

    public void setPointageDateIn(Date pointageDateIn) {
        this.pointageDateIn = pointageDateIn;
    }

    public int getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(int autorisation) {
        this.autorisation = autorisation;
    }

    public String getPointageImage() {
        return pointageImage;
    }

    public void setPointageImage(String pointageImage) {
        this.pointageImage = pointageImage;
    }

    public Service getUnite() {
        return unite;
    }

    public void setUnite(Service unite) {
        this.unite = unite;
    }

    public Date getPointageDateOut() {
        return pointageDateOut;
    }

    public void setPointageDateOut(Date pointageDateOut) {
        this.pointageDateOut = pointageDateOut;
        }

    @Override
    public String toString() {
        return "PointageBadge{" +
                "id=" + id +
                ", badge=" + badge +
                ", pointageDateIn=" + pointageDateIn +
                ", autorisation=" + autorisation +
                ", pointageImage='" + pointageImage + '\'' +
                ", unite=" + unite +
                ", pointageDateOut=" + pointageDateOut +
                '}';
    }
}
