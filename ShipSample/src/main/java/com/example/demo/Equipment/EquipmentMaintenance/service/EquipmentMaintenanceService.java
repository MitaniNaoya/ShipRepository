package com.example.demo.Equipment.EquipmentMaintenance.service;

import java.util.List;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.model.ConsumablePartsInfo;
import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.EquipmentMaintenanceModel;
import com.example.demo.model.ItemInfo;
import com.example.demo.model.ProgramInfo;
import com.example.demo.model.ShipInfo;


public interface EquipmentMaintenanceService {
	//public List<EquipmentMaintenanceModel> getUpdatedEquipmentMaintenance(int equipmentid);
	public ShipInfo getShipInfoByEquipmentId(int equipmentid);
	public ShipInfo getShipInfoByFShipNo(String fshipno);
	
	public EquipmentInfo getEquipmentInfo(int equipmentid);
	public List<ItemInfo> getItemInfoList(int equipmentid);
	public List<ProgramInfo> getProgramInfoList(int equipmentid);
	public List<ConsumablePartsInfo> getConsumablePartsInfoList(int equipmentid);
	public int getNewestEquipmentID();
	public int insertEquipmentInfo(EquipmentInfo equipmentInfo);
	public int insertBulkItemInfoList(List<ItemInfo> itemInfoList);
	public int insertBulkProgramInfoList(List<ProgramInfo> programInfoList);
	public int insertBulkConsumablePartsInfoList(List<ConsumablePartsInfo> consumablePartsInfoList);
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm);
	public int deleteEquipmentMaintenance(String equipmentid);
	public EquipmentMaintenanceModel getEquipmentMaintenanceModel(int equipmentid);
	
}
