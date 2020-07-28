package dao;

import model.Carro;
import model.Categoria;
import service.CategoriaService;
import service.CategoriaServiceImpl;
import utils.FabricaConexao;

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
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idCarro = -1;

        con = FabricaConexao.getConexao();

        if (con != null){
            try {
                /*
                 * Setando a conexão para falso, que representa o start da transação
                 */
                con.setAutoCommit(false);

                /*
                 * Essa instrução recebe o comando SQL (INSERT_CARRO) e uma flag
                 * (PreparedStatement.RETURN_GENERATED_KEYS) que determina que a chave
                 * da entidade persistida deve ser retornada
                 */
                pstm = con.prepareStatement(INSERT_CARRO, PreparedStatement.RETURN_GENERATED_KEYS);

                /*
                 * Esse comando retorna um objeto do tipo ResultSet contendo a chave gerada.
                 */
                res = pstm.getGeneratedKeys();

                /**
                 * Recuperação da chave gerada
                 */
                while (res.next()) {
                    idCarro = res.getLong(1);
                }
                /*
                 * O trecho abaixo permite a inserção de uma classe Carro na tabela Carro
                 */

                pstm = con.prepareStatement(INSERT_CARRO);
                pstm.setString(1, carro.getPlaca());
                pstm.setString(2, carro.getNome());
                pstm.setInt(3, carro.getAno());
                pstm.setFloat(4, carro.getKmAtual());
                pstm.setBoolean(5, carro.getStatusPatrimonio());
                pstm.setBoolean(6, carro.getStatusLocacao());
                pstm.setInt(7, carro.getNumeroMaximoDiasLocacao());
                pstm.setString(8, carro.getMarca());
                pstm.setString(9, carro.getQRCode());
                pstm.setObject(10, carro.getIdCategoria().getIdCategoria());
                pstm.executeUpdate();

                /*
                 * Executando o commit da transação.
                 */
                con.commit();
                b = true;

            } catch (SQLException ex){
                System.out.println("Message: " + ex);
            }
        }

        return b;
    }

    @Override
    public Carro findByIdCarro(int idCarro) {
        return null;
    }
}
