package com.example.teamfresh.voc.service;

import com.example.teamfresh.voc.domain.entity.VocClaimEntity;
import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.domain.entity.VocReparationEntity;
import com.example.teamfresh.voc.domain.repository.VocClaimRepository;
import com.example.teamfresh.voc.domain.repository.VocReparationRepository;
import com.example.teamfresh.voc.domain.repository.VocRepository;
import com.example.teamfresh.voc.dto.VocDto;
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
    public Long save(VocDto.RequestVoc payload){
        VocEntity voc = new VocEntity();
        voc.setDeliveryId(payload.getDeliveryId());
        voc.setReason(payload.getReason());
        voc.setType(payload.getType());

        vocRepository.save(voc);
        VocReparationEntity vocReparation = new VocReparationEntity();
        vocReparation.setVocId(voc.getId());
        vocReparation.setName(payload.getName());
        vocReparation.setPhone(payload.getPhone());
        vocReparationRepository.save(vocReparation);
        return voc.getId();
    }

    @Transactional
    public Long saveClaim(VocDto.RequestVocClaim payload){
        VocEntity voc = vocRepository.findById(payload.getVocId()).get();

        VocClaimEntity vocClaim = new VocClaimEntity();
        vocClaim.setVocId(voc.getId());
        vocClaim.setClaimPrice(payload.getClaimPrice());
        vocClaimRepository.save(vocClaim);
        return vocClaim.getVocId();
    }

    @Transactional
    public VocEntity get(Long id){
        return vocRepository.findById(id).get();
    }
}
