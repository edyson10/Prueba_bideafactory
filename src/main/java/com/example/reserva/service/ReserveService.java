package com.example.reserva.service;

import com.example.reserva.entity.Reserva;
import com.example.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {

    @Autowired
    private ReservaRepository reservaRepository;

    public void saveReserva(Reserva reserva){
        reservaRepository.save(reserva);
    }

    public String validateDiscount(Long userId, String houseId, String discountCode){
        String response = "";

        return "";
    }
}
