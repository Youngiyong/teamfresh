package com.example.teamfresh.voc.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voc_reparation")
@Getter
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


//    public VocReparationEntity(String name, String phone, String reason) {
//        this.name = name;
//        this.phone = phone;
//        this.reason = reason;
//    }
}
