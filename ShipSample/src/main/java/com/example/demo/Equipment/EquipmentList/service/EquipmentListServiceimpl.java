package com.example.demo.Equipment.EquipmentList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Equipment.EquipmentList.mapper.EquipmentListMapper;
import com.example.demo.entity.EquipmentInfo;
import com.example.demo.entity.ShipInfo;

@Service
public class EquipmentListServiceimpl implements EquipmentListService {
	@Autowired
	private EquipmentListMapper equipmentListMapper;
	
	@Override
	public List<EquipmentInfo> getEquipmentList(String fshipno) {
		return equipmentListMapper.getEquipmentList(fshipno);
	}
	
	@Override
	public ShipInfo getShipInfo(String fshipno) {
		return equipmentListMapper.getShipInfo(fshipno);
	}
}
