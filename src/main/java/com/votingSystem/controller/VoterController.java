package com.votingSystem.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.votingSystem.entity.Voter;
import com.votingSystem.repository.VoterRepository;
import com.votingSystem.service.VoterService;

@Controller
public class VoterController {
    
    @Autowired
    private VoterService voterService;
    
    @Autowired
    private VoterRepository voterRepository;

    @GetMapping("/adminDashboard")
    public String showAdminDashboard(Model model) {
        model.addAttribute("voters", voterService.voterlist());
        return "adminDashboard";
    }

    //NEW11
    @GetMapping("/voters/edit/{id}")
    public String editVoter(@PathVariable("id") Long id, Model model) {
        Voter voter = voterService.findById(id);
        model.addAttribute("voter", voter);
        return "voterEdit";
    }

    
    //NEW11
    @PostMapping("/voters/update")
    public String updateVoter(@ModelAttribute Voter voter, RedirectAttributes redirectAttributes) {
        try {
            voterService.updateVoter(voter);
            redirectAttributes.addFlashAttribute("message", "Voter updated successfully.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/adminDashboard";
    }
    
    

    //NEW1
    @GetMapping("/voters/delete/{id}")
    public String deleteVoter(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            voterService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Voter deleted successfully.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/adminDashboard";
    }
    

    @GetMapping("/voters/add")
    public String addVoter(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterAdd";
    }

    @PostMapping("/voters/save")
    public String saveVoter(@ModelAttribute Voter voter) {
        voterService.saveVoter(voter);
        return "redirect:/adminDashboard";
    }
}
