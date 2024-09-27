package com.example.Rueditas_backend.controller;

import com.example.Rueditas_backend.dto.RueditasRequestDTO;
import com.example.Rueditas_backend.dto.RueditasResponseDTO;
import com.example.Rueditas_backend.service.Impl.RueditasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/buscar")

public class RueditaController{
    @Autowired
    private RueditasServiceImpl rueditaServiceImpl;

    @PostMapping("/placa")
    public RueditasResponseDTO buscarPlaca(@RequestBody RueditasRequestDTO RueditasRequestDTO) {

        try {
            String[] datosPlaca = rueditaServiceImpl.buscarPlaca(RueditasRequestDTO);

            if (datosPlaca == null) {
                return new RueditasResponseDTO("03",  "Placa no encontrada", "", "", 0, 0, "");
            }

            return new RueditasResponseDTO("00", "", datosPlaca[0], datosPlaca[1], Integer.parseInt(datosPlaca[2]), Integer.parseInt(datosPlaca[3]), datosPlaca[4]);

        } catch (Exception e) {
            return new RueditasResponseDTO("02", " Ocurrio un problema", "", "", 0, 0, "");
        }
    }
}

