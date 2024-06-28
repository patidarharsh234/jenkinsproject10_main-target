package com.rays.createpreload_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class createpreload_1DAOImp extends BaseDAOImpl<createpreload_1DTO> implements createpreload_1DAOInt {

	@Override
	public Class<createpreload_1DTO> getDTOClass() {
		// TODO Auto-generated method stub
		return createpreload_1DTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(createpreload_1DTO dto, CriteriaBuilder builder, Root<createpreload_1DTO> qRoot) {
		List<Predicate> condoition=new ArrayList<Predicate>();
		return condoition;
	}

}
