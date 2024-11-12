package com.example.demo.Ship.ShipSearch.service;

import java.util.List;

import com.example.demo.Ship.ShipSearch.form.ShipSearchForm;
import com.example.demo.model.ShipSearchModel;

public interface ShipSearchService {
	public List<ShipSearchModel> getShipSearch(ShipSearchForm form);
}
