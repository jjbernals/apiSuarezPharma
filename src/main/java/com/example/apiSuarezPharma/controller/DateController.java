package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.Date;
import com.example.apiSuarezPharma.service.DateServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date")
public class DateController {
    private final DateServiceImpl dateService;

    public DateController(DateServiceImpl dateService) {
        this.dateService = dateService;
    }

    @GetMapping
    public List<Date> getAllDates () { return dateService.getAllDates(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDate (@RequestBody Date date) { dateService.createDate(date); }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDate (@RequestBody Date date, @PathVariable Long id) { dateService.updateDate(id, date); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDate (@PathVariable Long id) { dateService.deleteDate(id); }
}
