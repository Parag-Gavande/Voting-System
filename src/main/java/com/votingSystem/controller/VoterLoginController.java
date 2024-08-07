package com.votingSystem.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.votingSystem.entity.Voter;
import com.votingSystem.entity.VoterLogin;
import com.votingSystem.service.ElectionService;
import com.votingSystem.service.VoterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class VoterLoginController {

    @Autowired
    private VoterService voterService;
    
    @Autowired
    private ElectionService electionService;

    @GetMapping("/voterLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("voterLogin", new VoterLogin());
        return "voterLogin";
    }

    @PostMapping("/voterLogin")
    public String validateVoterLogin(@ModelAttribute VoterLogin voterLogin, Model model, HttpServletRequest request) {
        Voter voter = voterService.findByUsernameAndPassword(voterLogin.getUsername(), voterLogin.getPassword());
        if (voter != null) {
            request.getSession().setAttribute("voter", voter); 
            return "redirect:/voterDashboard"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "voterLogin";
        }
    }
    
    @GetMapping("/voterDashboard")
    public String showVoterDashboard(HttpServletRequest request, Model model) {
        Voter voter = (Voter) request.getSession().getAttribute("voter");
        if (voter != null) {
            model.addAttribute("voter", voter);
            model.addAttribute("elections", electionService.getAllElections()); 
        }
        return "voterDashboard"; 
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate(); 
        response.sendRedirect("/voterLogin"); 
    }
}
