package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Servicio;

import java.util.List;

public interface ServicioService {
    void createServicio (Servicio servicio, Long id);
    List<Servicio> getAllServicios ();
}
