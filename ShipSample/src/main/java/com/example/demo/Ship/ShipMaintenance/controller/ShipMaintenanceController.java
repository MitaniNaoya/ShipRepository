package com.example.demo.Ship.ShipMaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Ship.ShipMaintenance.form.ShipMaintenanceForm;
import com.example.demo.Ship.ShipMaintenance.service.ShipMaintenanceService;
import com.example.demo.model.ShipMaintenanceModel;

@Controller
@RequestMapping("/Ship/ShipMaintenance")
public class ShipMaintenanceController {
	@Autowired
	private ShipMaintenanceService shipMaintenanceService;
	
    @PostMapping("/insert/{fshipno}")    
    // 保存処理(新規/更新)
    private String insertPost(@RequestParam ShipMaintenanceForm maintenanceForm, Model model) {
    	shipMaintenanceService.insertShipMaintenance(maintenanceForm);
    	//model.addAttribute("shipMaintenance", shipMaintenance);
        return "/Ship/ShipSearch/main";
    }
    
    @PostMapping("/delete/{fshipno}")
    // 船検索画面へ遷移(新規/更新)
    private String deletePost(@PathVariable String fshipno, Model model) {
    	
        return "/Ship/ShipSearch/main";
    }    
    
    @GetMapping("/index")
    // 初期表示(新規登録)
    private String insertGet(Model model) {
        return "/Ship/ShipMaintenance/update";
    }
    
    @GetMapping("/index/{fshipno}")
    // 初期表示(追加更新)
    private String updateGet(@PathVariable String fshipno, Model model) {
    	List<ShipMaintenanceModel> shipMaintenance = shipMaintenanceService.getShipMaintenance(fshipno);
    	model.addAttribute("shipMaintenance", shipMaintenance);
        return "/Ship/ShipMaintenance/update";
    }
}