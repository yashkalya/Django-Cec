package com.example.demo.controller;

import com.example.demo.model.MobileModel;
import com.example.demo.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MobileController {
    @Autowired
    private MobileRepository mobileRepository;

    @GetMapping("/mobiles/add")
    public String addMobileForm() {
        return "addMobiles"; 
    }

    @PostMapping("/mobiles/add")
    public String addMobile(@ModelAttribute MobileModel mobile) {
        mobileRepository.save(mobile);
        return "redirect:/mobiles/display"; 
    }

    @GetMapping("/mobiles/display")
    public String displayMobiles(Model model) {
        List<MobileModel> mobiles = mobileRepository.findAll();
        model.addAttribute("mobiles", mobiles);
        return "displayMobiles"; 
    }

    @GetMapping("/mobiles/edit/{id}")
    public String editMobileForm(@PathVariable Long id, Model model) {
        MobileModel mobile = mobileRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid mobile Id:" + id));
        model.addAttribute("mobile", mobile);
        return "editMobiles"; 
    }

    @PostMapping("/mobiles/edit")
    public String editMobile(@ModelAttribute MobileModel mobile) {
        mobileRepository.save(mobile);
        return "redirect:/mobiles/display"; 
    }

    @GetMapping("/mobiles/delete/{id}")
    public String deleteMobile(@PathVariable Long id) {
        mobileRepository.deleteById(id);
        return "redirect:/mobiles/display"; 
    }
}