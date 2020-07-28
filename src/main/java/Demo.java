import Generator.InstanceGenerator;
import model.Carro;
import model.Categoria;
import service.CarroService;
import service.CategoriaService;
import service.ServiceFactory;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class Demo {

    public static void main(String[] args) {
        final int idCarro = 123;
        final int idCategoria = -1;

        CarroService carroService = ServiceFactory.getCarroService();
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        Carro c1 = carroService.findByIdCarro(idCarro);
        Categoria c2 = categoriaService.findByIdCategoria(idCategoria);


        if (c1 == null && c2 == null) {

            Categoria categoria = InstanceGenerator.getCategoria(idCategoria);
            Carro carro = InstanceGenerator.getCarro(idCarro, categoria);

            // Apenas exibe os dados do objeto gerado
            System.out.println();
            System.out.println(carro);
            System.out.println(categoria);
            System.out.println();

            /*
             * Persiste o objeto no banco de dados
             */
            boolean result1 = categoriaService.save(categoria);
            boolean result2 = carroService.save(carro);
            System.out.println("Insercao categoria: " + result1);
            System.out.println("Insercao carro:     " + result2);
        } else{
            System.out.println("Carro encontrado! Não faça nada!");
        }

    }
}
