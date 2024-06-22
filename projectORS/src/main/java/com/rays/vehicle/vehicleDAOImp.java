package com.rays.vehicle;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.colourtest.ColourDAOImp;
import com.rays.colourtest.ColourDTO;
import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;


@Repository
public class vehicleDAOImp extends BaseDAOImpl<vehicleDTO> implements vehicleDAOInt {

	@Autowired
	protected ColourDAOImp colourDAOImp;

	@Override
	public Class<vehicleDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return vehicleDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(vehicleDTO dto, CriteriaBuilder builder,
			Root<vehicleDTO> qRoot) {
		List<Predicate> condition = new ArrayList<Predicate>();

		if (isNotNull(dto.getColourId())) {
			condition.add(builder.equal(qRoot.get("colourId"), dto.getColourId()));
		}

		if (isNotNull(dto.getPurchaseDate())) {
			condition.add(builder.equal(qRoot.get("purchaseDate"), dto.getPurchaseDate()));
		}

	if (isNotBlankDecimal(dto.getInsuranceAmount())) {
			condition.add(builder.equal(qRoot.get("insuranceAmount"), dto.getInsuranceAmount()));
		}

		if (!isEmptyString(dto.getNumber())) {
			condition.add(builder.like(qRoot.get("number"), dto.getNumber() + "%"));
		}
		




	

		return condition;
	}

	@Override
	protected void populate(vehicleDTO dto, UserContext userContext) {

		if (dto.getColourId() > 0 && dto.getColourId() != null) {
			
		
			ColourDTO colur = colourDAOImp.findByPK(dto.getColourId(), userContext);
			dto.setColour(colur.getColour());

		}
	}

}
