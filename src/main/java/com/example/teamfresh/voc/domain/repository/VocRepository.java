package com.example.teamfresh.voc.domain.repository;

import com.example.teamfresh.voc.domain.entity.VocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VocRepository extends JpaRepository<VocEntity, Long>{
}
