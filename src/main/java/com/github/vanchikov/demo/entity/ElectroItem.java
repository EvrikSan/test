package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Electroitem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ElectroItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electro_item_sequence_generator")
    @SequenceGenerator(name = "electro_item_sequence_generator", sequenceName = "electroitem_sequence", allocationSize = 1)
    private long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etypeid")
    private ElectroType electroType;
    private long price;
    private int count;
    private boolean archive;
    private String description;
}
