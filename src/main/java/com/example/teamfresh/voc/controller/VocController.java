package com.example.teamfresh.voc.controller;


import com.example.teamfresh.voc.common.VocStatus;
import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.dto.VocDto;
import com.example.teamfresh.voc.service.VocService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RequestMapping("vocs")
@RestController
public class VocController {

    @Autowired
    private VocService vocService;

    @Operation(description = "postVoc")
    @PostMapping("")
    public VocDto.ResponseCreate postVoc(@RequestBody @Valid final VocDto.RequestVoc payload){
        return new VocDto.ResponseCreate(vocService.save(payload),201, "success");
    }

    @Operation(description = "postVocReparation")
    @PostMapping("/reparations")
    public VocDto.ResponseCreate postVocReparation(@RequestBody @Valid final VocDto.RequestVocReparation payload){
        return new VocDto.ResponseCreate(vocService.saveReparation(payload),201, "success");
    }

    @Operation(description = "postVocPenalty")
    @PostMapping("/penalties")
    public VocDto.ResponseCreate postVocClaim(@RequestBody @Valid final VocDto.RequestVocPenalty payload){
        return new VocDto.ResponseCreate(vocService.savePenalty(payload),201, "success");
    }

    @Operation(description = "findAllVoc")
    @GetMapping("/")
    public VocDto.ResponseListVoc findAllVoc(){
        return new VocDto.ResponseListVoc(vocService.findAllVoc());
    }

    @Operation(description = "findAllVocReparation")
    @GetMapping("/reparations")
    public VocDto.ResponseListVocReparation findAllVocReparation(){
        return new VocDto.ResponseListVocReparation(vocService.findAllVocReparation());
    }

    @Operation(description = "findByVocId")
    @GetMapping("/{id}")
    public VocDto.ResponseVoc findByVocId(@PathVariable final long id){
        return new VocDto.ResponseVoc(vocService.findVocById(id));
    }

    @Operation(description = "findVocReparationById")
    @GetMapping("/{vocId}/reparations/{id}")
    public VocDto.ResponseVocReparation findVocReparationById(@PathVariable final long vocId, @PathVariable final long id){
        return new VocDto.ResponseVocReparation(vocService.findVocReparationById(id));
    }

    @Operation(description = "updateVocPenalty")
    @PutMapping("/{vocId}/penalties/{id}")
    public VocDto.ResponseUpdate updateVocPenalty(@PathVariable final long vocId, @PathVariable final long id, @RequestBody @Valid final VocDto.RequestVocPenaltyUpdate payload){
        return new VocDto.ResponseUpdate(vocService.updateVocPenalty(id, vocId, payload), 200, "Success");
    }

}
