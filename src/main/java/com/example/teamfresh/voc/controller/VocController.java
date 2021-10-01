package com.example.teamfresh.voc.controller;


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


@RequestMapping("vocs")
@RestController
public class VocController {

    @Autowired
    private VocService vocService;

    @Operation(description = "Post Voc")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success Create"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    @PostMapping("")
    public VocDto.CreateResponse CreateVoc(@RequestBody @Valid final VocDto.RequestVoc payload){
        return new VocDto.CreateResponse(vocService.save(payload),201, "success");
    }

    @Operation(description = "Post VocClaim")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success Create"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    @PostMapping("/claims")
    public VocDto.CreateResponse CreateVocClaim(@RequestBody @Valid final VocDto.RequestVocClaim payload){
        return new VocDto.CreateResponse(vocService.saveClaim(payload),201, "success");
    }

    @Operation(description = "Get Voc")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success Create"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    @GetMapping("/{id}")
    public VocDto.ResponseVoc GetVoc(@PathVariable final long id){
        return new VocDto.ResponseVoc(vocService.get(id));
    }
//    @ResponseStatus(value = HttpStatus.OK)
//    public DeliveryDto.Res getDelivery(@PathVariable final long id) {
//        return new DeliveryDto.Res(deliveryService.findById(id));
//    }
//
//
//    @RequestMapping(value = "/{id}/logs", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public DeliveryDto.Res updateDelivery(@PathVariable final long id, @RequestBody DeliveryDto.UpdateReq dto) {
//        return new DeliveryDto.Res(deliveryService.updateStatus(id, dto));
//    }
}
