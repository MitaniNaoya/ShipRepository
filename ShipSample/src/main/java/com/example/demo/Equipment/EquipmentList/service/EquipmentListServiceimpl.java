package com.example.demo.Equipment.EquipmentList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Equipment.EquipmentList.mapper.EquipmentListMapper;
import com.example.demo.model.EquipmentListModel;

@Service
public class EquipmentListServiceimpl implements EquipmentListService {
	@Autowired
	private EquipmentListMapper equipmentListMapper;
	
	@Override
	public List<EquipmentListModel> getEquipmentList(String fshipno) {
		return equipmentListMapper.getEquipmentList(fshipno);
	}
}
