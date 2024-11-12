package com.example.demo.Ship.ShipSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.Ship.ShipSearch.mapper.ShipSearchMapper;
import com.example.demo.model.ShipSearchModel;

@Service
public class ShipSearchServiceimpl implements ShipSearchService {
	@Autowired
	private ShipSearchMapper shipSearchMapper;
	
	@Override
	public List<ShipSearchModel> getShipSearch(ShipSearchForm form) {
		return shipSearchMapper.getShipSearch(form);
	}
	

}
