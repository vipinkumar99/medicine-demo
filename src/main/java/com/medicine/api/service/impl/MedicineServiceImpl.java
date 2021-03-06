package com.medicine.api.service.impl;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.medicine.api.convertors.MedicineConvertor;
import com.medicine.api.dao.MedicineDao;
import com.medicine.api.entities.MedicineEntity;
import com.medicine.api.pojos.MedicineCsvPojo;
import com.medicine.api.pojos.MedicineResponsePojo;
import com.medicine.api.service.MedicineService;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean saveFromCsv(MultipartFile file) throws Exception {
		List<MedicineCsvPojo> medicines = new CsvToBeanBuilder(new InputStreamReader(file.getInputStream()))
				.withType(MedicineCsvPojo.class).withIgnoreLeadingWhiteSpace(true).build().parse();
		Set<MedicineEntity> entities = medicines.parallelStream().filter(m -> !StringUtils.isEmpty(m.getCUniqueCode()))
				.map(m -> MedicineConvertor.getEntity(m)).collect(Collectors.toSet());
		if (CollectionUtils.isEmpty(entities)) {
			return false;
		}
		medicineDao.saveAll(entities);
		return true;
	}

	@Override
	public List<String> searchMedicine(String name) {
		if (StringUtils.isEmpty(name)) {
			return new ArrayList<>();
		}
		List<String> names = medicineDao.findByCName(name);
		return !CollectionUtils.isEmpty(names) ? names : new ArrayList<>();
	}

	@Override
	public MedicineResponsePojo getMedicineDetails(String cUniqueId) {
		return MedicineConvertor.getResponse(medicineDao.findById(cUniqueId).orElse(null));
	}

}
