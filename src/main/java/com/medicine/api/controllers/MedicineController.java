package com.medicine.api.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medicine.api.pojos.MedicineResponsePojo;
import com.medicine.api.pojos.OrderRequest;
import com.medicine.api.pojos.OrderResponse;
import com.medicine.api.service.MedicineService;
import com.medicine.api.service.OrderService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	@Autowired
	private OrderService orderService;

	@PostMapping("/uploadCSV")
	public boolean uploadCsv(@RequestBody MultipartFile file) throws Exception {
		return medicineService.saveFromCsv(file);
	}

	@GetMapping("/searchMedicine")
	public List<String> searchMedicine(@RequestParam String requestParm) {
		return medicineService.searchMedicine(requestParm);
	}

	@GetMapping("/getMedicineDetails/{cUniqueId}")
	public MedicineResponsePojo getByCUniqueId(@PathVariable("cUniqueId") String cUniqueId) {
		return medicineService.getMedicineDetails(cUniqueId);
	}

	@PostMapping("/placeorder")
	public OrderResponse placeOrder(@RequestBody Set<OrderRequest> requestList) throws Exception {
		return orderService.saveOrder(requestList);
	}
}
