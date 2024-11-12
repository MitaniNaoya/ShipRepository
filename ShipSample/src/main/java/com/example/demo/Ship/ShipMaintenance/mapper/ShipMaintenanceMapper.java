package com.example.demo.Ship.ShipMaintenance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Ship.ShipMaintenance.form.ShipMaintenanceForm;
import com.example.demo.model.ShipMaintenanceModel;

@Mapper
public interface ShipMaintenanceMapper {
	public List<ShipMaintenanceModel> getShipMaintenance(String fshipno);
	public int insertShipMaintenance(ShipMaintenanceForm form); 
	public int deleteShipMaintenance(String fshipno); 
}
