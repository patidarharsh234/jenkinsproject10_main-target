package com.rays.createusecase_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.createpreload_2.createpreload_2DTO;
import com.rays.createpreload_2.createpreload_2ServiceInt;

@RestController

@RequestMapping(value = "/Order")
public class createusecase_2Ctl extends BaseCtl<createusecase_2Form, createusecase_2DTO, createusecase_2ServiceInt> {

	@Autowired
	createpreload_2ServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		createpreload_2DTO dto = new createpreload_2DTO();

		List<DropdownList> productRoleList = serviceInt.search(dto, userContext);
		res.addResult("productRoleList", productRoleList);

		return res;
	}

}
