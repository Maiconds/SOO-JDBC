package service;

import model.Carro;
import model.Categoria;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public interface CategoriaService {

    boolean save(Categoria entity);

    Categoria findByIdCategoria(int idCategoria);

}
