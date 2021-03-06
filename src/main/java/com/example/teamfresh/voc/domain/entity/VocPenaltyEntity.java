package com.example.teamfresh.voc.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voc_penalty")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VocPenaltyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="voc_id" , insertable = false)
    private Long vocId;

    @Column(name = "is_verify", nullable = false, insertable = false)
    private int isVerify;

    @Column(name = "is_sign", nullable = false, insertable = false)
    private int isSign;

    @Column(name = "answer", length = 255, insertable = false)
    private String answer;

    @CreatedDate
    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

}
