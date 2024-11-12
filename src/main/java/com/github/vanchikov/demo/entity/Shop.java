package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Shops")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_sequence_generator")
    @SequenceGenerator(name = "shop_sequence_generator", sequenceName = "shop_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "electroshop",
        joinColumns = {@JoinColumn(name = "shopid")},
        inverseJoinColumns = {@JoinColumn(name = "electroitemid")},
        catalog = {@Column int count})
    List<ElectroItem> electroItems;*/
}
