package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.Shop;
import com.github.vanchikov.demo.model.ShopDTO;
import com.github.vanchikov.demo.repository.ElectroShopRepository;
import com.github.vanchikov.demo.repository.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;
    private ElectroShopRepository electroShopRepository;

    @Transactional
    public void saveShop(ShopDTO shopDTO) {
        shopRepository.save(
                Shop.builder()
                        .name(shopDTO.getName())
                        .address(shopDTO.getAddress())
                        .build()
        );
    }


    public ShopDTO getShop(long id) {
        var result = shopRepository.findById(id);
        return new ShopDTO(result.get().getName(), result.get().getAddress());
    }

    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    public int getQuantityByElectroItemIdAndShopId(long itemId, long shopId) {
        var result = electroShopRepository.findByElectroItemIdAndShopId(itemId, shopId);
        return result.getCount();
    }

    public Page<Shop> findAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }
}

/*
здеся бизнес логика
 */
