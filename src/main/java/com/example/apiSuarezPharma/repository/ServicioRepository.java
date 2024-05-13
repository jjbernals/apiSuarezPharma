package com.example.apiSuarezPharma.repository;

import com.example.apiSuarezPharma.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    @Query(value = "SELECT p FROM Servicio p WHERE p.idCategory.name LIKE %:search%")
    List<Servicio> getServiceByCategory(String search);

    @Query(value = "SELECT p FROM Servicio p WHERE p.idCategory.id =:id")
    List<Servicio> getServiceByIdCategory(Long id);

    @Query(value = "SELECT p FROM Servicio p WHERE p.tittle LIKE %:search%")
    List<Servicio> getServiceByTittle(String search);

    @Query(value = "SELECT p FROM Servicio p WHERE p.department LIKE %:search%")
    List<Servicio> getServiceByDepartment(String search);

    @Query(value = "SELECT p FROM Servicio p WHERE p.city LIKE %:search%")
    List<Servicio> getServiceByCity(String search);

    @Query(value = "SELECT p FROM Servicio p WHERE p.city LIKE %:search% AND p.idCategory.name LIKE %:category%")
    List<Servicio> getServiceByCityAndCategory(String search, String category);

    @Query(value = "SELECT p FROM Servicio p WHERE p.department LIKE %:search% AND p.idCategory.name LIKE %:category%")
    List<Servicio> getServiceByDepartmentAndCategory(String search, String category);

    @Query(value = "SELECT p FROM Servicio p WHERE p.department LIKE %:search% AND p.tittle LIKE %:tittle%")
    List<Servicio> getServiceByDepartmentAndTittle(String search, String tittle);
    @Query(value = "SELECT p FROM Servicio p WHERE p.city LIKE %:search% AND p.tittle LIKE %:tittle%")
    List<Servicio> getServiceByCityAndTittle(String search, String tittle);
}

