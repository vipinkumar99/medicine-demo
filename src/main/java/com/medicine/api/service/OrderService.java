package com.medicine.api.service;

import java.util.Set;

import com.medicine.api.pojos.OrderRequest;
import com.medicine.api.pojos.OrderResponse;

public interface OrderService {
	OrderResponse saveOrder(Set<OrderRequest>requestList);
}
