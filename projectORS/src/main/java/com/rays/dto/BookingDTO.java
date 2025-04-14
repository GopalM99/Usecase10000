package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_booking")
public class BookingDTO extends BaseDTO {

	@Column(name = "CUSTOMER_NAME", length = 50)
	private String customerName;
	
	@Column(name = "SERVICE_TYPE", length = 50)
	private String serviceType;
	
	@Column(name = "LOCATION", length = 50)
	private String location;
	
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	
	@Column(name = "SERVICE_TYPE_ID")
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

	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return "orgName";
	}

	@Override
	public String getUniqueKey() {
		return "orgName";
	}

	@Override
	public String getUniqueValue() {
		return "orgName";
	}

	@Override
	public String getLabel() {
		return "orgName";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("customerName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}
}
