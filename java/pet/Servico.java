package pet;

import java.util.ArrayList;

public class Servico {
    private String id;
    private String nome;
    private String data;
    private String observacao;
    private ArrayList<Cachorro> listaCachorros;

    public Servico() {
    }

    public Servico(String id, String nome, String data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.observacao = "";
        this.listaCachorros = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "pet.Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data;
    }

    public void cadastrarCachorro(Cachorro cachorro) {
        listaCachorros.add(cachorro);
    }

}