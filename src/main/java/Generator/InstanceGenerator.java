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

    public  static Categoria getCategoria(int idCategoria){
        Categoria categoria = new Categoria();

        categoria.setIdCategoria(idCategoria);
        categoria.setNome("Popular");
        categoria.setDescricaoCategoria("Categoria Teste");
        categoria.setPrecoDiario(50);

        return categoria;
    }

    public static Carro getCarro(int idCarro) {
        Carro carro = new Carro();

        carro.setAno(2010);
        carro.setNome("Palio");

        Categoria categoria = new Categoria();

        categoria.setPrecoDiario(10);
        categoria.setIdCategoria(-1);
        categoria.setDescricaoCategoria("Categoria genérica");
        carro.setIdCategoria(categoria);

        return carro;
    }

    public static Carro getCarro(int idCarro, Categoria categoria) {
        Carro carro = new Carro();

        carro.setAno(2010);
        carro.setNome("Palio");
        carro.setKmAtual(0);
        carro.setMarca("fiat");
        carro.setNumeroMaximoDiasLocacao(3);
        carro.setPlaca("ABC1111");
        carro.setQRCode("??????");
        carro.setStatusLocacao(false);
        carro.setStatusPatrimonio(true);
        carro.setIdCategoria(categoria);

        return carro;
    }
}
