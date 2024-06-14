package com.rays.product;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;


@Repository
public class ProductDAOImp extends BaseDAOImpl<ProductDTO> implements ProductDAOInt {

	@Override
	public Class<ProductDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ProductDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ProductDTO dto, CriteriaBuilder builder, Root<ProductDTO> qRoot) {
		 List<Predicate> condition=new ArrayList<Predicate>();
		return condition;
	}

}
