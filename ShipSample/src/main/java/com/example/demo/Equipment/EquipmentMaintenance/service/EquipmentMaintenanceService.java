package com.example.demo.Equipment.EquipmentMaintenance.service;

import java.util.List;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.entity.ConsumablePartsInfo;
import com.example.demo.entity.EquipmentInfo;
import com.example.demo.entity.ItemInfo;
import com.example.demo.entity.ProgramInfo;
import com.example.demo.entity.ShipInfo;


public interface EquipmentMaintenanceService {
	//public List<EquipmentMaintenanceModel> getUpdatedEquipmentMaintenance(int equipmentid);
	public ShipInfo getShipInfoByEquipmentId(int equipmentid);
	public ShipInfo getShipInfoByFShipNo(String fshipno);
	
	public EquipmentInfo getEquipmentInfo(int equipmentid);
	public List<ItemInfo> getItemInfoList(int equipmentid);
	public List<ProgramInfo> getProgramInfoList(int equipmentid);
	public List<ConsumablePartsInfo> getConsumablePartsInfoList(int equipmentid);
	public List<String> getModelStrList();
	public List<String> getItemStrList();
	
	public int getNewestEquipmentID();
	public int insertEquipmentInfo(EquipmentInfo equipmentInfo);
	public int updateEquipmentInfo(EquipmentInfo equipmentInfo);
	
	public int insertBulkItemInfoList(List<ItemInfo> itemInfoList);
	public int getNewestItemRowNo();
	public int updateBulkItemInfoList(List<ItemInfo> itemInfoList);
	
	public int getNewestProgramRowNo();
	public int insertBulkProgramInfoList(List<ProgramInfo> programInfoList);
	public int updateBulkProgramInfoList(List<ProgramInfo> programInfoList);
	
	public int getNewestConsumablePartsRowNo();
	public int insertBulkConsumablePartsInfoList(List<ConsumablePartsInfo> consumablePartsInfoList);
	public int updateBulkConsumablePartsInfoList(List<ConsumablePartsInfo> consumablePartsInfoList);
	
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm);
	//public int deleteEquipmentMaintenance(String equipmentid);
	//public int deleteEquipmentMaintenance(String equipmentid);
	public int updateDeleteEquipmentInfo(int equipmentid);
	public int updateDeleteItemInfo(int equipmentid);
	public int deleteProgramInfo(int equipmentid);
	public int deleteConsumablePartsInfo(int equipmentid);
	//public EquipmentMaintenanceModel getEquipmentMaintenanceModel(int equipmentid);
	
}
