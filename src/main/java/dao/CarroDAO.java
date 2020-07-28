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

    final String INSERT_CARRO = "INSERT INTO Carro(idCarro, nome, placa, marca, ano, kmAtual, " +
        "statusPatrimonio, statusLocacao, numeroMaximoDiasLocacao, QRCode, idCategoria)" +
        " VALUES(?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)";

    public boolean save(Carro carro);

    final String FIND_BY_ID_CARRO = "SELECT idCategoria"
        + "FROM Categoria "
        + "WHERE idCategoria = ?";

    public Carro findByIdCarro(int idCarro);
}
