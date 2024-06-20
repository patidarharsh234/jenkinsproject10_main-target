package com.rays.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.priority.PriorityDTO;
import com.rays.priority.PriorityServiceInt;

@RestController
@RequestMapping(value = "/Client")
public class ClientCtl extends BaseCtl<ClientForm, ClientDTO, ClientServiceInt>{
	
	
	
	
	@Autowired
	PriorityServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		PriorityDTO dto = new PriorityDTO();

		List<DropdownList> priorityList = serviceInt.search(dto, userContext);
		res.addResult("priorityList", priorityList);

		return res;
	}

}
