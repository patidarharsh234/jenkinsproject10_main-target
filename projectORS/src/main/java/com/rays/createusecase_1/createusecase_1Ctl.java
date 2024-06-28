package com.rays.createusecase_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.createpreload_1.createpreload_1DTO;
import com.rays.createpreload_1.createpreload_1ServiceInt;

@RestController
@RequestMapping(value = "/Client")
public class createusecase_1Ctl extends BaseCtl<createusecase_1Form, createusecase_1DTO, createusecase_1ServiceInt>{
	
	
	
	
	@Autowired
	createpreload_1ServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		createpreload_1DTO dto = new createpreload_1DTO();

		List<DropdownList> priorityList = serviceInt.search(dto, userContext);
		res.addResult("priorityList", priorityList);

		return res;
	}

}
