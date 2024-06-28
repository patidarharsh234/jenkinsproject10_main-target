package com.rays.ShoppingCart;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.Product.ProductDAOInt;
import com.rays.Product.ProductDTO;
import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;


@Repository
public class ShoppingCartDAOImp extends BaseDAOImpl<ShoppingCartDTO> implements ShoppingCartDAOInt {

	@Autowired
	protected ProductDAOInt productDAOInt;
	

	@Override
	public Class<ShoppingCartDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ShoppingCartDTO.class;
	}
	
	@Override
	protected List<Predicate> getWhereClause(ShoppingCartDTO dto, CriteriaBuilder builder,
			Root<ShoppingCartDTO> qRoot) {
		List<Predicate> condition = new ArrayList<Predicate>();

		//role
		if (isNotNull(dto.getproductId())) {
			condition.add(builder.equal(qRoot.get("productId"), dto.getproductId()));
		}
	
      //dto Filed

		if (!isEmptyString(dto.getName())) {
			condition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		
		
//
//		if (!isEmptyString(dto.getDescription())) {
//			condition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
//		}
		

		  //decimale -double
//	if (isNotBlankDecimal(dto.getPrice())) {
//		condition.add(builder.equal(qRoot.get("price"), dto.getPrice()));
//	}
//
		
		//Long
	if (isNotNull(dto.getquantity())) {
		condition.add(builder.equal(qRoot.get("quantity"), dto.getquantity()));
	}
		
//		
//date filed
		if (isNotNull(dto.getdates())) {
			condition.add(builder.equal(qRoot.get("dates"), dto.getdates()));
		}
		
		
         //int
			/*
			 * if (!isZeroNumber(dto.getAllowdSpeed())) {
			 * condition.add(builder.equal(qRoot.get("allowdSpeed"), dto.getAllowdSpeed()));
			 * }
			 */
	
		
	     
	
		




	

		return condition;
	}

	@Override
	protected void populate(ShoppingCartDTO dto, UserContext userContext) {

		if (dto.getproductId() > 0 && dto.getproductId() != null) {
			
		
			ProductDTO productDTO = productDAOInt.findByPK(dto.getproductId(), userContext);
			dto.setproduct(productDTO.getproduct());

		}
		
	}
	


}
