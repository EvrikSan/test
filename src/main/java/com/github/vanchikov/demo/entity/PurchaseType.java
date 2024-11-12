package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Purchasetype")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_type_sequence_generator")
    @SequenceGenerator(name = "purchase_type_sequence_generator", sequenceName = "purchasetype_sequence", allocationSize = 1)
    private Long id;
    private String name;
}
