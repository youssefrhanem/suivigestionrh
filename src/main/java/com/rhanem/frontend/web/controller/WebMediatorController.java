package com.rhanem.frontend.web.controller;

import javax.servlet.http.HttpSession;

import com.rhanem.backend.persistence.model.Section;
import com.rhanem.backend.persistence.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rhanem.backend.persistence.model.User;
import com.rhanem.backend.repository.UserRepository;

@Controller
public final class WebMediatorController {

	public WebMediatorController() {
		super();
	}

	@Autowired
	private UserRepository userRepository;

	// API
	@RequestMapping(value = "/login")
	public String home() {
		return "login";
	}
	
	@RequestMapping(value = "/404")
	public String error404() {
		return "404";
	}
	
	@RequestMapping(value = "/403")
	public String error403() {
		return "403";
	}
	
	@RequestMapping(value = "/500")
	public String error505() {
		return "505";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(HttpSession session) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		if (!name.equals("")) {
			User user = userRepository.findBynameLike(name);
			String nom = user.getNom();
			String prenom = user.getPrenom();
			Long principal_id = user.getId();
			Service sservice = user.getService();
			Section ssection = user.getSection();

			session.setAttribute("role", user.getAuthorities());

			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("name", name);
			session.setAttribute("principal_id", principal_id);
			session.setAttribute("idService",sservice.getId());
			session.setAttribute("idSection",ssection.getId());
			// out put session
			System.out.println("nom=======\n" + session.getAttribute("nom"));
			System.out.println("=============\n"
					+ session.getAttribute("prenom"));
			System.out
					.println("Name======\n" + session.getAttribute("name"));
			System.out.println("=============\n"
					+ session.getAttribute("principal_id"));
			System.out
					.println("role=======\n" + session.getAttribute("role"));
			System.out
					.println("Service========\n" + session.getAttribute("idService"));
            System.out
                    .println("Section======\n" + session.getAttribute("idSection"));
			return "dashboard";
		} else {
			return "login";
		}
	}
}
