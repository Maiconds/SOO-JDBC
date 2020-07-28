package dao;

import model.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class CarroDAOImpl implements CarroDAO {
    @Override
    public boolean save(Carro carro) {
        return false;
    }

    @Override
    public Carro findByIdCarro(int idCarro) {
        return null;
    }
}
