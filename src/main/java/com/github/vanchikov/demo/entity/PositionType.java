package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Positiontype")
@NoArgsConstructor
@Builder
public class PositionType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_type_sequence_generator")
    @SequenceGenerator(name = "position_type_sequence_generator", sequenceName = "positiontype_sequence", allocationSize = 1)
    private Long id;
    private String job_name;
}
