package com.medicine.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicine.api.entities.MedicineEntity;

@Repository
public interface MedicineDao extends JpaRepository<MedicineEntity, String> {
@Query("select m.cName from MedicineEntity m where m.cName like %:name%")
List<String>findByCName(String name);
}
