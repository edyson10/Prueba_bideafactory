package com.example.reserva.controller;

import com.example.reserva.entity.Reserva;
import com.example.reserva.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReserveService reservaService;

    @PostMapping("book")
    public ResponseEntity crearReserva(@RequestBody Reserva reserva){

        try {
            if (reserva == null) {
                return new ResponseEntity("No hay datos", HttpStatus.BAD_REQUEST);
            }

            if (reserva.getHouseId() == null || reserva.getHouseId().isEmpty() || reserva.getHouseId().equals("")) {
                return new ResponseEntity("required property 'houseId'", HttpStatus.BAD_REQUEST);
            }

            if (reserva.getDiscountCode().isEmpty() || reserva.getDiscountCode() == null){
                return new ResponseEntity("invalid discount", HttpStatus.BAD_REQUEST);
            } else {
                reservaService.validateDiscount(reserva.getId(), reserva.getHouseId(), reserva.getDiscountCode());
            }

            Reserva book = new Reserva(reserva.getId(), reserva.getName(), reserva.getLastname(), reserva.getAge(), reserva.getPhoneNumber(),
                    reserva.getStartDate(), reserva.getEndDate(), reserva.getHouseId(), reserva.getDiscountCode());

            reservaService.saveReserva(book);
            return new ResponseEntity("Book Accepted", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
