package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartViewDTO;

@Repository
public class CartViewDAOImpl extends BaseDAOImpl<CartViewDTO>implements CartViewDAOInt {

	@Override
	public Class<CartViewDTO> getDTOClass() {
		return CartViewDTO.class;
	}

	

	@Override
	protected List<Predicate> getWhereClause(CartViewDTO dto, CriteriaBuilder builder,
			Root<CartViewDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		

		
		 if (!isEmptyString(dto.getProduct())) {
			  whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct()+
			  "%"));
			  }
		 

		if (!isEmptyString(dto.getCustomerName())) {
			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName()+ "%"));
		}

	

		if (isNotNull(dto.getTransactionDate())) {
			whereCondition.add(builder.equal(qRoot.get("transactionmDate"), dto.getTransactionDate()));
		}

		if (!isZeroNumber(dto.getQuantity())) {
			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
		}

		return whereCondition;
	}


}
