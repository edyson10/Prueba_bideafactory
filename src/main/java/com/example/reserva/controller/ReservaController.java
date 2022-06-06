package com.example.reserva.controller;

import com.example.reserva.DTO.Mensaje;
import com.example.reserva.entity.Reserva;
import com.example.reserva.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity crearReserva(@RequestBody Reserva reserva){

        try {
            if (reserva == null) {
                return new ResponseEntity("No hay datos", HttpStatus.BAD_REQUEST);
            }

            if (reserva.getHouseId() == null || reserva.getHouseId().isEmpty() || reserva.getHouseId().equals("")) {
                return new ResponseEntity(new Mensaje(HttpStatus.BAD_REQUEST.value(), "Bad request", "required property 'houseId'"), HttpStatus.BAD_REQUEST);
            }

            if (reserva.getDiscountCode() == null || reserva.getDiscountCode().isEmpty() || reserva.getDiscountCode().equals("")){
                return new ResponseEntity(new Mensaje(HttpStatus.CONFLICT.value(), "Conflict", "invalid discount"), HttpStatus.CONFLICT);
            }

            Reserva book = new Reserva(reserva.getId(), reserva.getName(), reserva.getLastname(), reserva.getAge(), reserva.getPhoneNumber(),
                    reserva.getStartDate(), reserva.getEndDate(), reserva.getHouseId(), reserva.getDiscountCode());

            Mensaje mensaje = new Mensaje(HttpStatus.OK.value(), "Book Accepted");
            reservaService.saveReserva(book);
            return new ResponseEntity(mensaje, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
