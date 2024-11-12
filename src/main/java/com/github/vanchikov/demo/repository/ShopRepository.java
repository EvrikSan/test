package com.github.vanchikov.demo.repository;

import com.github.vanchikov.demo.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
/*описать методы для работы с базой данных
часть наследуется из JpaРепозитория

 */