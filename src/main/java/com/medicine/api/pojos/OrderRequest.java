package com.medicine.api.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	@JsonProperty("c_unique_id")
	private String cUniqueId;
	private Integer quantity;
	@JsonProperty("c_name")
	private String cName;
}
