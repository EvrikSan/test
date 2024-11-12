package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionTypeRepository extends JpaRepository<PositionType, Long> {
}
