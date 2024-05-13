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

    @GetMapping("/{id}")
    public List<Servicio> getServicesByIdCategory (@PathVariable Long id) { return servicioService.getServicesByIdCategory(id); }

    @GetMapping("/tittle/{search}")
    public List<Servicio> getServicesByTittle (@PathVariable String search) { return servicioService.getServicesByTittle(search); }

    @GetMapping("/category/{search}")
    public List<Servicio> getServicesByCategory (@PathVariable String search) { return servicioService.getServicesByCategory(search); }

    @GetMapping("/department/{search}")
    public List<Servicio> getServicesByDepartment (@PathVariable String search) { return servicioService.getServicesByDepartment(search); }

    @GetMapping("/department/{search}/{category}")
    public List<Servicio> getServicesByDepartmentAndCategory (@PathVariable String search, @PathVariable String category) { return servicioService.getServicesByDepartmentAndCategory(search, category); }

    @GetMapping("/department-tittle/{search}/{tittle}")
    public List<Servicio> getServicesByDepartmentAndTittle (@PathVariable String search, @PathVariable String tittle) { return servicioService.getServicesByDepartmentAndTittle(search, tittle); }

    @GetMapping("/city-tittle/{search}/{tittle}")
    public List<Servicio> getServicesByCityAndTittle (@PathVariable String search, @PathVariable String tittle) { return servicioService.getServicesByCityAndTittle(search, tittle); }

    @GetMapping("/city/{search}")
    public List<Servicio> getServicesByCity (@PathVariable String search) { return servicioService.getServicesByCity(search); }

    @GetMapping("/city/{search}/{category}")
    public List<Servicio> getServicesByCityAndCategory (@PathVariable String search, @PathVariable String category) { return servicioService.getServicesByCityAndCategory(search, category); }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAService (@RequestBody Servicio servicio, @PathVariable Long id) { servicioService.createServicio(servicio, id); }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServiceById(@PathVariable Long id){ servicioService.deleteAService(id); }
}
