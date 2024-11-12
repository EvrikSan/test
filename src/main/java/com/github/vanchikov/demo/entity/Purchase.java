package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "Purchase")
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_sequence_generator")
    @SequenceGenerator(name = "purchase_sequence_generator", sequenceName = "purchase_sequence", allocationSize = 1)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "electroid")
    private ElectroItem electroItem;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeid")
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopid")
    private Shop shop;
    @Column(name = "purchasedate")
    private Date purchaseDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeid")
    private PurchaseType purchaseType;
}
