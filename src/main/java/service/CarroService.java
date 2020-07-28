package service;

import model.Carro;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public interface CarroService {

    boolean save(Carro entity);

    Carro findByIdCarro(int idCarro);

}
