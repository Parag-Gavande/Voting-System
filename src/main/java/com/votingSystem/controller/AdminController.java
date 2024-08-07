package com.votingSystem.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.votingSystem.entity.Admin;
import com.votingSystem.entity.AdminLogin;
import com.votingSystem.service.AdminService;
import com.votingSystem.service.VoterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private VoterService voterService;
    

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; 
    }

    @GetMapping("/saveAdmin")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminregister";
    }

    @PostMapping("/goadminregister")
    public String registerAdmin(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminregister";
        }
        adminService.saveAdmin(admin);
        return "redirect:/adminlogin"; 
    }

    @GetMapping("/adminlogin")
    public String showLoginForm(Model model) {
        model.addAttribute("adminlogin", new AdminLogin());
        return "adminlogin";
    }

    @PostMapping("/validateAdminLogin")
    public String validateAdminLogin(@ModelAttribute AdminLogin adminLogin, Model model) {
        Admin admin = adminService.findByUsernameAndPassword(adminLogin.getUsername(), adminLogin.getPassword());
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "redirect:/adminDashboard"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
        }
    }
 
    @GetMapping("/admin/deleteVoter/{id}")
    public String deleteAdminVoter(@PathVariable("id") String voterId) {
        adminService.deleteById(voterId);
        return "redirect:/adminDashboard"; 
    }

    
      
    
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/adminlogin"); 
    }
    
    

}
