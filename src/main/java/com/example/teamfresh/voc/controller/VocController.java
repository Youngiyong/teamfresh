package com.example.teamfresh.voc.controller;


import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.dto.VocDto;
import com.example.teamfresh.voc.service.VocService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class VocController {

    @Autowired
    private VocService vocService;

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @PostMapping("/vocs/")
    public VocDto.Response createVoc(VocDto.RequestVoc payload){
        VocEntity voc = new VocEntity();
        voc.setDeliveryId(payload.getDeliveryId());
        voc.setReason(payload.getReason());

        vocService.save(voc);
        return new VocDto.Response(voc,200, "success");
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
