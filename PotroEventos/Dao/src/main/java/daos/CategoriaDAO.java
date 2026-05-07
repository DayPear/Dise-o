/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Categoria;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.ICategoriaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<Categoria> coleccionCategorias;
    private static CategoriaDAO instance;

    private CategoriaDAO() {
        this.coleccionCategorias = ConexionMongo.obtenerBaseDatos().getCollection("categorias", Categoria.class);
    }

    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }

    @Override
    public List<Categoria> consultarCategorias() throws PersistenciaException {
        try {

            return this.coleccionCategorias.find().into(new ArrayList<>());

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener las categorías");
        }
    }

    @Override
    public Categoria registrarCategoria(Categoria categoria) throws PersistenciaException {
        if (categoria == null) {
            throw new PersistenciaException("La categoria no puede ser null");
        }

        try {
            InsertOneResult resultado = coleccionCategorias.insertOne(categoria);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al registrar la categoria");
            }

            categoria.setId(resultado.getInsertedId().asObjectId().getValue().toHexString());

            return categoria;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al intentar registrar la categoria");
        }
    }

}
