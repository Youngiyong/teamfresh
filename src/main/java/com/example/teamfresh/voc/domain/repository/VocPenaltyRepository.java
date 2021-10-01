package com.example.teamfresh.voc.domain.repository;

import com.example.teamfresh.voc.domain.entity.VocClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocClaimRepository extends JpaRepository<VocClaimEntity, Long> {
}
