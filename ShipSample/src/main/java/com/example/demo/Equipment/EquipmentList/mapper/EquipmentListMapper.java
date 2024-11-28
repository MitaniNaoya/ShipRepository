package com.example.demo.Equipment.EquipmentList.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EquipmentInfo;
import com.example.demo.entity.ShipInfo;

@Mapper
public interface EquipmentListMapper {
	public ShipInfo getShipInfo(String fshipno);
	public List<EquipmentInfo> getEquipmentList(String fshipno);
}
