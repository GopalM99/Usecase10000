package com.rays.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.PositionDAOInt;
import com.rays.dto.PositionDTO;

@Service
@Transactional
public class PositionServiceImpl extends BaseServiceImpl<PositionDTO, PositionDAOInt>
		implements PositionServiceInt {

	@Autowired
	PositionDAOInt PositionDAO;

	
}

