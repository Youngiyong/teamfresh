package com.example.teamfresh.voc.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "voc_claim")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class VocClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "voc_id", nullable = false, updatable = false)
    private VocEntity voc;


    @Column(name = "claim_price", nullable = false)
    private int claimPrice;


}
