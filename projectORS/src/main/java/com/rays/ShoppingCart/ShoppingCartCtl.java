package com.rays.ShoppingCart;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.Product.ProductDTO;
import com.rays.Product.ProductServiceInt;
import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.createpreload_2.createpreload_2DAOInt;
import com.rays.createpreload_2.createpreload_2DTO;
import com.rays.createpreload_2.createpreload_2ServiceInt;

@RestController
@RequestMapping(value = "/Shoppingcart")
public class ShoppingCartCtl extends BaseCtl<ShoppingCartForm, ShoppingCartDTO, ShoppingCartServiceInt>{
	
	
	
	
	@Autowired
	ProductServiceInt productServiceInt;
	
	

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		ProductDTO dto = new ProductDTO();

		List<DropdownList> productList = productServiceInt.search(dto, userContext);
		res.addResult("productList", productList);
		

		return res;
	}

}
