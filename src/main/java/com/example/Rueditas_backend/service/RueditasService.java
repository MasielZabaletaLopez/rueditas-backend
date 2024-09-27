package com.example.Rueditas_backend.service;

import com.example.Rueditas_backend.dto.RueditasRequestDTO;

import java.io.IOException;

public interface RueditasService {

    String[] buscarPlaca(RueditasRequestDTO searchRequestDTO) throws IOException;
}
