package dao;

import model.Carro;
import model.Categoria;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public interface CarroDAO {

    final String INSERT_CARRO = "INSERT INTO Carro(placa, nome, ano, quilometragem, " +
        "patrimonio, status, maxDiasLocacao, marca, qrCode, Categoria_idCategoria)" +
        " VALUES(?, ?, ?, ?, ? , ?, ?, ?, ?, ?)";

    public boolean save(Carro carro);

    final String FIND_BY_ID_CARRO = "SELECT idCategoria"
        + "FROM Categoria "
        + "WHERE idCategoria = ?";

    public Carro findByIdCarro(int idCarro);
}
