package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class EquipmentMaintenanceModel {
	
	private ShipInfo shipInfo;                                 // 基本情報(船情報)
	
	private EquipmentInfo equipmentInfo;                       // 装備情報
	
	private List<ItemInfo> itemInfoList;                       // 品目情報
	
	private List<ProgramInfo> programInfoList;                 // プログラム情報
	
	private List<ConsumablePartsInfo> consumablePartsInfoList; // 消耗部品情報
}
