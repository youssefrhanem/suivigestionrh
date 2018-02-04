package com.rhanem.backend.persistence.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "PROFILE_INFO")
public class ProfilInfo {


    @Id
    @Column(name = "PROFILE_INFO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "PRENOM")
    private String firstname;

    @Column(name = "NOM")
    private String lastname;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_NAISS")
    private Date birthday;

    @Column(name = "MLE_C")
    private Integer matricule;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "ADDRESS")
    private String address;



    //modified
    @ManyToOne
    @JoinColumn(name="SERVICE_ID")
    private  Service service;

    //modified
    @ManyToOne
    @JoinColumn(name="SECTION_ID")
    private Section section;



    @ManyToOne
    @JoinColumn(name="GRADE_ID")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name="BADGE_ID")
    private Badge badge;



    public ProfilInfo() {
    }


    public ProfilInfo(String firstname, String lastname, Date birthday, Integer matricule, String cin, String address, Service service, Section section, Grade grade, Badge badge) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.matricule = matricule;
        this.cin = cin;
        this.address = address;
        this.service = service;
        this.section = section;
        this.grade = grade;
        this.badge = badge;
    }

    public ProfilInfo(String firstname, String lastname, Date birthday, Integer matricule, String cin, String address,  Section section, Grade grade, Badge badge) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.matricule = matricule;
        this.cin = cin;
        this.address = address;
        this.section = section;
        this.grade = grade;
        this.badge = badge;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }


}
