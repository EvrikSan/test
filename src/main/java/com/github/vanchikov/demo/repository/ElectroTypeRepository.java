package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.ElectroType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectroTypeRepository extends JpaRepository<ElectroType, Long> {
}
