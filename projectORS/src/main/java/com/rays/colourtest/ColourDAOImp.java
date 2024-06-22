package com.rays.colourtest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class ColourDAOImp extends BaseDAOImpl<ColourDTO> implements ColourDAOInt {

	@Override
	public Class<ColourDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ColourDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ColourDTO dto, CriteriaBuilder builder, Root<ColourDTO> qRoot) {
		List<Predicate> condoition=new ArrayList<Predicate>();
		return condoition;
	}

}
