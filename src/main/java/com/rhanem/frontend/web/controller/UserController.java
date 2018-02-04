package com.rhanem.frontend.web.controller;


import com.google.common.collect.Sets;
import com.rhanem.backend.persistence.model.*;
import com.rhanem.backend.persistence.service.IAuthorityService;
import com.rhanem.backend.persistence.service.IUserService;
import com.rhanem.backend.repository.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

@Controller
public class UserController {


    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    @Autowired
    IAuthorityService authorityService;


    //List of Users
    @RequestMapping(value = "/list-users", method = RequestMethod.GET)
    public String ListUserView(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "user/list";
    }

    //Add Users View Method
    @RequestMapping(value = "/ajouter-user", method = RequestMethod.GET)
    public String AddUserView(Model model) {
        model.addAttribute("service", serviceRepository.findAll());
        model.addAttribute("authority", authorityRepository.findAll());
        return "user/add";
    }

    //Add users to database
    @RequestMapping(value = "/ajouter-user", method = RequestMethod.POST)
    public String addGendarme(@RequestParam String nom,
                              @RequestParam String prenom,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String password2,
                              @RequestParam long service,
                              @RequestParam long authority) {

        final User entityByName = userService.findByName(username);
        Service srv = serviceRepository.findOne(service);
        if (entityByName == null) {

            Authority authority1 = authorityRepository.findOne(authority);
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            String has = md5.encodePassword(password, null);
            Authority authorityUser = authorityService.findByName(authority1.getName());
            User user = new User(username, has, nom, prenom, srv, Sets.<Authority>newHashSet(authorityUser));
            userService.create(user);
            return "user/add";
        } else {
            String msger = "errer=username est déja pris";
            return "redirect:ajouter-user.html?" + msger;
        }
    }


    @RequestMapping(value = "/modifier-user", method = RequestMethod.GET)
    public String getEditUserView(Model model, @RequestParam long id) {
        model.addAttribute("user", userRepository.findOne(id));
        model.addAttribute("service", serviceRepository.findAll());
        model.addAttribute("authority", authorityRepository.findAll());
        return "user/edit";
    }


    // edit user

    @RequestMapping(value = "/modifier-user", method = RequestMethod.POST)
    @Transactional
    public String postEditDemande(@RequestParam long id,
                                  @RequestParam("authority") long roleId,
                                  @RequestParam("password") String newPassword1,
                                  @RequestParam("password2") String newPassword2,
                                  @RequestParam("username") String name,
                                  @RequestParam String nom,
                                  @RequestParam long service,
                                  @RequestParam String prenom) {
        System.out.println("\n##############" + newPassword1 + "\n##############");

        User user = userRepository.findOne(id);
        String oldPassword = user.getPassword();
        Service srv = serviceRepository.findOne(service);
        final User entityByName = userService.findByName(name);

        Authority authority = authorityRepository.findOne(roleId);
        Authority authorityUser = authorityService.findByName(authority.getName());

        if (!user.getName().equals(name) && entityByName == null
                && newPassword1.equals("")) {
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setName(name);
            user.setPassword(oldPassword);
            System.out.println("\n1 : " + oldPassword);
            user.setAuthorities(Sets.<Authority>newHashSet(authorityUser));
            user.setService(srv);
            userRepository.save(user);
            return "redirect:modifier-user.html?id=" + user.getId();
        } else if (user.getName().equals(name) && newPassword1.equals("")) {
            System.out.println("\n1 : " + oldPassword);
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setPassword(oldPassword);
            user.setService(srv);
            user.setAuthorities(Sets.<Authority>newHashSet(authorityUser));
            userRepository.save(user);
            return "redirect:modifier-user.html?id=" + user.getId();

        } else if (!user.getName().equals(name) && entityByName == null
                && newPassword1.equals(newPassword2) && !newPassword1.equals("")) {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            String has = md5.encodePassword(newPassword1, null);
            System.out.println("\n1 : " + newPassword1);
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setName(name);
            user.setPassword(has);
            user.setService(srv);
            user.setAuthorities(Sets.<Authority>newHashSet(authorityUser));
            userRepository.save(user);
            return "redirect:modifier-user.html?id=" + user.getId();
        } else if (user.getName().equals(name) && newPassword1.equals(newPassword2)
                && !newPassword1.equals("")) {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            System.out.println("\n1 : " + newPassword1);
            String has = md5.encodePassword(newPassword1, null);
            user.setNom(nom);
            user.setService(srv);
            user.setPrenom(prenom);
            user.setPassword(has);
            user.setAuthorities(Sets.<Authority>newHashSet(authorityUser));
            userRepository.save(user);
            return "redirect:modifier-user.html?id=" + user.getId();
        } else {
            String msg = "modification a un error au niveau de password ou login!!";
            return "redirect:modifier-user.html?id=" + user.getId() + "&msg=" + msg;
        }
    }

    //delete user

    @RequestMapping(value = "/delete-user",  method = RequestMethod.GET)
    public String getDeleteUser(@RequestParam long id) {
        userRepository.delete(id);
            return "redirect:modifier-user.html";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public String PostDeleteUser(@RequestParam long id) {
        userRepository.delete(id);
        return "redirect:modifier-user.html";
    }

}



