package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Date;

import java.util.List;

public interface DateService {
    void createDate (Date date);
    public List<Date> getAllDates();
    void updateDate(Long id, Date date);
    void deleteDate(Long id);
}
