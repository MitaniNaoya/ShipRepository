package com.example.demo.Equipment.EquipmentList.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.EquipmentListModel;

@Mapper
public interface EquipmentListMapper {
	public List<EquipmentListModel> getEquipmentList(String fshipno);

}
