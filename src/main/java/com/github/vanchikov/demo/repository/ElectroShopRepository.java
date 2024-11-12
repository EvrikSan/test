package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.ElectroShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectroShopRepository extends JpaRepository<ElectroShop, ElectroShop.ElectroShopId> {
    ElectroShop findByElectroItemIdAndShopId(long electroitemid, long shopid);
}
