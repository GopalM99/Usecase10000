package com.rays.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PositionDTO;

@Repository
public class PositionDAOImpl extends BaseDAOImpl<PositionDTO> implements PositionDAOInt {

	@Override
	public Class<PositionDTO> getDTOClass() {
		return PositionDTO.class;
	}

	

	@Override
	protected List<Predicate> getWhereClause(PositionDTO dto, CriteriaBuilder builder,
			Root<PositionDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		

		if (!isEmptyString(dto.getDesignation())) {
			whereCondition.add(builder.like(qRoot.get("designation"), dto.getDesignation()+ "%"));
		}

		if (!isEmptyString(dto.getRequiredExperience())) {
			whereCondition.add(builder.like(qRoot.get("requiredExperience"), dto.getRequiredExperience()+ "%"));
		}

	

		if (isNotNull(dto.getOpeningDate())) {
			whereCondition.add(builder.equal(qRoot.get("openingDate"), dto.getOpeningDate()));
		}

		if (!isZeroNumber(dto.getConditionId())) {
			whereCondition.add(builder.equal(qRoot.get("conditionId"), dto.getConditionId()));
		}

		return whereCondition;
	}



}