package com.example.demo.Equipment.EquipmentMaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Equipment.EquipmentMaintenance.form.EquipmentMaintenanceForm;
import com.example.demo.Equipment.EquipmentMaintenance.mapper.EquipmentMaintenanceMapper;
import com.example.demo.model.EquipmentMaintenanceModel;

@Service
public class EquipmentMaintenanceServiceimpl implements EquipmentMaintenanceService {
	@Autowired
	private EquipmentMaintenanceMapper equipmentMaintenanceMapper;
	
	@Override
	public List<EquipmentMaintenanceModel> getUpdatedEquipmentMaintenance(String equipmentid) {
		return equipmentMaintenanceMapper.getEquipmentMaintenance(equipmentid);
	}
	
	@Override
	public List<EquipmentMaintenanceModel> getInsertedEquipmentMaintenance(String fshipno) {
		return equipmentMaintenanceMapper.getInsertedEquipmentMaintenance(fshipno);
	}
	
	@Override
	public int saveEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm) {
		return equipmentMaintenanceMapper.saveEquipmentMaintenance(equipmentMaintenanceForm);
	}
	
	@Override
	public int commitEquipmentMaintenance(EquipmentMaintenanceForm equipmentMaintenanceForm) {
		return equipmentMaintenanceMapper.commitEquipmentMaintenance(equipmentMaintenanceForm);
	}
	
	@Override
	public int deleteEquipmentMaintenance(String equipmentid) {
		return equipmentMaintenanceMapper.deleteEquipmentMaintenance(equipmentid);
	}
}
