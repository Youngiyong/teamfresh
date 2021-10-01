package com.example.teamfresh.voc.controller;


import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.dto.VocDto;
import com.example.teamfresh.voc.service.VocService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("vocs")
public class VocController {

    private VocService vocService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createVoc(VocDto.RequestVoc payload){
        VocEntity voc = new VocEntity();
        voc.setDeliveryId(payload.getDeliveryId());
        voc.setReason(payload.getReason());
        
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
