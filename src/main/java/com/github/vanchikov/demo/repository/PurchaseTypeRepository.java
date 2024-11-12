package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTypeRepository extends JpaRepository<PurchaseType, Long> {
}
