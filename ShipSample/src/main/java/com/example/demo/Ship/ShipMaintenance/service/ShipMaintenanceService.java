package com.example.demo.Ship.ShipMaintenance.service;

import java.util.List;

import com.example.demo.Ship.ShipMaintenance.form.ShipMaintenanceForm;
import com.example.demo.model.ShipMaintenanceModel;

public interface ShipMaintenanceService {
	public List<ShipMaintenanceModel> getShipMaintenance(String fshipno);
	public int insertShipMaintenance(ShipMaintenanceForm form);
	public int deleteShipMaintenance(String fshipno);
	
}
