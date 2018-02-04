package com.rhanem.backend.persistence.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true, nullable = false, name = "USER_NAME")
    private String name;

    @Column(nullable = false)
    private String password;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "PRENOM")
    private String prenom;

    @ManyToOne
    @JoinColumn(name="SERVICE_ID")
    private  Service service;

    @ManyToOne
    @JoinColumn(name="SECTION_ID")
    private  Section section;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(// @formatter:off
        joinColumns =        { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "AUTHORITY_ID") }
    ) // @formatter:on
    private Set<Authority> authorities;

    public User() {
        super();
    }


    public User(String name, String password, String nom, String prenom, Service service, Section section, Set<Authority> authorities) {
        this.name = name;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
        this.section = section;
        this.authorities = authorities;
    }

    public User(final String nameToSet, final String passwordToSet, String nomToSet, String prenomToSet, final Set<Authority> rolesToSet) {
        super();

        name = nameToSet;
        password = passwordToSet;
        nom = nomToSet;
        prenom = prenomToSet;
        authorities = rolesToSet;
       
    }

    public User(final String nameToSet, final String passwordToSet, final String nomToSet,final String prenomToSet, final Set<Authority> rolesToSet, final String uuidToSet) {
        this(nameToSet, passwordToSet, nomToSet, prenomToSet,rolesToSet);
    }

    public User(String name, String password, String nom, String prenom, Service service, Set<Authority> authorities) {
        this.name = name;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
        this.authorities = authorities;
    }

    //Service service


    // API


    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long idToSet) {
        id = idToSet;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String passwordToSet) {
        password = passwordToSet;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(final Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }



    public String getNom() {
		return nom;
	}

	public void setNom(final String nomToSet) {
		this.nom = nomToSet;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenomToSet) {
		this.prenom = prenomToSet;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }




}
