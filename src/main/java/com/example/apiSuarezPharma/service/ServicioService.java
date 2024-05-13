package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Servicio;

import java.util.List;

public interface ServicioService {
    void createServicio (Servicio servicio, Long id);
    List<Servicio> getAllServicios ();
    List<Servicio> getServicesByTittle (String search);
    void deleteAService (Long id);
    List<Servicio> getServicesByDepartment (String search);
    List<Servicio> getServicesByCategory (String search);
    List<Servicio> getServicesByCity (String search);
    List<Servicio> getServicesByDepartmentAndCategory (String search, String category);
    List<Servicio> getServicesByCityAndCategory (String search, String category);
    List<Servicio> getServicesByDepartmentAndTittle(String search, String tittle);
    List<Servicio> getServicesByCityAndTittle(String search, String tittle);
    List<Servicio> getServicesByIdCategory(Long id);

}
