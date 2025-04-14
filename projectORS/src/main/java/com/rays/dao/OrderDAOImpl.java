package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.OrderDTO;
import com.rays.dto.OrderDTO;


@Repository
public class OrderDAOImpl extends BaseDAOImpl<OrderDTO> implements OrderDAOInt {
	@Override
	public Class<OrderDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return OrderDTO.class;
	}
		@Override
		protected List<Predicate> getWhereClause(OrderDTO dto, CriteriaBuilder builder,
				Root<OrderDTO> qRoot) {
			// Create where conditions
			List<Predicate> whereCondition = new ArrayList<>();

			if (dto.getId() != null && dto.getId() > 0) {
				whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
			}

			if (!isEmptyString(dto.getProductName())) {
				whereCondition.add(builder.like(qRoot.get("productName"), dto.getProductName()+ "%"));
			}
			if (!isZeroNumber(dto.getQuantity())) {
				whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()+ "%" ));
			}
			if (isNotNull(dto.getOrderDate())) {
				whereCondition.add(builder.equal(qRoot.get("orderDate"), dto.getOrderDate()));
			}

			if (!isZeroNumber(dto.getCustomerId())) {
				whereCondition.add(builder.equal(qRoot.get("customerId"), dto.getCustomerId()));
			}

			return whereCondition;
		}

}
