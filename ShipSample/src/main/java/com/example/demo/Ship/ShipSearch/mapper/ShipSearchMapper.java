package com.example.demo.Ship.ShipSearch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.model.ShipSearchModel;

@Mapper
public interface ShipSearchMapper {
	public List<ShipSearchModel> getShipSearch(ShipSearchForm form); 
}
