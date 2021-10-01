package com.example.teamfresh.voc.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voc_claim")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VocClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="voc_id" , insertable = false , updatable = false)
    private Long vocId;

    @Column(name = "claim_price", nullable = false)
    private int claimPrice;

    @Column(name = "is_sign", nullable = false)
    private int isSign;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public VocClaimEntity(Long vocId, int claimPrice) {
        this.vocId = vocId;
        this.claimPrice = claimPrice;
    }
}
