package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BookingDTO;

public class BookingForm  extends BaseForm{
	
	@NotEmpty(message = "Please enter customerName")
    private String customerName;
	
    private String serviceType;
	
	@NotEmpty(message = "Please enter location")
    private String location;
	
	@NotNull(message = "Please enter booking_Date")
    private Date bookingDate;
	
	@NotNull(message = "Please enter serviceType")
    private Integer serviceTypeId;
	
	
	
	
	



	public Integer getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	@Override
	public BaseDTO getDto() {
		BookingDTO dto = initDTO(new BookingDTO());

		dto.setCustomerName(customerName);
		dto.setLocation(location);
		dto.setBookingDate(bookingDate);

		dto.setServiceTypeId(serviceTypeId);
		
		return dto;
	}

}
