package com.rhanem.backend.persistence.model;
import javax.persistence.*;
import java.util.Set;


@Entity(name = "SECTION")
public class Section {

    @Id
    @Column(name = "SECTION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SECTION_NAME")
    private String section;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "section")
    private Set<User> user;

    @OneToMany(mappedBy = "section")
    private Set<ProfilInfo> profilInfo;

    public Section() {
    }

    public Section(String section, Service service, Set<User> user, Set<ProfilInfo> profilInfo) {
        this.section = section;
        this.service = service;
        this.user = user;
        this.profilInfo = profilInfo;
    }

    public Section(String section, Service service, Set<ProfilInfo> profilInfo) {
        this.section = section;
        this.service = service;
        this.profilInfo = profilInfo;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ProfilInfo> getProfilInfo() {
        return profilInfo;
    }

    public void setProfilInfo(Set<ProfilInfo> profilInfo) {
        this.profilInfo = profilInfo;
    }

    public Section(String section) {
        this.section = section;
    }

    public Section(String section, Service service) {
        this.section = section;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public Service getService() {
        return service;
    }
}




