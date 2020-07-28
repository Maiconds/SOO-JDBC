import Generator.InstanceGenerator;
import model.Carro;
import service.CarroService;
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
//        final String username = "user5";

        CarroService carroService = ServiceFactory.getCarroService();

        Carro c = carroService.findByIdCarro(idCarro);

        if (c == null) {

            Carro carro = InstanceGenerator.getCarro(idCarro);

            // Apenas exibe os dados do objeto gerado
            System.out.println(carro);

            /*
             * Persiste o objeto no banco de dados
             */
            boolean result = carroService.save(carro);
            System.out.println("Result: " + result);
        } else{
            System.out.println("Carro encontrado! Não faça nada!");
        }

    }
}
