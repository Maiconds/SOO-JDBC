package model;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class Categoria {

    public int idCategoria;


    public String nome;
    public String descricaoCategoria;
    public float precoDiario;

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public void setPrecoDiario(float precoDiario) {
        this.precoDiario = precoDiario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public float getPrecoDiario() {
        return precoDiario;
    }

    @Override
    public String toString() {
        return "Categoria{" +
            "idCategoria=" + idCategoria +
            ", nome=" + nome +
            ", descricaoCategoria='" + descricaoCategoria + '\'' +
            ", precoDiario=" + precoDiario +
            '}';
    }
}
