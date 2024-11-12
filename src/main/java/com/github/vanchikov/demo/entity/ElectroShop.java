package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Electroshop")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@IdClass(ElectroShop.ElectroShopId.class)
public class ElectroShop {
    //@EmbeddedId
    //private ElectroShopId electroShopId;
    @Column(name = "count")
    private int count;
    @Id
    private long shopId;
    @Id
    private long electroItemId;

    @AllArgsConstructor
    @NoArgsConstructor
    public static class ElectroShopId {
        @Column(name = "shopid")
        private long shopId;
        @Column(name = "electroitemid")
        private long electroItemId;
    }
}
