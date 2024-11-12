package com.example.demo.Equipment.EquipmentList.service;

import java.util.List;

import com.example.demo.model.EquipmentListModel;

public interface EquipmentListService {
	public List<EquipmentListModel> getEquipmentList(String fshipno);
}
