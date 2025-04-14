package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BookingDTO;

@Repository
public class BookingDAOImpl extends BaseDAOImpl<BookingDTO> implements BookingDAOInt{
 @Override
public Class<BookingDTO> getDTOClass() {
	// TODO Auto-generated method stub
	return BookingDTO.class;
}
 

	@Override
	protected List<Predicate> getWhereClause(BookingDTO dto, CriteriaBuilder builder,
			Root<BookingDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		

		if (!isEmptyString(dto.getCustomerName())) {
			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName()+ "%"));
		}

		if (!isEmptyString(dto.getLocation())) {
			whereCondition.add(builder.like(qRoot.get("location"), dto.getLocation()+ "%"));
		}

	

		if (isNotNull(dto.getBookingDate())) {
			whereCondition.add(builder.equal(qRoot.get("bookingDate"), dto.getBookingDate()));
		}

		if (!isZeroNumber(dto.getServiceTypeId())) {
			whereCondition.add(builder.equal(qRoot.get("serviceTypeId"), dto.getServiceTypeId()));
		}

		return whereCondition;
	}

}
