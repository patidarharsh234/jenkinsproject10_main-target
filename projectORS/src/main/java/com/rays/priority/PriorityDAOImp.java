package com.rays.priority;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class PriorityDAOImp extends BaseDAOImpl<PriorityDTO> implements PriorityDAOInt {

	@Override
	public Class<PriorityDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return PriorityDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(PriorityDTO dto, CriteriaBuilder builder, Root<PriorityDTO> qRoot) {
		List<Predicate> condoition=new ArrayList<Predicate>();
		return condoition;
	}

}
