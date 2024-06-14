package com.rays.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.product.ProductDTO;
import com.rays.product.ProductServiceInt;

@RestController

@RequestMapping(value = "/Order")
public class OrderCtl extends BaseCtl<OrderForm, OrderDTO, OrderServiceInt> {

	@Autowired
	ProductServiceInt serviceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		ProductDTO dto = new ProductDTO();

		List<DropdownList> productRoleList = serviceInt.search(dto, userContext);
		res.addResult("productRoleList", productRoleList);

		return res;
	}

}
