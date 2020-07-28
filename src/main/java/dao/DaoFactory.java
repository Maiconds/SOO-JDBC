package dao;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class DaoFactory {

    private DaoFactory(){
    }

    public static CarroDAO getCarroDAO(){
        return new CarroDAOImpl();
    }
}
