package com.rhanem.backend.persistence.model;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "GRADE")
public class Grade {

    @Id
    @Column(name = "GRADE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "GRADE")
    private String grade;

    @OneToMany(mappedBy = "grade")
    private Set<ProfilInfo> profilInfo;


    public Grade(String grade, Set<ProfilInfo> profilInfo) {
        this.grade = grade;
        this.profilInfo = profilInfo;
    }

    public void setProfilInfo(Set<ProfilInfo> profilInfo) {
        this.profilInfo = profilInfo;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Set<ProfilInfo> getProfilInfo() {
        return profilInfo;
    }

    public Grade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
