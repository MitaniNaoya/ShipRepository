package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class EquipmentListModel {
	// 船情報
	private ShipInfo shipInfo;
	
	// 機種情報
	private List<EquipmentInfo> equipmentInfoList;
}
