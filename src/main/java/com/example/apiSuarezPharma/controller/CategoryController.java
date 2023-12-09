package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.Category;
import com.example.apiSuarezPharma.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAllCategory () { return categoryService.getAllCategory(); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createACategory (@RequestBody Category category) { categoryService.createCategory(category); }
}
