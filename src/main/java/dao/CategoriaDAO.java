package dao;

import model.Carro;
import model.Categoria;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public interface CategoriaDAO {

    final String INSERT_CATEGORIA = "INSERT INTO Categoria(idCategoria, nome, descricao, precoDiario) " +
        "VALUES(?, ?, ?, ?)";

    public boolean save(Categoria categoria);

    final String FIND_BY_ID = "SELECT idCategoria"
        + "FROM Categoria "
        + "WHERE idCategoria = ?";

    public Categoria findByIdCategoria(int idCategoria);
}
