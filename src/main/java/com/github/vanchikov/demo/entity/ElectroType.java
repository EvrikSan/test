package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Electrotype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectroType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electro_type_sequence_generator")
    @SequenceGenerator(name = "electro_type_sequence_generator", sequenceName = "electrotype_sequence", allocationSize = 1)
    private long id;
    private String name;
}
