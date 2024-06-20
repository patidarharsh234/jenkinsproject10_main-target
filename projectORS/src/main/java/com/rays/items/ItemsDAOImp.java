package com.rays.items;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class ItemsDAOImp extends BaseDAOImpl<ItemsDTO> implements ItemsDAOInt {

	@Override
	public Class<ItemsDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ItemsDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ItemsDTO dto, CriteriaBuilder builder, Root<ItemsDTO> qRoot) {
		List<Predicate> condoition=new ArrayList<Predicate>();
		return condoition;
	}

}
