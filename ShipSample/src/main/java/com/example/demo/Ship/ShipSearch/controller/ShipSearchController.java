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
@RequestMapping("/Ship/ShipSearch")
@SessionAttributes("shipSearchForm")
public class ShipSearchController {
	@Autowired
	private ShipSearchService shipSearchService;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@ModelAttribute("shipSearchForm")
	public ShipSearchForm setUpShipSearchForm(){
	 return new ShipSearchForm();
	}
	
    @PostMapping("/index")
    private String doPost(ShipSearchForm shipSearchForm, Model model) {
    	ShipSearchForm form = model.getAttribute("shipSearchForm") != null
    			? (ShipSearchForm)  model.getAttribute("shipSearchForm")
    			: shipSearchForm;
    	 
    	shipSearchForm.preparreDBSearchData();
    	List<ShipSearchModel> shipList = shipSearchService.getShipSearch(shipSearchForm);
    	
    	shipSearchForm = modelmapper.map(shipList, ShipSearchForm.class);
    	model.addAttribute("shipList", shipList);
    	model.addAttribute("shipSearchForm", form);
        return "/Ship/ShipSearch/main";
    }
    
    @GetMapping("/index")
    private String doGet(@ModelAttribute("shipSearchForm") ShipSearchForm searchForm,Model model) {
    	model.addAttribute("shipSearchForm", new ShipSearchForm());
        return "/Ship/ShipSearch/main";
    }
    
    @GetMapping("/redirect")
    private String doRedirect(ShipSearchForm shipSearchForm,Model model) {
    	ShipSearchForm form = model.getAttribute("shipSearchForm") != null
    			? (ShipSearchForm)  model.getAttribute("shipSearchForm")
    			: shipSearchForm;
    	 
    	shipSearchForm.preparreDBSearchData();
    	List<ShipSearchModel> shipList = shipSearchService.getShipSearch(shipSearchForm);
    	
    	shipSearchForm = modelmapper.map(shipList, ShipSearchForm.class);
    	model.addAttribute("shipList", shipList);
    	model.addAttribute("shipSearchForm", form);
        return "/Ship/ShipSearch/main";
    }
}
