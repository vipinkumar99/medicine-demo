package com.medicine.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.api.entities.MedicineOrderEntity;

@Repository
public interface MedicineOrderDao extends JpaRepository<MedicineOrderEntity, Long> {

}
