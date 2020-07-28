package service;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class ServiceFactory {

    private ServiceFactory(){

    }

    public static CarroService getCarroService(){
        return new CarroServiceImpl();
    }

}
