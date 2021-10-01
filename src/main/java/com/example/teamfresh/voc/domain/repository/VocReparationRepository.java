package com.example.teamfresh.voc.domain.repository;

import com.example.teamfresh.voc.domain.entity.VocReparationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VocReparationRepository extends JpaRepository<VocReparationEntity, Long> {

}
