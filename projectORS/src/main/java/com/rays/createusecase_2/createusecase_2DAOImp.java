package com.rays.createusecase_2;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.common.attachment.AttachmentDAOInt;
import com.rays.common.attachment.AttachmentDTO;
import com.rays.createpreload_2.createpreload_2DAOInt;
import com.rays.createpreload_2.createpreload_2DTO;

@Repository
public class createusecase_2DAOImp extends BaseDAOImpl<createusecase_2DTO> implements createusecase_2DAOInt {

	@Autowired
	protected createpreload_2DAOInt productDAOInt;
	
//	@Autowired
//	protected AttachmentDAOInt AttchmentDao; 

	@Override
	public Class<createusecase_2DTO> getDTOClass() {
		// TODO Auto-generated method stub
		return createusecase_2DTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(createusecase_2DTO dto, CriteriaBuilder builder, Root<createusecase_2DTO> qRoot) {
		List<Predicate> condition = new ArrayList<Predicate>();

		if (isNotNull(dto.getProductId())) {
			condition.add(builder.equal(qRoot.get("productId"), dto.getProductId()));
		}

		if (isNotNull(dto.getDateFiled())) {
			condition.add(builder.equal(qRoot.get("dateFiled"), dto.getDateFiled()));
		}

		if (!isEmptyString(dto.getUniqueId())) {
			condition.add(builder.like(qRoot.get("uniqueId"), dto.getUniqueId()+"%"));
		}

		if (isNotNull(dto.getLongValue())) {
			condition.add(builder.equal(qRoot.get("longValue"), dto.getLongValue()));
		}
		
		if (!isEmptyString(dto.getAddres())) {
			condition.add(builder.like(qRoot.get("addres"), dto.getAddres()+"%"));
		}
		
		if (isNotNull(dto.getMobileNo())) {
			condition.add(builder.like(qRoot.get("mobileNo"), dto.getMobileNo()+"%"));
		}

		return condition;
	}

//	@Override
//	protected void populate(OrderDTO dto, UserContext userContext) {
//
//		if (dto.getProductId() > 0 && dto.getProductId() != null) {
//			AssignToDTO productName = productDAOInt.findByPK(dto.getProductId(), userContext);
//			dto.setProduct(productName.getproduct());
//		}
//		
		
		
		


//	}
	

}
