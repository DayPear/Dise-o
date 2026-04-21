/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author aaron
 */
public class CategoriaDTO {

    private Long idCategoria;

    private String UrlImagen;

    private String nombreCategoria;

    public CategoriaDTO(Long idCategoria, String UrlImagen, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.UrlImagen = UrlImagen;
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaDTO(String UrlImagen, String nombreCategoria) {
        this.UrlImagen = UrlImagen;
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaDTO() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getUrlImagen() {
        return UrlImagen;
    }

    public void setUrlImagen(String UrlImagen) {
        this.UrlImagen = UrlImagen;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

}
