package com.example.demo.Equipment.EquipmentMaintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.Equipment.EquipmentMaintenance.service.EquipmentMaintenanceService;
import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.model.EquipmentMaintenanceModel;
import com.example.demo.model.ShipInfo;

@Controller
@RequestMapping("/Equipment/EquipmentMaintenance")
public class EquipmentMaintenanceController {
	@Autowired
	private EquipmentMaintenanceService equipmentMaintenanceService;
	
    @GetMapping("/index/{equipmentid}")    
    // 初期表示処理(更新)
    private String updatePost(@PathVariable int equipmentid,  Model model) {
    	/*
    	ShipInfo shipInfo =  equipmentMaintenanceService.getShipInfoByEquipmentId(equipmentid);
    	model.addAttribute("shipInfo", shipInfo);
    	EquipmentInfo equipmentInfo =  equipmentMaintenanceService.getEquipmentInfo(equipmentid);
    	model.addAttribute("equipmentInfo", equipmentInfo);
    	List<ItemInfo> itemInfoList =  equipmentMaintenanceService.getItemInfoList(equipmentid);
    	model.addAttribute("itemInfoList", itemInfoList);
    	List<ProgramInfo> programInfoList =  equipmentMaintenanceService.getProgramInfoList(equipmentid);
    	model.addAttribute("programInfoList", programInfoList);
    	List<ConsumablePartsInfo> consumablePartsInfoList =  equipmentMaintenanceService.getConsumablePartsInfoList(equipmentid);
    	model.addAttribute("consumablepartsInfoList", consumablePartsInfoList);
        return "/Equipment/EquipmentMaintenance/update";
        */
    	EquipmentMaintenanceModel equipmentMaintenance =  equipmentMaintenanceService.getEquipmentMaintenanceModel(equipmentid);
    	model.addAttribute("shipInfo", equipmentMaintenance.getShipInfo());
    	model.addAttribute("equipmentInfo", equipmentMaintenance.getEquipmentInfo());
    	model.addAttribute("itemInfoList", equipmentMaintenance.getItemInfoList());
    	model.addAttribute("programInfoList", equipmentMaintenance.getProgramInfoList());
    	model.addAttribute("consumablepartsInfoList", equipmentMaintenance.getConsumablePartsInfoList());
        return "/Equipment/EquipmentMaintenance/update";
    }
    
    @GetMapping("/insert/{fshipno}")    
    // 初期表示処理(新規)
    private String insertPost(@PathVariable String fshipno, Model model) {
    	ShipInfo shipInfo =  equipmentMaintenanceService.getShipInfoByFShipNo(fshipno);
    	model.addAttribute("shipInfo", shipInfo);
    	return "/Equipment/EquipmentMaintenance/insert";
    }
    
    @PostMapping("/save/{fshipno}")    
    // 登録処理（新規）
    private String savePost(EquipmentMaintenanceForm equipmentMaintenanceForm, @PathVariable String fshipno, Model model) {
    	
    	//equipmentMaintenanceService.saveEquipmentMaintenance(equipmentMaintenanceForm);
    	//model.addAttribute("shipMaintenance", shipMaintenance);
    	int newEquipmentID = equipmentMaintenanceService.getNewestEquipmentID() + 1;
    	equipmentMaintenanceForm.prepareDBDatas(newEquipmentID);
    	if (equipmentMaintenanceForm.getEquipmentInfo() != null) {
    		equipmentMaintenanceService.insertEquipmentInfo(equipmentMaintenanceForm.getEquipmentInfo());
    	}
    	if (equipmentMaintenanceForm.getItemInfoList().size() > 0) {
    		equipmentMaintenanceService.insertBulkItemInfoList(equipmentMaintenanceForm.getItemInfoList());
    	}
    	if (equipmentMaintenanceForm.getProgramInfoList().size() > 0) {
    		equipmentMaintenanceService.insertBulkProgramInfoList(equipmentMaintenanceForm.getProgramInfoList());
    	}
    	if (equipmentMaintenanceForm.getConsumablePartsInfoList().size() > 0) {
    		equipmentMaintenanceService.insertBulkConsumablePartsInfoList(equipmentMaintenanceForm.getConsumablePartsInfoList());
    	}

    	ShipSearchForm form = model.getAttribute("shipSearchForm") != null
    			? (ShipSearchForm)  model.getAttribute("shipSearchForm")
    			: new ShipSearchForm();
    	model.addAttribute("shipSearchForm", form);
    	
        return "redirect:/Ship/ShipSearch/redirect";
    }
}