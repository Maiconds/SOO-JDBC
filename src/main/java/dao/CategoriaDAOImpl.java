package dao;

import model.Categoria;
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
public class CategoriaDAOImpl implements CategoriaDAO {

    public CategoriaDAOImpl() {
    }

    @Override
    public boolean save(Categoria categoria) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idCategoria = -1;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                /*
                 * Setando a conexão para falso, que representa o start da transação
                 */
                con.setAutoCommit(false);

                /*
                 * Essa instrução recebe o comando SQL (INSERT_PESSOA) e uma flag
                 * (PreparedStatement.RETURN_GENERATED_KEYS) que determina que a chave
                 * da entidade perisistida deve ser retornada
                 */
                pstm = con.prepareStatement(INSERT_CATEGORIA, PreparedStatement.RETURN_GENERATED_KEYS);

                /*
                 * O valor do objeto fisica é atribuído ao primeiro parâmetro do comando SQL
                 */
                pstm.setInt(1, categoria.getIdCategoria());

                /*
                 * Esse comando executa a instrução SQL
                 */
                pstm.executeUpdate();

                /*
                 * Esse comando retorna um objeto do tipo ResultSet contendo a chave gerada.
                 */
                res = pstm.getGeneratedKeys();

                /**
                 * Recuperação da chave gerada
                 */
                while (res.next()) {
                    idCategoria = res.getLong(1);
                }

                /*
                 * O trecho abaixo permite a inserção de uma classe Fisica na tabela Fisica
                 */
                pstm = con.prepareStatement(INSERT_CATEGORIA);
                pstm.setInt(1, categoria.getIdCategoria());
                pstm.executeUpdate();

                /*
                 * Executando o commit da transação.
                 */
                con.commit();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return b;
    }

    @Override
    public Categoria findByIdCategoria(int idCategoria) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Categoria categoria = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_ID);
                pstm.setInt(1, idCategoria);
                res = pstm.executeQuery();

                /**
                 * Recuperação o objeto
                 */
                while (res.next()) {
                    categoria = new Categoria();
                    categoria.setDescricaoCategoria(res.getString(1));
                    categoria.setIdCategoria(res.getInt(2));
                    categoria.setPrecoDiario(res.getFloat(3));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return categoria;
    }
}
