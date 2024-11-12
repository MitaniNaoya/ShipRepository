package com.example.demo.Ship.ShipSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.Ship.ShipSearch.service.ShipSearchService;
import com.example.demo.model.ShipSearchModel;


@Controller
@RequestMapping("/Ship/ShipSearch")
public class ShipSearchController {
	@Autowired
	private ShipSearchService shipSearchService;
	
    @PostMapping("/index")
    private String doPost(@RequestParam ShipSearchForm searchForm, Model model) {
    	List<ShipSearchModel> shipSearch = shipSearchService.getShipSearch(searchForm);
    	model.addAttribute("shipSearch", shipSearch);
        return "/Ship/ShipMaintenance/insert";
    }
    
    @GetMapping("/index")
    private String doGet(@ModelAttribute("shipSearchForm") ShipSearchForm searchForm,Model model) {
        return "/Ship/ShipSearch/main";
    }
}
