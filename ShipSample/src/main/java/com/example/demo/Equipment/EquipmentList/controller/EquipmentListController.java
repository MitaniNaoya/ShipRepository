package com.example.demo.Equipment.EquipmentList.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Equipment.EquipmentList.service.EquipmentListService;
import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.ShipInfo;

@Controller
@RequestMapping("/Equipment/EquipmentList")
public class EquipmentListController {
	@Autowired
	private EquipmentListService equipmentListService;
	
	@Autowired
	private ModelMapper modelmapper;
	
    @PostMapping("/index/{fShipno}")    
    // 初期表示処理
    private String doPost(@PathVariable String fshipno, Model model) {
    	//List<EquipmentListModel> equipmentList = equipmentListService.getEquipmentList(fshipno);
    	//model.addAttribute("equipmentList", equipmentList);
        return "/Equipment/EquipmentList/main";
    }
    
    @GetMapping("/index/{fShipno}")
    // 初期表示処理
    private String doGet(@PathVariable String fShipno, Model model) {
    	// 船情報取得
    	ShipInfo shipInfo = equipmentListService.getShipInfo(fShipno);
    	model.addAttribute("shipInfo", shipInfo);
    	// 機種情報取得
    	List<EquipmentInfo> equipmentInfoList = equipmentListService.getEquipmentList(fShipno);
    	model.addAttribute("equipmentInfoList", equipmentInfoList);
        return "/Equipment/EquipmentList/main";
    }
}
