package com.example.demo.Equipment.EquipmentList.service;

import java.util.List;

import com.example.demo.entity.EquipmentInfo;
import com.example.demo.entity.ShipInfo;

public interface EquipmentListService {
	public List<EquipmentInfo> getEquipmentList(String fshipno);
	public ShipInfo getShipInfo(String fshipno);
}
