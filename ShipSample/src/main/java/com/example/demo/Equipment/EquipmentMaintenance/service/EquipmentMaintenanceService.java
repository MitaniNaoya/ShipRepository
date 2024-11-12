package com.example.demo.Equipment.EquipmentMaintenance.service;

import java.util.List;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.model.EquipmentMaintenanceModel;

public interface EquipmentMaintenanceService {
	public List<EquipmentMaintenanceModel> getUpdatedEquipmentMaintenance(String equipmentid);
	public List<EquipmentMaintenanceModel> getInsertedEquipmentMaintenance(String fshipno);
	public int saveEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm);
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm);
	public int deleteEquipmentMaintenance(String equipmentid);
	
}
