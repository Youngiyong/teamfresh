package com.example.teamfresh.voc.service;

import com.example.teamfresh.voc.common.VocStatus;
import com.example.teamfresh.voc.domain.entity.*;
import com.example.teamfresh.voc.domain.repository.VocPenaltyRepository;
import com.example.teamfresh.voc.domain.repository.VocReparationRepository;
import com.example.teamfresh.voc.domain.repository.VocRepository;
import com.example.teamfresh.voc.dto.VocDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class VocService {

    @Autowired
    VocRepository vocRepository;

    @Autowired
    VocPenaltyRepository vocPenaltyRepository;

    @Autowired
    VocReparationRepository vocReparationRepository;

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public Long save(VocDto.RequestVoc payload){
        VocEntity voc = new VocEntity();

        voc.setDeliveryId(payload.getDeliveryId());
        voc.setType(payload.getType());
        voc.setStatus(VocStatus.RECEIVE.getValue());
        voc.setName(payload.getName());
        voc.setDescription(payload.getDescription());

        vocRepository.save(voc);

        return voc.getId();
    }

    @Transactional
    public Long saveReparation(VocDto.RequestVocReparation payload){
        VocEntity voc = vocRepository.findById(payload.getVocId()).get();

        VocReparationEntity vocReparation = new VocReparationEntity();
        vocReparation.setVoc(voc);
        vocReparation.setReason(payload.getReason());
        vocReparation.setName(payload.getName());
        vocReparation.setPenaltyPrice(payload.getPenaltyPrice());

        voc.setIsClaim(1);
        voc.setUpdatedAt(LocalDateTime.now());
        vocReparationRepository.save(vocReparation);
        vocRepository.save(voc);

        return vocReparation.getVoc().getId();
    }

    @Transactional
    public Long savePenalty(VocDto.RequestVocPenalty payload){
        VocEntity voc = vocRepository.findById(payload.getVocId()).get();
        VocPenaltyEntity vocPenalty = new VocPenaltyEntity();

        vocPenalty.setVocId(voc.getId());
        voc.setStatus(VocStatus.PROCEED.getValue());
        voc.setUpdatedAt(LocalDateTime.now());
        vocPenaltyRepository.save(vocPenalty);
        vocRepository.save(voc);
        return vocPenalty.getVocId();

    }

    @Transactional
    public List<VocEntity> findAllVoc(){
        return vocRepository.findAll();
    }

    @Transactional
    public List<VocReparationEntity> findAllVocReparation(){
        return vocReparationRepository.findAll();
    }

    @Transactional
    public VocEntity findVocById(Long id){
        return vocRepository.findById(id).get();
    }

    @Transactional
    public VocReparationEntity findVocReparationById(Long id){
        return vocReparationRepository.findById(id).get();
    }

    @Transactional
    public Long updateVocPenalty(Long id, Long vocId, VocDto.RequestVocPenaltyUpdate payload){
        VocEntity voc = vocRepository.findById(vocId).get();

        VocPenaltyEntity vocPenalty = vocPenaltyRepository.findById(id).get();

//        for (String key: payload.keySet() ) {
//            System.out.println(key + ":" + payload.get(key));
//            switch (key) {
//                case "isSign":
//                    int isSign = Integer.parseInt((String) payload.get(key));
//                    vocPenalty.setIsSign(isSign);
//                    break;
//                case "isVerify":
//                    int isVerify =  Integer.parseInt((String) payload.get(key));
//                    vocPenalty.setIsVerify(isVerify);
//                    break;
//            }
//        }
        vocPenalty.setIsSign(payload.getIsSign());
        vocPenalty.setIsVerify(payload.getIsVerify());
        vocPenalty.setUpdatedAt(LocalDateTime.now());
        vocPenaltyRepository.save(vocPenalty);

        if(vocPenalty.getIsSign()==1&&vocPenalty.getIsVerify()==1){
            voc.setUpdatedAt(LocalDateTime.now());
            voc.setStatus(VocStatus.COMPLETE.getValue());
        }

        return vocPenalty.getId();
    }
}
