package com.rays.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.priority.PriorityDAOImp;
import com.rays.priority.PriorityDTO;


@Repository
public class ClientDAOImp extends BaseDAOImpl<ClientDTO> implements ClientDAOInt {

	@Autowired
	protected PriorityDAOImp priorityDAOImp;

	@Override
	public Class<ClientDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ClientDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ClientDTO dto, CriteriaBuilder builder,
			Root<ClientDTO> qRoot) {
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
	protected void populate(ClientDTO dto, UserContext userContext) {

		if (dto.getPriorityId() > 0 && dto.getPriorityId() != null) {
			
		
			PriorityDTO priorityName = priorityDAOImp.findByPK(dto.getPriorityId(), userContext);
			dto.setPriority(priorityName.getPriority());

		}
	}

}
