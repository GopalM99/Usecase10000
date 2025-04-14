package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OrderDTO;

public class OrderForm extends BaseForm {

	@NotEmpty(message = "Please enter productName")
    private String productName;
	
    private String customerName;
	
    @NotNull(message = "Please enter quantity")
    private Long quantity;
	
	@NotNull(message = "Please enter orderDate")
    private Date orderDate;
	
	@NotNull(message = "Please enter customerId")
    private Long customerId;

	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	

	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


@Override
public BaseDTO getDto() {
	OrderDTO dto = initDTO(new OrderDTO());
	
	dto.setCustomerId(customerId);
	dto.setOrderDate(orderDate);
    dto.setProductName(productName);
    dto.setQuantity(quantity);
	return dto;
}
	
}
