package com.medicine.api.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineResponsePojo {
	private String uniqueCode;
	private String name;
	private String manufacturer;
	private String packaging;
	private String batchNo;
	private String expiryDate;
	private Integer balanceQty;
	private String schemes;
	private Double mrp;
	private Long hsnNo;
}
