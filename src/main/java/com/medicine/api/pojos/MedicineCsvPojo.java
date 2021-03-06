package com.medicine.api.pojos;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineCsvPojo {
	@CsvBindByName(column = "c_name")
	private String cName;
	@CsvBindByName(column = "c_batch_no")
	private String cBatchNo;
	@CsvBindByName(column = "d_expiry_date")
	private String dExpiryDate;
	@CsvBindByName(column = "n_balance_qty")
	private String nBalanceQty;
	@CsvBindByName(column = "c_packaging")
	private String cPackaging;
	@CsvBindByName(column = "c_unique_code")
	private String cUniqueCode;
	@CsvBindByName(column = "c_schemes")
	private String cSchemes;
	@CsvBindByName(column = "n_mrp")
	private String nMrp;
	@CsvBindByName(column = "c_manufacturer")
	private String cManufacturer;
	@CsvBindByName(column = "hsn_code")
	private String hsnCode;	
}
