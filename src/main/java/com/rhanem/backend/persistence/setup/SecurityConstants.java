package com.rhanem.backend.persistence.setup;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public final class SecurityConstants {

    // to be cleared out

    public static final String ADMIN1_USERNAME = "admin1";
    public static final String ADMIN1_PASS = "admin1Pass";
    public static final String ADMIN1_NOM = "admin1";
    public static final String ADMIN1_PRENOM = "admin";
    
    public static final String ADMIN2_USERNAME = "admin2";
    public static final String ADMIN2_PASS = "admin2Pass";
    public static final String ADMIN2_NOM = "admin2";
    public static final String ADMIN2_PRENOM = "admin";
    
    public static final String USER1_USERNAME = "user1";
    public static final String USER1_PASS = "user1Pass";
    public static final String USER1_NOM = "user1";
    public static final String USER1_PRENOM = "user";

    public static final String CHEF_RH_USERNAME = "chefrh";
    public static final String CHEF_RH_PASS = "chefrh";
    public static final String CHEF_RH_NOM = "chefrh";
    public static final String CHEF_RH_PRENOM = "chefrh";

    public static final String CHEF_SECTION_USERNAME = "chefsection";
    public static final String CHEF_SECTION_PASS = "chefsection";
    public static final String CHEF_SECTION_NOM = "chefsection";
    public static final String CHEF_SECTION_PRENOM = "chefsection";

    public static final String CHEF_SERVICE_USERNAME = "chefsection";
    public static final String CHEF_SERVICE_PASS = "chefsection";
    public static final String CHEF_SERVICE_NOM = "chefsection";
    public static final String CHEF_SERVICE_PRENOM = "chefsection";

    // privileges

    public static final class Authorities {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String CHEF_SECTION = "ROLE_CHEF_SECTION";
        public static final String CHEF_RH = "ROLE_CHEF_RH";
        public static final String CHEF_SERVICE = "ROLE_CHEF_CHEF_SERVICE";
    }


    private SecurityConstants() {
        throw new AssertionError();
    }

    // API

    public static Set<String> getNamesOfAuthoritiesForAdmin() {
        return ImmutableSet.of(// @formatter:off
            Authorities.USER,
            Authorities.ADMIN,
            Authorities.CHEF_SECTION,
            Authorities.CHEF_RH,
            Authorities.CHEF_SERVICE
        );
        // @formatter:on
    }

    public static Set<String> getNamesOfAuthoritiesForUser() {
        return ImmutableSet.of(Authorities.USER);
    }
    
    public static Set<String> getNamesOfAuthoritiesForChefSection() {
        return ImmutableSet.of(Authorities.CHEF_SECTION);
    }
    
    
    public static String[] getNamesOfAuthoritiesForChefRhAsArray() {
        return new String[] { Authorities.CHEF_RH,Authorities.CHEF_SECTION};
    }

    public static String[] getNamesOfAuthoritiesForAdminAsArray() {
        return new String[] { Authorities.USER, Authorities.ADMIN, Authorities.CHEF_SECTION,Authorities.CHEF_RH,Authorities.CHEF_SERVICE};
    }

    public static String[] getNamesOfAuthoritiesForChefServiceAsArray() {
        return new String[] { Authorities.USER, Authorities.CHEF_SECTION,Authorities.CHEF_RH,Authorities.CHEF_SERVICE};
    }

    public static String[] getNamesOfAuthoritiesForUserAsArray() {
        return new String[] { Authorities.USER };
    }

}
