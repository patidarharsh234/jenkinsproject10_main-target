package com.rays.vehicle;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.colourtest.ColourDTO;
import com.rays.colourtest.ColourServiceInt;
import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;

@RestController
@RequestMapping(value = "/vehicle")
public class vehicleCtl extends BaseCtl<VehicleForm, vehicleDTO, vehicleServiceInt>{
	
	
	
	
	@Autowired
	ColourServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		ColourDTO dto = new ColourDTO();

		List<DropdownList> colourList = serviceInt.search(dto, userContext);
		res.addResult("colourList", colourList);

		return res;
	}

}
