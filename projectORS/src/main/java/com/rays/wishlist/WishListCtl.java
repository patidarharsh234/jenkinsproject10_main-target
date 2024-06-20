package com.rays.wishlist;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.items.ItemsDTO;
import com.rays.items.ItemsServiceInt;

@RestController
@RequestMapping(value = "/WishList")
public class WishListCtl extends BaseCtl<WishListForm, WishListDTO, WishListServiceInt>{
	
	
	
	
	@Autowired
	ItemsServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		ItemsDTO dto = new ItemsDTO();

		List<DropdownList> itemsList = serviceInt.search(dto, userContext);
		res.addResult("itemsList", itemsList);

		return res;
	}

}
