package com.rhanem.backend.persistence.setup;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.rhanem.backend.persistence.model.Authority;
import com.rhanem.backend.persistence.model.User;
import com.rhanem.backend.persistence.service.IAuthorityService;
import com.rhanem.backend.persistence.service.IUserService;

@Component
public class SecuritySetup implements ApplicationListener<ContextRefreshedEvent> {
    static final Logger logger = LoggerFactory.getLogger(SecuritySetup.class);

    private boolean setupDone;

    @Autowired
    IUserService userService;

    @Autowired
    IAuthorityService authorityService;

    @Autowired
    ApplicationContext eventPublisher;

    public SecuritySetup() {
        super();
    }

    //

    public final void onApplicationEvent(final ContextRefreshedEvent event) {
        if (!setupDone) {
            logger.info("Executing Setup");

            createAuthorities();
            createUsers();

            setupDone = true;
            logger.info("Setup Done");
        }
    }

    // Authority

    private void createAuthorities() {
        createAuthorityIfNotExisting("ROLE_ADMIN");
        createAuthorityIfNotExisting("ROLE_CHEF_RH");
        createAuthorityIfNotExisting("ROLE_CHEF_SECTION");
        createAuthorityIfNotExisting("ROLE_USER");
        createAuthorityIfNotExisting("CHEF_SERVICE");
    }

    final void createAuthorityIfNotExisting(final String name) {
        final Authority entityByName = authorityService.findByName(name);
        if (entityByName == null) {
            final Authority entity = new Authority(name);
            authorityService.create(entity);
        }
    }

    // Principal/User

    final void createUsers() {
        final Authority authorityUser = authorityService.findByName("ROLE_USER");
        final Authority authorityAdmin = authorityService.findByName("ROLE_ADMIN");
        final Authority authorityChefRh = authorityService.findByName("ROLE_CHEF_RH");
        final Authority authorityChefSection = authorityService.findByName("ROLE_CHEF_SECTION");
        final Authority authorityChefService = authorityService.findByName("ROLE_CHEF_SERVICE");

        createUserIfNotExisting(SecurityConstants.ADMIN1_USERNAME,SecurityConstants.ADMIN1_NOM,SecurityConstants.ADMIN1_PRENOM, SecurityConstants.ADMIN1_PASS, Sets.<Authority> newHashSet(authorityUser, authorityAdmin));
        createUserIfNotExisting(SecurityConstants.ADMIN2_USERNAME,SecurityConstants.ADMIN2_NOM,SecurityConstants.ADMIN2_PRENOM, SecurityConstants.ADMIN2_PASS, Sets.<Authority> newHashSet(authorityChefSection, authorityAdmin));
        createUserIfNotExisting(SecurityConstants.USER1_USERNAME,SecurityConstants.USER1_NOM,SecurityConstants.USER1_PRENOM, SecurityConstants.USER1_PASS, Sets.<Authority> newHashSet(authorityUser));
        createUserIfNotExisting(SecurityConstants.CHEF_RH_USERNAME,SecurityConstants.CHEF_RH_NOM,SecurityConstants.CHEF_RH_PRENOM, SecurityConstants.CHEF_RH_PASS, Sets.<Authority> newHashSet(authorityChefRh));
        createUserIfNotExisting(SecurityConstants.CHEF_SECTION_USERNAME,SecurityConstants.CHEF_SECTION_NOM,SecurityConstants.CHEF_SECTION_PRENOM, SecurityConstants.CHEF_SECTION_PASS, Sets.<Authority> newHashSet(authorityChefSection));
        createUserIfNotExisting(SecurityConstants.CHEF_SERVICE_USERNAME,SecurityConstants.CHEF_SERVICE_NOM,SecurityConstants.CHEF_SERVICE_PRENOM, SecurityConstants.CHEF_SERVICE_PASS, Sets.<Authority> newHashSet(authorityChefService));
   
    }

    final void createUserIfNotExisting(final String username, final String nom, final String prenom, final String pass, final Set<Authority> authorities) {
        final User entityByName = userService.findByName(username);
        if (entityByName == null) {
            final User entity = new User(username, nom, prenom, pass, authorities);
            userService.create(entity);
        }
    }

}
