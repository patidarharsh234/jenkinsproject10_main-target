package com.rays.wishlist;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.items.ItemsDAOImp;
import com.rays.items.ItemsDTO;


@Repository
public class WishListDAOImp extends BaseDAOImpl<WishListDTO> implements WishListDAOInt {

	@Autowired
	protected ItemsDAOImp itemsDAOImp;

	@Override
	public Class<WishListDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return WishListDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(WishListDTO dto, CriteriaBuilder builder,
			Root<WishListDTO> qRoot) {
		List<Predicate> condition = new ArrayList<Predicate>();

		if (isNotNull(dto.getitemsId())) {
			condition.add(builder.equal(qRoot.get("itemsId"), dto.getitemsId()));
		}

		if (isNotNull(dto.getdateOfPurches())) {
			condition.add(builder.equal(qRoot.get("dateOfPurches"), dto.getdateOfPurches()));
		}

		if (!isEmptyString(dto.getnames())) {
			condition.add(builder.like(qRoot.get("names"), dto.getnames() + "%"));
		}

		if (isNotNull(dto.getamount())) {
			condition.add(builder.equal(qRoot.get("amount"), dto.getamount()));
		}

		if (!isEmptyString(dto.getdescription())) {
			condition.add(builder.like(qRoot.get("description"), dto.getdescription() + "%"));
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
	protected void populate(WishListDTO dto, UserContext userContext) {

		if (dto.getitemsId() > 0 && dto.getitemsId() != null) {
			
		
			ItemsDTO itemsnames = itemsDAOImp.findByPK(dto.getitemsId(), userContext);
			dto.setitems(itemsnames.getitems());

		}
	}

}
