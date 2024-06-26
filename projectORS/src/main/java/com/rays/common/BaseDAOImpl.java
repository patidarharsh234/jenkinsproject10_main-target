package com.rays.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.dto.UserDTO;
import com.rays.exception.DuplicateRecordException;

/**
 * @author Harsh Patidar
 *
 * @param <T>
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		// this.sessionFactory =
		// entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
	}
	
	
	/**
	 * Get DTO Class object
	 * 
	 * @return
	 */
	
	public abstract Class<T> getDTOClass();
	
	/**
	 * Populate redundant values into dto. Overridden by chiled classes.
	 * 
	 * @param dto
	 */
	protected void populate(T dto, UserContext userContext) {

	}
	/**
	 * Add a record
	 */
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		dto.setOrgId(userContext.getOrgId());
		dto.setOrgName(userContext.getOrgName());

		populate(dto, userContext);
		entityManager.persist(dto);

		return dto.getId();

	}

	
	
	/**
	 * Update a record
	 */
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());

		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);

	}	

	/**
	 * Delete a record
	 */
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);
	}
	
	/**
	 * Find record by Unique key
	 * 
	 * @param attribute
	 * @param val
	 * @param dtoClass
	 * @return
	 */

	// search krna ho one row ko or dtoClass return type se define hoti kon si chlni
	// he.
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);//-->resulteClass
		System.out.println("criteriaQuery-cq=" + cq);

		Root<T> qRoot = cq.from(dtoClass);//-->entityClass

		Predicate condition = builder.equal(qRoot.get(attribute), val);//Exprestion X,Object Y

		if (userContext != null && !isZeroNumber(userContext.getOrgId())) {
			Predicate conditionGrp = builder.equal(qRoot.get("org_id"), userContext.getOrgId());//-->criteria.Predicate
			cq.where(condition, conditionGrp);//->predicate..criteriya
		} else {
			cq.where(condition);
		}

		TypedQuery<T> query = entityManager.createQuery(cq);//->createQuery.

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;

	}

	public T findByPK(long pk, UserContext userContext) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}
	
	




	/**
	 * Creates WHERE clause of search
	 * 
	 * @param dto
	 * @param builder
	 * @param qRoot
	 * @return
	 */
	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	/**
	 * Build criteria query
	 * 
	 * @param dto
	 * @return
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());//result Class

		Root<T> qRoot = cq.from(getDTOClass()); //EntityClass

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		//orgId (protected Long orgId = 0L;) 0 set ki he.  and jb bhi user ctl se data save krta he to uske tabel ki row me 
		//org id 0 add hoti chli jati he.
//		if (dto.isGroupFilter()) {
//			whereClause.add(builder.equal(qRoot.get("orgId"), dto.getOrgId()));
//		}

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		List<Order> orderBys = getOrderByClause(dto, builder, qRoot);
		cq.orderBy(orderBys.toArray(new Order[orderBys.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		if (pageSize > 0) {

			query.setFirstResult(pageNo * pageSize);//  initioal index
			query.setMaxResults(pageSize);  //pageNo se kitni value le kr aana he //number of recoerds.
		}

		List list = query.getResultList();

		return list;
	}

	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Run HQL query
	 * 
	 * @param hql
	 * @param userContext
	 * @return
	 */
	public List runHQL(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		List L = q.getResultList();
		return L;
	}

	public List marksheetMeritList(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List L = q.getResultList();
		return L;
	}





	/**
	 * Check empty string
	 * 
	 * @param val
	 * @return
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Check zero number
	 * 
	 * @param val
	 * @return
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Check zero number
	 * 
	 * @param val
	 * @return
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Check zero number
	 * 
	 * @param val
	 * @return
	 */

	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	protected boolean isNotNull(Object val) {
		return val != null;
	}

	
	
    public static boolean isNotBlankDecimal(double value) {
        return  value != 0.0;
    }
    
    
    public static boolean isBlankDecimal(double value) {
    	   return Double.isNaN(value) || value == 0.0;
    }

    
    
	/**
	 * Get order by clause
	 * 
	 * @param dto
	 * @param builder
	 * @param qRoot
	 * @return
	 */
	protected List<Order> getOrderByClause(T dto, CriteriaBuilder builder, Root<T> qRoot) {

		// Apply Order by clause
		LinkedHashMap<String, String> map = dto.orderBY();

		List<Order> orderBys = new ArrayList<Order>();

		map.forEach((key, value) -> {
			if (value.equals("asc")) {
				orderBys.add(builder.asc(qRoot.get(key)));
			} else {
				orderBys.add(builder.desc(qRoot.get(key)));
			}
		});

		return orderBys;
	}

	/**
	 * Check unique keys
	 * 
	 * @param dto
	 */
	private void checkDuplicate(T dto, UserContext userContext) {
		LinkedHashMap<String, Object> uniqueKeys = dto.uniqueKeys();
		if (uniqueKeys == null) {
			return;
		}
		uniqueKeys.forEach((key, value) -> {
			T dtoExist = findByUniqueKey(key, value, userContext);
			if (dtoExist != null && dto.getId() != dtoExist.getId()) {
				throw new DuplicateRecordException("Inside basedaoimpl " + key + " already exists");
			}
		});
	}

}
