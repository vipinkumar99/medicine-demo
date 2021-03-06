package com.medicine.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.medicine.api.pojos.MedicineResponsePojo;

public interface MedicineService {
boolean saveFromCsv(MultipartFile file) throws Exception;
List<String>searchMedicine(String name);
MedicineResponsePojo getMedicineDetails(String cUniqueId);
}
