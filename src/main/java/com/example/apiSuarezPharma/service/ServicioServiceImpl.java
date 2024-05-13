package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Category;
import com.example.apiSuarezPharma.entity.Servicio;
import com.example.apiSuarezPharma.exception.CategoryNotFoundException;
import com.example.apiSuarezPharma.repository.CategoryRepository;
import com.example.apiSuarezPharma.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService{
    private final ServicioRepository servicioRepository;
    private final CategoryRepository categoryRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository, CategoryRepository categoryRepository) {
        this.servicioRepository = servicioRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createServicio(Servicio servicio, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("La categoria seleccionada no existe"));
        servicio.setIdCategory(category);
        servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public List<Servicio> getServicesByTittle(String search) {
        return servicioRepository.getServiceByTittle(search);
    }

    @Override
    public void deleteAService(Long id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public List<Servicio> getServicesByDepartment(String search) {
        return servicioRepository.getServiceByDepartment(search);
    }

    @Override
    public List<Servicio> getServicesByCategory(String search) {
        return servicioRepository.getServiceByCategory(search);
    }

    @Override
    public List<Servicio> getServicesByCity(String search) {
        return servicioRepository.getServiceByCity(search);
    }

    @Override
    public List<Servicio> getServicesByDepartmentAndCategory(String search, String category) {
        return servicioRepository.getServiceByDepartmentAndCategory(search, category);
    }

    @Override
    public List<Servicio> getServicesByCityAndCategory(String search, String category) {
        return servicioRepository.getServiceByCityAndCategory(search,category);
    }

    @Override
    public List<Servicio> getServicesByDepartmentAndTittle(String search, String tittle) {
        return servicioRepository.getServiceByDepartmentAndTittle(search, tittle);
    }

    @Override
    public List<Servicio> getServicesByCityAndTittle(String search, String tittle) {
        return servicioRepository.getServiceByCityAndTittle(search, tittle);
    }

    @Override
    public List<Servicio> getServicesByIdCategory(Long id) {
        return servicioRepository.getServiceByIdCategory(id);
    }
}
