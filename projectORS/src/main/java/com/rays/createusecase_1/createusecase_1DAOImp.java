package com.rays.createusecase_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.createpreload_1.createpreload_1DAOImp;
import com.rays.createpreload_1.createpreload_1DAOInt;
import com.rays.createpreload_1.createpreload_1DTO;


@Repository
public class createusecase_1DAOImp extends BaseDAOImpl<createusecase_1DTO> implements createusecase_1DAOInt {

	@Autowired
	protected createpreload_1DAOInt priorityDAOInt;

	@Override
	public Class<createusecase_1DTO> getDTOClass() {
		// TODO Auto-generated method stub
		return createusecase_1DTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(createusecase_1DTO dto, CriteriaBuilder builder,
			Root<createusecase_1DTO> qRoot) {
		List<Predicate> condition = new ArrayList<Predicate>();

		if (isNotNull(dto.getPriorityId())) {
			condition.add(builder.equal(qRoot.get("priorityId"), dto.getPriorityId()));
		}
		if (isNotBlankDecimal(dto.getDoubleValue())) {
			condition.add(builder.equal(qRoot.get("doubleValue"), dto.getDoubleValue()));
		}

		if (isNotNull(dto.getclientDate())) {
			condition.add(builder.equal(qRoot.get("clientDate"), dto.getclientDate()));
		}

		if (!isEmptyString(dto.getNames())) {
			condition.add(builder.like(qRoot.get("names"), dto.getNames() + "%"));
		}

		if (isNotNull(dto.getSalary())) {
			condition.add(builder.equal(qRoot.get("salary"), dto.getSalary()));
		}

		if (!isEmptyString(dto.getAddress())) {
			condition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
		}
		
		if (isNotNull(dto.getPhoneNo())) {
			condition.add(builder.equal(qRoot.get("phoneNo"), dto.getPhoneNo()));
		}
		if (isNotNull(dto.getEmailId())) {
			condition.add(builder.equal(qRoot.get("emailId"), dto.getEmailId()+ "%"));
		}



	

		return condition;
	}

	@Override
	protected void populate(createusecase_1DTO dto, UserContext userContext) {

		if (dto.getPriorityId() > 0 && dto.getPriorityId() != null) {
			
		
			createpreload_1DTO priorityName = priorityDAOInt.findByPK(dto.getPriorityId(), userContext);
			dto.setPriority(priorityName.getPriority());

		}
	}

}
