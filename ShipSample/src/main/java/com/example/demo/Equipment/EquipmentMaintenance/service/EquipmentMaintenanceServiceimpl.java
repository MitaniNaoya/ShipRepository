package com.example.demo.Equipment.EquipmentMaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.Equipment.EquipmentMaintenance.mapper.EquipmentMaintenanceMapper;
import com.example.demo.model.ConsumablePartsInfo;
import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.ItemInfo;
import com.example.demo.model.ProgramInfo;
import com.example.demo.model.ShipInfo;

@Service
public class EquipmentMaintenanceServiceimpl implements EquipmentMaintenanceService {
	@Autowired
	private EquipmentMaintenanceMapper equipmentMaintenanceMapper;
	
	@Override
	public ShipInfo getShipInfoByEquipmentId(int equipmentid) {
		return equipmentMaintenanceMapper.getShipInfoByEquipmentId(equipmentid);
	}
	
	@Override
	public ShipInfo getShipInfoByFShipNo(String fshipno) {
		return equipmentMaintenanceMapper.getShipInfoByFShipNo(fshipno);
	}
	
	@Override
	public EquipmentInfo getEquipmentInfo(int equipmentid) {
		return equipmentMaintenanceMapper.getEquipmentInfo(equipmentid);
	}

	@Override
	public List<ItemInfo> getItemInfoList(int equipmentid) {
		return equipmentMaintenanceMapper.getItemInfoList(equipmentid);
	}

	@Override
	public List<ProgramInfo> getProgramInfoList(int equipmentid) {
		return equipmentMaintenanceMapper.getProgramInfoList(equipmentid);
	}

	@Override
	public List<ConsumablePartsInfo> getConsumablePartsInfoList(int equipmentid) {
		return equipmentMaintenanceMapper.getConsumablePartsInfoList(equipmentid);
	}
	
	@Override
	public List<String> getModelStrList() {
		return equipmentMaintenanceMapper.getModelStrList();
	}
	
	@Override
	public List<String> getItemStrList() {
		return equipmentMaintenanceMapper.getItemStrList();
	}
	
//	@Override
//	public int saveEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm) {
//		return equipmentMaintenanceMapper.saveEquipmentMaintenance(equipmentMaintenanceForm);
//	}
	
	@Override
	public int getNewestEquipmentID() {
		return equipmentMaintenanceMapper.getNewestEquipmentID();
	}
	
	@Override
	public int insertEquipmentInfo(EquipmentInfo equipmentInfo) {
		return equipmentMaintenanceMapper.insertEquipmentInfo(equipmentInfo);
	}
	
	@Override
	public int updateEquipmentInfo(EquipmentInfo equipmentInfo) {
		return equipmentMaintenanceMapper.updateEquipmentInfo(equipmentInfo);
	}
	
	@Override
	public int getNewestItemRowNo() {
		return equipmentMaintenanceMapper.getNewestItemRowNo();
	}

	@Override
	public int insertBulkItemInfoList(List<ItemInfo> itemInfoList) {
		return equipmentMaintenanceMapper.insertBulkItemInfoList(itemInfoList);
	}
	
	@Override
	public int updateBulkItemInfoList(List<ItemInfo> itemInfoList) {
		return equipmentMaintenanceMapper.updateBulkItemInfoList(itemInfoList);
	}

	@Override
	public int getNewestProgramRowNo() {
		return equipmentMaintenanceMapper.getNewestProgramRowNo();
	}
	
	@Override
	public int insertBulkProgramInfoList(List<ProgramInfo> programInfoList) {
		return equipmentMaintenanceMapper.insertBulkProgramInfoList(programInfoList);
	}	
	@Override
	public int updateBulkProgramInfoList(List<ProgramInfo> programInfoList) {
		return equipmentMaintenanceMapper.updateBulkProgramInfoList(programInfoList);
	}
	
	@Override
	public int getNewestConsumablePartsRowNo() {
		return equipmentMaintenanceMapper.getNewestConsumablePartsRowNo();
	}

	@Override
	public int insertBulkConsumablePartsInfoList(List<ConsumablePartsInfo> consumablePartsInfoList) {
		return equipmentMaintenanceMapper.insertBulkConsumablePartsInfoList(consumablePartsInfoList);
	}
	
	@Override
	public int updateBulkConsumablePartsInfoList(List<ConsumablePartsInfo> consumablePartsInfoList) {
		return equipmentMaintenanceMapper.updateBulkConsumablePartsInfoList(consumablePartsInfoList);
	}
	
	@Override
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm) {
		return equipmentMaintenanceMapper.commitEquipmentMaintenance(equipmentMaintenanceForm);
	}
	
	public int updateDeleteEquipmentInfo(int equipmentid) {
		return equipmentMaintenanceMapper.updateDeleteEquipmentInfo(equipmentid);
	}
	
	public int updateDeleteItemInfo(int equipmentid) {
		return equipmentMaintenanceMapper.updateDeleteItemInfo(equipmentid);
	}
	
	public int deleteProgramInfo(int equipmentid) {
		return equipmentMaintenanceMapper.deleteProgramInfo(equipmentid);
	}
	
	public int deleteConsumablePartsInfo(int equipmentid) {
		return equipmentMaintenanceMapper.deleteConsumablePartsInfo(equipmentid);
	}
//	@Override
//	public int deleteEquipmentMaintenance(String equipmentid) {
//		return equipmentMaintenanceMapper.deleteEquipmentMaintenance(equipmentid);
//	}
	
	

//	@Override
//	public EquipmentMaintenanceModel getEquipmentMaintenanceModel(int equipmentid) {
//		return equipmentMaintenanceMapper.getEquipmentMaintenanceModel(equipmentid);
//	}
}
