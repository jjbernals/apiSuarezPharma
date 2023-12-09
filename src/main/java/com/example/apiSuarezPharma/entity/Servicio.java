package com.example.apiSuarezPharma.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String doc;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category idCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }
}
