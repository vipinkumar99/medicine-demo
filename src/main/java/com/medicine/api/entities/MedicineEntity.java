package com.medicine.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicines")
public class MedicineEntity {
	@Id
	@Column(unique = true)
	private String cUniqueCode;
	private String cName;
	private String cBatchNo;
	@Temporal(TemporalType.DATE)
	private Date dExpiryDate;
	private Integer nBalanceQty;
	private String cPackaging;
	private String cSchemes;
	private Double nMrp;
	private String cManufacturer;
	private Long hsnCode;
}
