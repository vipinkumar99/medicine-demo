package com.medicine.api.convertors;

import com.medicine.api.entities.MedicineEntity;
import com.medicine.api.entities.MedicineOrderEntity;
import com.medicine.api.entities.MedicineOrderMappingEntity;
import com.medicine.api.pojos.MedicineCsvPojo;
import com.medicine.api.pojos.MedicineResponsePojo;
import com.medicine.api.pojos.OrderRequest;
import com.medicine.api.utils.DateUtil;

public class MedicineConvertor {

	public static MedicineEntity getEntity(MedicineCsvPojo request) {
		if (request == null) {
			return null;
		}
		MedicineEntity response = new MedicineEntity();
		response.setCName(request.getCName());
		response.setCBatchNo(request.getCBatchNo());
		response.setDExpiryDate(DateUtil.parseDate(request.getDExpiryDate(), DateUtil.DATE_PATTERN_CSV));
		response.setNBalanceQty(Integer.valueOf(request.getNBalanceQty()));
		response.setCPackaging(request.getCPackaging());
		response.setCUniqueCode(request.getCUniqueCode());
		response.setCSchemes(request.getCSchemes());
		response.setNMrp(Double.valueOf(request.getNMrp()));
		response.setCManufacturer(request.getCManufacturer());
		response.setHsnCode(Long.valueOf(request.getHsnCode()));
		return response;
	}

	public static MedicineResponsePojo getResponse(MedicineEntity request) {
		if (request == null) {
			return null;
		}
		MedicineResponsePojo response = new MedicineResponsePojo();
		response.setName(request.getCName());
		response.setBatchNo(request.getCBatchNo());
		response.setExpiryDate(DateUtil.formateDate(request.getDExpiryDate(), DateUtil.DATE_PATTERN));
		response.setBalanceQty(request.getNBalanceQty());
		response.setPackaging(request.getCPackaging());
		response.setUniqueCode(request.getCUniqueCode());
		response.setSchemes(request.getCSchemes());
		response.setMrp(request.getNMrp());
		response.setManufacturer(request.getCManufacturer());
		response.setHsnNo(request.getHsnCode());
		return response;
	}

	public static MedicineOrderMappingEntity getOrderMapping(MedicineOrderEntity orderEntity, OrderRequest request) {
		if (request == null) {
			return null;
		}
		MedicineOrderMappingEntity response = new MedicineOrderMappingEntity();
		response.setCName(request.getCName());
		response.setCUniqueId(request.getCUniqueId());
		response.setQuantity(request.getQuantity());
		response.setOrderId(orderEntity.getId());
		response.setOrderNo(orderEntity.getOrderNo());
		return response;
	}
}
