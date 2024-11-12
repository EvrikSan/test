package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.ElectroItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectroItemRepository extends JpaRepository<ElectroItem, Long> {
}
