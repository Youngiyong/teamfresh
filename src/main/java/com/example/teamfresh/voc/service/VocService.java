package com.example.teamfresh.voc.service;

import com.example.teamfresh.voc.domain.repository.VocClaimRepository;
import com.example.teamfresh.voc.domain.repository.VocReparationRepository;
import com.example.teamfresh.voc.domain.repository.VocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocService {

    @Autowired
    VocRepository vocRepository;

    @Autowired
    VocClaimRepository vocClaimRepository;

    @Autowired
    VocReparationRepository vocReparationRepository;
}
