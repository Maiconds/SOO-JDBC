package Generator;

import model.Carro;
import model.Categoria;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class InstanceGenerator {

    private InstanceGenerator() {

    }

    public static Carro getCarro(int idCarro) {
        Carro carro = new Carro();

        carro.setIdCarro(idCarro);
        carro.setAno(2010);
        carro.setNome("Palio");

        Categoria categoria = new Categoria();

        categoria.setPrecoDiario(10);
        categoria.setIdCategoria(1);
        categoria.setDescricaoCategoria("Categoria genérica");
        return carro;
    }

    public static Carro getCarro(int idCarro, Categoria categoria) {
        Carro carro = new Carro();

        carro.setIdCarro(idCarro);
        carro.setAno(2010);
        carro.setNome("Palio");
        carro.setIdCategoria(categoria);

        return carro;
    }
}
