package com.example.demo.Equipment.EquipmentList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Equipment.EquipmentList.service.EquipmentListService;
import com.example.demo.model.EquipmentListModel;

@Controller
@RequestMapping("/Equipment/EquipmentList")
public class EquipmentListController {
	@Autowired
	private EquipmentListService equipmentListService;
	
    @PostMapping("/index/{fShipno}")    
    // 初期表示処理
    private String doPost(@PathVariable String fShipno, Model model) {
    	
    	EquipmentListModel equipmentListModel = new EquipmentListModel();
    	// 船情報取得
    	equipmentListModel.setShipInfo(equipmentListService.getShipInfo(fShipno));
    	// 機種情報取得
    	equipmentListModel.setEquipmentInfoList(equipmentListService.getEquipmentList(fShipno));
    	model.addAttribute("shipInfo", equipmentListModel.getShipInfo());
    	model.addAttribute("equipmentInfoList", equipmentListModel.getEquipmentInfoList());

        return "/Equipment/EquipmentList/main";
    }
    
    @GetMapping("/index/{fShipno}")
    // 初期表示処理
    private String doGet(@PathVariable String fShipno, Model model) {
    	EquipmentListModel equipmentListModel = new EquipmentListModel();
    	// 船情報取得
    	equipmentListModel.setShipInfo(equipmentListService.getShipInfo(fShipno));
    	// 機種情報取得
    	equipmentListModel.setEquipmentInfoList(equipmentListService.getEquipmentList(fShipno));
    	model.addAttribute("shipInfo", equipmentListModel.getShipInfo());
    	model.addAttribute("equipmentInfoList", equipmentListModel.getEquipmentInfoList());
    	return "/Equipment/EquipmentList/main";
    }
}
