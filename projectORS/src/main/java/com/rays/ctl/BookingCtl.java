package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.BookingDTO;
import com.rays.form.BookingForm;
import com.rays.service.BookingServiceInt;

@RestController
@RequestMapping(value = "booking")
public class BookingCtl extends BaseCtl<BookingForm, BookingDTO, BookingServiceInt> {
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Decoration");
		map.put(2, "Fireworks");
		map.put(3, "Cars");
		map.put(4, "Artist");

		res.addResult("serviceTypeList", map);
		return res;
	}
}
