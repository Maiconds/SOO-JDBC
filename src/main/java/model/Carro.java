package model;

/**
 * @author Grupo 2
 * Maicon Nei da Silva
 * Guilherme Caes
 * Gustavo Marinho
 */
public class Carro {

    public int idCarro;
    public String nome;
    public String placa;
    public String marca;
    public int ano;
    public float kmAtual;
    public Boolean statusPatrimonio;
    public Boolean statusLocacao;
    public int numeroMaximoDiasLocacao;
    public String QRCode;
    Categoria idCategoria;

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setKmAtual(float kmAtual) {
        this.kmAtual = kmAtual;
    }

    public void setStatusPatrimonio(Boolean statusPatrimonio) {
        this.statusPatrimonio = statusPatrimonio;
    }

    public void setStatusLocacao(Boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public void setNumeroMaximoDiasLocacao(int numeroMaximoDiasLocacao) {
        this.numeroMaximoDiasLocacao = numeroMaximoDiasLocacao;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public String getNome() {
        return nome;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public float getKmAtual() {
        return kmAtual;
    }

    public Boolean getStatusPatrimonio() {
        return statusPatrimonio;
    }

    public Boolean getStatusLocacao() {
        return statusLocacao;
    }

    public int getNumeroMaximoDiasLocacao() {
        return numeroMaximoDiasLocacao;
    }

    public String getQRCode() {
        return QRCode;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    @Override
    public String toString() {
        return "Carro{" +
            "idCarro=" + idCarro +
            ", nome='" + nome + '\'' +
            ", placa='" + placa + '\'' +
            ", marca='" + marca + '\'' +
            ", ano=" + ano +
            ", kmAtual=" + kmAtual +
            ", statusPatrimonio=" + statusPatrimonio +
            ", statusLocacao=" + statusLocacao +
            ", numeroMaximoDiasLocacao=" + numeroMaximoDiasLocacao +
            ", QRCode='" + QRCode + '\'' +
            ", idCategoria=" + idCategoria +
            '}';
    }
}
