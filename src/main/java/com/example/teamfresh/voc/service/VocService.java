package com.example.teamfresh.voc.service;

import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.domain.repository.VocClaimRepository;
import com.example.teamfresh.voc.domain.repository.VocReparationRepository;
import com.example.teamfresh.voc.domain.repository.VocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VocService {

    @Autowired
    VocRepository vocRepository;

    @Autowired
    VocClaimRepository vocClaimRepository;

    @Autowired
    VocReparationRepository vocReparationRepository;

    @Transactional
    public VocEntity save(VocEntity v){
        return vocRepository.save(v);
    }
}
