package com.medicine.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.api.entities.MedicineOrderMappingEntity;

@Repository
public interface MedicineOrderMappingDao extends JpaRepository<MedicineOrderMappingEntity, Long> {

}
