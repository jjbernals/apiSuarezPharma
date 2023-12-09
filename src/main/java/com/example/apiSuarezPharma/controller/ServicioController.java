package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.Servicio;
import com.example.apiSuarezPharma.service.ServicioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    private final ServicioServiceImpl servicioService;

    public ServicioController(ServicioServiceImpl servicioService) {
        this.servicioService = servicioService;
    }
    @GetMapping
    public List<Servicio> getAllServicio () { return servicioService.getAllServicios(); }
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAService (@RequestBody Servicio servicio, @PathVariable Long id) { servicioService.createServicio(servicio, id); }
}
