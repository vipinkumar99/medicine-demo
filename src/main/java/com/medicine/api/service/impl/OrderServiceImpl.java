package com.medicine.api.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.api.convertors.MedicineConvertor;
import com.medicine.api.dao.MedicineOrderDao;
import com.medicine.api.dao.MedicineOrderMappingDao;
import com.medicine.api.entities.MedicineOrderEntity;
import com.medicine.api.entities.MedicineOrderMappingEntity;
import com.medicine.api.pojos.OrderRequest;
import com.medicine.api.pojos.OrderResponse;
import com.medicine.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MedicineOrderDao medicineOrderDao;

	@Autowired
	private MedicineOrderMappingDao medicineOrderMappingDao;

	@Override
	public OrderResponse saveOrder(Set<OrderRequest> requestList) {
		if (CollectionUtils.isEmpty(requestList)) {
			throw new RuntimeException("Empty Request!");
		}
		MedicineOrderEntity orderEntity = new MedicineOrderEntity();
		medicineOrderDao.save(orderEntity);
		orderEntity.setOrderNo("MOID" + orderEntity.getId());
		medicineOrderDao.save(orderEntity);
		Set<MedicineOrderMappingEntity> mappings = requestList.parallelStream()
				.map(o -> MedicineConvertor.getOrderMapping(orderEntity, o)).collect(Collectors.toSet());
		if (CollectionUtils.isEmpty(mappings)) {
			medicineOrderDao.delete(orderEntity);
			return null;
		}
		medicineOrderMappingDao.saveAll(mappings);
		OrderResponse response = new OrderResponse();
		response.setOrderId(orderEntity.getOrderNo());
		return response;
	}

}
