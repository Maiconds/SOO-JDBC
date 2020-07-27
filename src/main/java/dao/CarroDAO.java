package dao;

import model.Carro;

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

}
