package com.rays.ctl;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.OrderDTO;
import com.rays.form.OrderForm;
import com.rays.service.OrderServiceInt;

@RestController
@RequestMapping(value = "Order")
public class OrderCtl extends BaseCtl<OrderForm, OrderDTO, OrderServiceInt> {
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "Ram");
		map.put(2, "Sam");
		map.put(3, "Prem");
		
		
		res.addResult("customerlist", map);
		return res;
	}
	}
