package com.rhanem.backend.persistence.model;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "SERVICE")
public class Service {

    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SERVICE_NAME")
    private String service;

    @OneToMany(mappedBy = "service")
    private Set<ProfilInfo> profilInfo;

    @OneToMany(mappedBy = "service")
    private Set<User> user;

    public Service(String service, Set<ProfilInfo> profilInfo, Set<User> user) {
        this.service = service;
        this.profilInfo = profilInfo;
        this.user = user;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Service() {
    }

    public Service(String service, Set<ProfilInfo> profilInfo) {
        this.service = service;
        this.profilInfo = profilInfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Set<ProfilInfo> getProfilInfo() {
        return profilInfo;
    }

    public void setProfilInfo(Set<ProfilInfo> profilInfo) {
        this.profilInfo = profilInfo;
    }

    public Service(String service) {
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public String getService() {
        return service;
    }
}

