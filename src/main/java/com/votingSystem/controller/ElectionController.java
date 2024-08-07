package com.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.votingSystem.entity.Election;
import com.votingSystem.service.ElectionService;

@Controller
public class ElectionController {
    @Autowired
    private ElectionService electionService;

    @GetMapping("/admin/addElection")
    public String showAddElectionForm(Model model) {
        model.addAttribute("election", new Election());
        return "addElection";
    }

    @PostMapping("/admin/addElection")
    public String addElection(@ModelAttribute Election election) {
        electionService.saveElection(election);
        return "redirect:/adminDashboard";
    }
    

    @GetMapping("/electionDashboard")
    public String showElectionDashboard(Model model) {
        model.addAttribute("elections", electionService.getAllElections());
        return "voterDashboard";
    }
}
