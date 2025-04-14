package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CartViewDTO;
import com.rays.form.CartForm;
import com.rays.service.CartViewServiceInt;

@RestController
@RequestMapping(value = "CartView")

public class CartViewCtl  extends BaseCtl<CartForm, CartViewDTO, CartViewServiceInt>{

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "Furniture");
		map.put(2, "Electricity");
		map.put(3, "HouseHold");
		
		
		res.addResult("product", map);
		return res;
	}

}
