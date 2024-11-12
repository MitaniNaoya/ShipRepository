package com.example.demo.Equipment.EquipmentMaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.Equipment.EquipmentMaintenance.service.EquipmentMaintenanceService;
import com.example.demo.model.EquipmentMaintenanceModel;

@Controller
@RequestMapping("/Equipment/EquipmentMaintenance")
public class EquipmentMaintenanceController {
	@Autowired
	private EquipmentMaintenanceService equipmentMaintenanceService;
	
    @GetMapping("/index/{equipmentid}")    
    // 初期表示処理(更新)
    private String doPost(@PathVariable String equipmentid,  Model model) {
    	List<EquipmentMaintenanceModel> equipmentMaintenance =  equipmentMaintenanceService.getUpdatedEquipmentMaintenance(equipmentid);
    	model.addAttribute("equipmentMaintenance", equipmentMaintenance);
        return "/Equipment/EquipmentMaintenance/update";
    }
    
    @GetMapping("/insert/{fshipno}")    
    // 保存処理(新規)
    private String insertPost(@PathVariable String fshipno, Model model) {
    	equipmentMaintenanceService.getInsertedEquipmentMaintenance(fshipno);
    	List<EquipmentMaintenanceModel> equipmentMaintenance =  equipmentMaintenanceService.getInsertedEquipmentMaintenance(fshipno);
    	model.addAttribute("equipmentMaintenance", equipmentMaintenance);
        return "/Ship/ShipSearch/main";
    }
    
    @PostMapping("/save/{fshipno}")    
    // 登録処理（新規）
    private String savePost(@RequestParam EquipmentMaintenanceForm equipmentMaintenanceForm, @PathVariable String fshipno, Model model) {
    	equipmentMaintenanceService.saveEquipmentMaintenance(equipmentMaintenanceForm);
    	//model.addAttribute("shipMaintenance", shipMaintenance);
        return "/Ship/ShipSearch/main";
    }
    
    @PostMapping("/commit")    
    // 登録処理(更新)
    private String commitPost(@RequestParam EquipmentMaintenanceForm equipmentMaintenanceForm, Model model) {
    	equipmentMaintenanceService.commitEquipmentMaintenance(equipmentMaintenanceForm);
    	//model.addAttribute("shipMaintenance", shipMaintenance);
        return "/Ship/ShipSearch/main";
    }
    
    @PostMapping("/delete/{equipmentid}")    
    // 削除処理
    private String deletePost(@PathVariable String equipmentid, Model model) {
    	equipmentMaintenanceService.deleteEquipmentMaintenance(equipmentid);
    	//model.addAttribute("shipMaintenance", shipMaintenance);
        return "/Ship/ShipSearch/main";
    }
}