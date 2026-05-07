package Entitys;

import Entitys.ENUMS.CategoriaEvento;

/**
 *
 * @author maria
 */
public class Categoria {

    private String idCategoria;
    private CategoriaEvento nombre;
    private String urlImagen;

    public Categoria() {
    }

    public Categoria(String idCategoria, CategoriaEvento nombre, String urlImagen) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public String getId() {
        return idCategoria;
    }

    public void setId(String id) {
        this.idCategoria = id;
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
