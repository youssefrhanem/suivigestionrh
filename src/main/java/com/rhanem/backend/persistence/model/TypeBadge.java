package com.rhanem.backend.persistence.model;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "TYPE_BADGE")
public class TypeBadge {

    @Id
    @Column(name = "TYPE_BADGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TYPE_BADGE")
    private String Type;

    @OneToMany(mappedBy = "typebadge")
    private Set<Badge> badge;

    public TypeBadge() {
    }

    public TypeBadge(String type) {
        Type = type;
    }

    public TypeBadge(String type, Set<Badge> badge) {
        Type = type;
        this.badge = badge;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Badge> getBadge() {
        return badge;
    }

    public void setBadge(Set<Badge> badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return "TypeBadge{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                '}';
    }
}
