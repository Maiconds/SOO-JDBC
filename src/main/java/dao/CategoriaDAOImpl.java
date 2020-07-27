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
                pstm.setString(1, fisica.getCpf());
                pstm.setDate(2, new java.sql.Date(fisica.getDataNascimento().getTime()));
                pstm.setLong(3, idPessoa);
                pstm.executeUpdate();

                /*
                 * Abaixo segue as chamadas das outras classes DAO para persistência das
                 * outras classes em entidade no banco de dados.
                 */
                AcessoDAO adao = new AcessoDAOImpl();
                adao.save(con, fisica.getAcesso(), idPessoa);

                ContatoDAO cdao = new ContatoDAOImpl();
                cdao.save(con, fisica.getContato(), idPessoa);

                EnderecoDAO edao = new EnderecoDAOImpl();
                for (Endereco e : fisica.getEndereco()) {
                    edao.save(con, e, idPessoa);
                }

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
    public Categoria findByCpf(int cpf) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Fisica fisica = null;

        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                pstm = con.prepareStatement(FIND_BY_CPF);
                pstm.setString(1, cpf);
                res = pstm.executeQuery();

                /**
                 * Recuperação o objeto
                 */
                while (res.next()) {
                    fisica = new Fisica();
                    fisica.setIdPessoa(res.getLong(1));
                    fisica.setNome(res.getString(2));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return categoria;
    }

}
