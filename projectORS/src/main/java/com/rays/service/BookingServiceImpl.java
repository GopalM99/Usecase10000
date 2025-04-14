package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BookingDAOInt;
import com.rays.dto.BookingDTO;

@Service
@Transactional
public class BookingServiceImpl extends BaseServiceImpl<BookingDTO, BookingDAOInt> implements BookingServiceInt {
	@Autowired
	BookingDAOInt BookingDAO;

}
