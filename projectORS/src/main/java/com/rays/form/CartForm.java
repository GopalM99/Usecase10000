package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartViewDTO;

public class CartForm extends BaseForm {

	@NotEmpty(message = "Please enter product")
     private String product;

	@NotEmpty(message = "Please enter customerName")
	private String customerName;

	@NotNull(message = "Please enter transactionDate")
	private Date transactionDate;
 

	@NotNull(message = "Please enter quantity")
	private Long quantity;


	
	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

@Override
public BaseDTO getDto() {
	CartViewDTO dto = initDTO(new CartViewDTO ());

	dto.setProduct(product);
	dto.setCustomerName(customerName);
	dto.setTransactionDate(transactionDate);

	dto.setQuantity(quantity);
	
	return dto;
}

}
