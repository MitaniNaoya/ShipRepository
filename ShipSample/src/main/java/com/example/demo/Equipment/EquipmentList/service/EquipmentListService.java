package com.example.demo.Equipment.EquipmentList.service;

import java.util.List;

import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.EquipmentListModel;
import com.example.demo.model.ShipInfo;

public interface EquipmentListService {
	public List<EquipmentInfo> getEquipmentList(String fshipno);
	public ShipInfo getShipInfo(String fshipno);
	public EquipmentListModel getEquipmentListModel(String fshipno);
}
