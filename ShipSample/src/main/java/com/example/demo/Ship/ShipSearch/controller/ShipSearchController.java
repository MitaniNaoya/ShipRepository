package com.example.demo.Ship.ShipSearch.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.Ship.ShipSearch.service.ShipSearchService;
import com.example.demo.model.ShipSearchModel;


@Controller
@SessionAttributes(types=ShipSearchForm.class)
@RequestMapping("/Ship/ShipSearch")
public class ShipSearchController {
	@Autowired
	private ShipSearchService shipSearchService;
	
	@Autowired
	private ModelMapper modelmapper;
	
    @PostMapping("/index")
    private String doPost(ShipSearchForm shipSearchForm, Model model) {
    	shipSearchForm.preparreDBSearchData();
    	List<ShipSearchModel> shipList = shipSearchService.getShipSearch(shipSearchForm);
    	
    	shipSearchForm = modelmapper.map(shipList, ShipSearchForm.class);
    	model.addAttribute("shipList", shipList);
        return "/Ship/ShipSearch/main";
    }
    
    @GetMapping("/index")
    private String doGet(@ModelAttribute("shipSearchForm") ShipSearchForm searchForm,Model model) {
        return "/Ship/ShipSearch/main";
    }
}
