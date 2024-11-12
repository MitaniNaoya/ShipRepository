package com.example.demo.Ship.ShipMaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Ship.ShipMaintenance.form.ShipMaintenanceForm;
import com.example.demo.Ship.ShipMaintenance.mapper.ShipMaintenanceMapper;
import com.example.demo.model.ShipMaintenanceModel;

@Service
public class ShipMaintenanceServiceimpl implements ShipMaintenanceService {
	@Autowired
	private ShipMaintenanceMapper shipMaintenanceMapper;
	
	@Override
	public List<ShipMaintenanceModel> getShipMaintenance(String fshipno) {
		return shipMaintenanceMapper.getShipMaintenance(fshipno);
	}
	
	@Override
	public int insertShipMaintenance(ShipMaintenanceForm form) {
		return shipMaintenanceMapper.insertShipMaintenance(form);
	}
	
	@Override
	public int deleteShipMaintenance(String fshipno) {
		return shipMaintenanceMapper.deleteShipMaintenance(fshipno);
	}
	
}
