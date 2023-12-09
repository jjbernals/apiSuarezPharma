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
}
