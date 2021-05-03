package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
    	String[] dentists = { "Kalle Kalmistu", "Alari Igemik" };
    	String[] times = { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
    			"16:00", "16:30" };
    	model.addAttribute("times", times);
    	model.addAttribute("dentists", dentists);
    	model.addAttribute("newVisit", new DentistVisitEntity());
    	
        return "form";
    }
    
    @GetMapping(value = "/visitTimes/{date}")
    public @ResponseBody List<DentistVisitEntity> getVisitTimesByDay(@PathVariable("date") String date) {
    	return dentistVisitService.getAllTimesByDate(date);
    }

    @PostMapping("/")
    public String postRegisterForm(@ModelAttribute DentistVisitEntity dentistVisitEntity, Model model) {

        dentistVisitService.addVisit(dentistVisitEntity);
        
        return "results";
    }
    
    @GetMapping("/view")
    public String showView(Model model) {
    	List<DentistVisitEntity> visits = dentistVisitService.getList();
    	
    	model.addAttribute("visits", visits);
    	return "view";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteVisit(@PathVariable("id") Long id) {
    	dentistVisitService.deleteVisit(id);
    	return "redirect:/view";
    }
    

    

    
}
