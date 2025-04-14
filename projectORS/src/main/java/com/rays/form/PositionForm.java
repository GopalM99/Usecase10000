package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PositionDTO;

public class PositionForm extends BaseForm {

	@Size(max = 20, message = "enter 20 charactor only")

	@NotEmpty(message = "Please enter designation")
     private String designation;

	@NotEmpty(message = "Please enter requiredExperience")
	@Size(min = 1,message = "requiredExperience is greater then 0")
	private String requiredExperience;

	@NotNull(message = "Please enter openingDate")
	private Date openingDate;
 
	private String conditionName;

	@NotNull(message = "Please enter condition")
	private Long conditionId;

	
	
	
	public String getDesignation() {
		return designation;
	}




	public void setDesignation(String designation) {
		this.designation = designation;
	}




	public String getRequiredExperience() {
		return requiredExperience;
	}




	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}




	public Date getOpeningDate() {
		return openingDate;
	}




	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}




	



	public String getConditionName() {
		return conditionName;
	}




	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}




	public Long getConditionId() {
		return conditionId;
	}




	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}




	@Override
	public BaseDTO getDto() {
		PositionDTO dto = initDTO(new PositionDTO());

		dto.setDesignation(designation);
		dto.setRequiredExperience(requiredExperience);
		dto.setOpeningDate(openingDate);

		dto.setConditionId(conditionId);
		
		return dto;
	}
}