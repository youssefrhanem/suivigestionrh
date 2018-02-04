package com.rhanem.frontend.web.controller;


import com.rhanem.backend.persistence.model.Badge;
import com.rhanem.backend.persistence.model.ProfilInfo;
import com.rhanem.backend.persistence.model.TypeBadge;
import com.rhanem.backend.persistence.model.User;
import com.rhanem.backend.repository.BadgeRepository;
import com.rhanem.backend.repository.ProfileInfoRepository;
import com.rhanem.backend.repository.TypeBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.java2d.cmm.Profile;

@Controller
public class BadgeController {


    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    TypeBadgeRepository typeBadgeRepository;

    @Autowired
    ProfileInfoRepository profileInfoRepository;



    //TODO View Badge_type
    @RequestMapping(value = "/badge", params = "ListTypeBadge", method = RequestMethod.GET)
    public String viewListTypeBadges(Model model) {
        model.addAttribute("listTypeBadge", typeBadgeRepository.findAll());
        return "badge";
    }


    //TODO Add Badge_type
    @RequestMapping(value = "/badge", params = "AddTypeBadge", method = RequestMethod.POST)
    public String addTypeBadge(@RequestParam String typeBadge) {
        if (!typeBadge.isEmpty()) {
            TypeBadge tBadge = new TypeBadge(typeBadge);
            typeBadgeRepository.save((tBadge));
            return "badge";
        } else {
            return "badge";//TODO redirection   + MSG
        }
    }

    //TODO Delete Badge_type
    @RequestMapping(value = "/badge", params = "DeleteTypeBadge", method = RequestMethod.POST)
    public String deleteypeBadge(@RequestParam Long id) {
        if (id != null) {
            typeBadgeRepository.delete(id);
            return "badge";//TODO GOOD
        } else {
            return "badge";//TODO redirection + MSG
        }
    }

    //TODO Edit Badge_type
    @RequestMapping(value = "/badge", params = "EditTypeBadge", method = RequestMethod.POST)
    public String EditeypeBadge(@RequestParam Long id, @RequestParam String typeBadge) {
        if (id != null) {
            if (!typeBadge.isEmpty()) {
                TypeBadge tpBadge = typeBadgeRepository.findOne(id);
                tpBadge.setType(typeBadge);
                return "badge";//TODO redirection All Good + MSG
            }
            return "badge";//TODO redirection id null + MSG
        } else {
            return "badge";//TODO redirection id and type is null + MSG
        }
    }




    //================================================================================================
    //================================================================================================
    //================================================================================================
    //================================================================================================


    //TODO view affectation badge
    @RequestMapping(value = "/affectation", method = RequestMethod.GET)
    public String affectationBadge(Model model,
                                   @RequestParam Long id,
                                   @RequestParam Long pid){

        model.addAttribute("badge", badgeRepository.findAll());
        model.addAttribute("profile", profileInfoRepository.findAll());

        Badge badge = badgeRepository.findOne(id);
        ProfilInfo profilInfo = profileInfoRepository.findOne(pid);
        profilInfo.setBadge(badge);
        profileInfoRepository.save(profilInfo);
        return "redirect:list-badge.html";
    }


    //TODO View Badge
    @RequestMapping(value = "/list-badge", method = RequestMethod.GET)
    public String viewListBadges(Model model) {
        model.addAttribute("badge", badgeRepository.findAll());
        model.addAttribute("profile", profileInfoRepository.findAll());
        return "redirect:list-badge.html";
    }

    @RequestMapping(value = "delete-badge", method = RequestMethod.GET)
    public String deleteBadge(@RequestParam Long id,
                              @RequestParam Long pid){
        ProfilInfo profilInfo = profileInfoRepository.findOne(pid);
        profilInfo.setBadge(null);
        profileInfoRepository.save(profilInfo);
        badgeRepository.delete(id);
        return "list-badge.html";
    }


    //TODO Add Badge
    @RequestMapping(value = "/ajouter-badge", method = RequestMethod.POST)
    public String addBadge(@RequestParam Long typebadge,
                           @RequestParam Integer Numero,
                           @RequestParam Integer nrserie,
                           @RequestParam("etat") String etatBadge) {
        Boolean activation;
        if (etatBadge.equals("on")) {
            activation = true;
        } else {
            activation = false;
        }
        System.out.println("typebadge " + typebadge);
        System.out.println("Numero " + Numero);
        System.out.println("etat " + etatBadge);
        System.out.println("Activation " + nrserie);
        TypeBadge typeBadge = typeBadgeRepository.findOne(typebadge);
        Badge badge = new Badge(typeBadge, nrserie, activation);
        badgeRepository.save(badge);

        return "redirect:ajouter-badge.html";
    }


    //done view list add badge
    @RequestMapping(value = "/ajouter-badge", method = RequestMethod.GET)
    public String addBadge(Model model) {
        model.addAttribute("badge", badgeRepository.findAll());
        model.addAttribute("typeBadge", typeBadgeRepository.findAll());
        return "badge/add";
    }


    //TODO Delete Badge
    //TODO Edit Badge


}
