/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import Entitys.ENUMS.CategoriaEvento;

/**
 *
 * @author maria
 */
public class Categoria {

    private Long id;
    private CategoriaEvento nombre;
    private String urlImagen;

    public Categoria() {
    }

    public Categoria(Long id, CategoriaEvento nombre, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaEvento getNombre() {
        return nombre;
    }

    public void setNombre(CategoriaEvento nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
