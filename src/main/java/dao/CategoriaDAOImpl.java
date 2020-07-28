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

                con.setAutoCommit(false);

                pstm = con.prepareStatement(INSERT_CATEGORIA, PreparedStatement.RETURN_GENERATED_KEYS);

                res = pstm.getGeneratedKeys();

                while (res.next()) {
                    idCategoria = res.getLong(1);
                }

                pstm = con.prepareStatement(INSERT_CATEGORIA);
                pstm.setInt(1, (int) idCategoria);
                pstm.setString(2, categoria.getNome());
                pstm.setString(3, categoria.getDescricaoCategoria());
                pstm.setFloat(4, categoria.getPrecoDiario());
                pstm.executeUpdate();

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
