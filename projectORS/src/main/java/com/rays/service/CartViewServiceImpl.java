package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CartViewDAOInt;
import com.rays.dto.CartViewDTO;

@Service
@Transactional
public class CartViewServiceImpl extends BaseServiceImpl<CartViewDTO, CartViewDAOInt> implements CartViewServiceInt {

	
}
