package com.example.demo.Equipment.EquipmentList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private String doPost(@PathVariable String fshipno, Model model) {
    	List<EquipmentListModel> equipmentList = equipmentListService.getEquipmentList(fshipno);
    	model.addAttribute("equipmentList", equipmentList);
        return "/Equipment/EquipmentList/main";
    }
}
