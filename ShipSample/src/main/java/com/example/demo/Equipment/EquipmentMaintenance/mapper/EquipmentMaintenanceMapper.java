package com.example.demo.Equipment.EquipmentMaintenance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.model.EquipmentMaintenanceModel;

@Mapper
public interface EquipmentMaintenanceMapper {
	public List<EquipmentMaintenanceModel> getEquipmentMaintenance(String equipmentid);
	public List<EquipmentMaintenanceModel> getInsertedEquipmentMaintenance(String fshipn); 
	public int saveEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm); 
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm); 
	public int deleteEquipmentMaintenance(String equipmentid); 
}
