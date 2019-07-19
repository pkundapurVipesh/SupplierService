package com.vippar.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vippar.persistance.dto.Supplier;
@Repository

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
