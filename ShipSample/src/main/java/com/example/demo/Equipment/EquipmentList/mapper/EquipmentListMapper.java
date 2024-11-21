package com.example.demo.Equipment.EquipmentList.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.EquipmentInfo;
import com.example.demo.model.EquipmentListModel;
import com.example.demo.model.ShipInfo;

@Mapper
public interface EquipmentListMapper {
	public ShipInfo getShipInfo(String fshipno);
	public List<EquipmentInfo> getEquipmentList(String fshipno);
	public EquipmentListModel getEquipmentListModel(String fshipno);
}
