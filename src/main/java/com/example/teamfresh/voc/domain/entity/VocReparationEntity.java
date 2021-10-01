package com.example.teamfresh.voc.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voc_reparation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VocReparationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="voc_id" , insertable = false , updatable = false)
    private Long vocId;

    @Column(name = "name", nullable = true, length = 50)
    private String name;

    @Column(name = "phone", nullable = true, length = 20)
    private String phone;

    @Column(name = "reason", nullable = true, length = 255)
    private String reason;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

}
