package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Date;
import com.example.apiSuarezPharma.exception.DateNotFoundException;
import com.example.apiSuarezPharma.repository.DateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService{
    private final DateRepository dateRepository;

    public DateServiceImpl(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @Override
    public void createDate(Date date) {
        dateRepository.save(date);
    }

    @Override
    public List<Date> getAllDates() {
        return dateRepository.findAll();
    }

    @Override
    public void updateDate(Long id, Date date) {
        Date dateResponse = dateRepository.findById(id).orElseThrow(()->new DateNotFoundException("La cita programada no existe"));
        date.setId(id);
        dateRepository.save(date);
    }

    @Override
    public void deleteDate(Long id) {
        dateRepository.deleteById(id);
    }
}
