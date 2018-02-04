package com.rhanem.frontend.web.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.rhanem.backend.persistence.model.*;
import com.rhanem.backend.repository.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ProfileInfoController {

    @Autowired
    ProfileInfoRepository profileInfoRepository;

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    BadgeRepository badgeRepository;




    @RequestMapping(value = "/detaile-gendarme", method = RequestMethod.GET)
    public String getOneProfile(Model model,
                                @RequestParam Long id) {
        model.addAttribute("grade", gradeRepository.findAll());//items in jsp
        model.addAttribute("service", serviceRepository.findAll());
        model.addAttribute("section", sectionRepository.findAll());
        model.addAttribute("badge", badgeRepository.findAll());
        model.addAttribute("profile",profileInfoRepository.findOne(id));
        return "gendarme/gprofile";
    }


//List Gendarme
    @RequestMapping(value = "/list-gendarme", method = RequestMethod.GET)
    public String ListGendarmeView(Model model, HttpSession httpSession) {
        model.addAttribute("profiles", profileInfoRepository.findAll());//items in jsp
       /* model.addAttribute("grade", gradeRepository.findAll());
        List<ProfilInfo> profilInfo = profileInfoRepository.findAll();
        for (ProfilInfo p : profilInfo){
        System.out.println( "badge : "+ p.getBadge().getId());
        System.out.println( "section : "+  p.getSection().getSection().toString());
        System.out.println( "service : "+  p.getService().getService().toString());
        System.out.println( "grade : "+  p.getGrade().getGrade().toString().toString());
        }*/
        return "gendarme/list";
    }


    @RequestMapping(value = "/ajouter-gendarme", method = RequestMethod.GET)
    public String AddGendarmeView(Model model, HttpSession session) {
        //items in jsp
        if(!session.getAttribute("role").toString().contains("ROLE_ADMIN")){
            model.addAttribute("service", serviceRepository.findOne((Long) session.getAttribute("idService")));
            model.addAttribute("section", sectionRepository.findAll());
            model.addAttribute("badge", badgeRepository.findAll());
            model.addAttribute("grade", gradeRepository.findAll());
            return "gendarme/add";
        } else {
            model.addAttribute("service", serviceRepository.findAll());
            model.addAttribute("section", sectionRepository.findAll());
            model.addAttribute("badge", badgeRepository.findAll());
            model.addAttribute("grade", gradeRepository.findAll());

        }
        return "gendarme/add";
    }

    @RequestMapping(value = "/ajouter-gendarme", method = RequestMethod.POST)
    public String addGendarme(@RequestParam String nom,
                              @RequestParam String prenom,
                              @RequestParam String cin,
                              @RequestParam Integer mle,
                              @RequestParam String datenaiss,
                              @RequestParam long idgrade,
                              @RequestParam long idservice,
                              @RequestParam long idbadge,
                              @RequestParam long idsection,
                              @RequestParam String address) {
        Date birthday = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            birthday = dateFormat.parse(datenaiss);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Badge badge =  badgeRepository.findOne(idbadge);
        Grade grade =  gradeRepository.findOne(idgrade);
        Service service = serviceRepository.findOne(idservice);
        Section section = sectionRepository.findOne(idsection);
        ProfilInfo profileInfo = new ProfilInfo(nom,prenom,birthday,mle,cin,address,service,section,grade,badge);
        profileInfoRepository.save(profileInfo);//TODO date
        return "redirect:detaile-gendarme.html?id="+profileInfo.getId();
    }





    @RequestMapping(value = "/modifier-gendarme", method = RequestMethod.POST)
    public String updateGendarme(@RequestParam Long id,
                                 @RequestParam String nom,
                              @RequestParam String prenom,
                              @RequestParam String cin,
                              @RequestParam Integer mle,
                              @RequestParam String datenaiss,
                              @RequestParam long idgrade,
                                 // @RequestParam long idservice,
                              @RequestParam long idbadge,
                              @RequestParam long idsection,
                              @RequestParam String address) {



        ProfilInfo profileInfo = profileInfoRepository.findOne(id);
       /* if(idservice > 0){
          Service service = serviceRepository.findOne(idservice);
            profileInfo.setService(service);
        }*/

        Badge badge =  badgeRepository.findOne(idbadge);
        Grade grade =  gradeRepository.findOne(idgrade);



        Section section = sectionRepository.findOne(idsection);
        Date birthday = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            birthday = dateFormat.parse(datenaiss);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        profileInfo.setFirstname(nom);
        profileInfo.setLastname(prenom);
        profileInfo.setCin(cin);
        profileInfo.setMatricule(mle);
        profileInfo.setBirthday(birthday);
        profileInfo.setGrade(grade);
        profileInfo.setSection(section);

        profileInfo.setAddress(address);
        profileInfo.setBadge(badge);
        profileInfoRepository.save(profileInfo);//TODO date
        return "redirect:detaile-gendarme.html?id="+profileInfo.getId();
    }



    //delete testrestauration

    @RequestMapping(value = "/delet-gendarme", method = RequestMethod.GET)
    public String deleteGendarme(@RequestParam long id) {
        profileInfoRepository.delete(id);
        return "redirect:gendarmes.html";
    }


}
