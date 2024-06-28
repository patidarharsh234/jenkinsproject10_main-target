package com.rays.createpreload_2;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;


@Repository
public class createpreload_2DAOImp extends BaseDAOImpl<createpreload_2DTO> implements createpreload_2DAOInt {

	@Override
	public Class<createpreload_2DTO> getDTOClass() {
		// TODO Auto-generated method stub
		return createpreload_2DTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(createpreload_2DTO dto, CriteriaBuilder builder, Root<createpreload_2DTO> qRoot) {
		 List<Predicate> condition=new ArrayList<Predicate>();
		return condition;
	}

}
