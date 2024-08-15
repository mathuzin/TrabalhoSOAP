package org.example;

public class Usuario {
    private int id;
    private String nome;
    private int telfone;
    private String endereco;
    private Cachorro listaCachorro;
    private Servico listaServico;

    public Usuario(int id, String nome, int telfone, String endereco, Cachorro listaCachorro, Servico listaServico) {
        this.id = id;
        this.nome = nome;
        this.telfone = telfone;
        this.endereco = endereco;
        this.listaCachorro = listaCachorro;
        this.listaServico = listaServico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelfone() {
        return telfone;
    }

    public void setTelfone(int telfone) {
        this.telfone = telfone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cachorro getListaCachorro() {
        return listaCachorro;
    }

    public void setListaCachorro(Cachorro listaCachorro) {
        this.listaCachorro = listaCachorro;
    }

    public Servico getListaServico() {
        return listaServico;
    }

    public void setListaServico(Servico listaServico) {
        this.listaServico = listaServico;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telfone=" + telfone +
                ", endereco='" + endereco + '\'' +
                ", listaCachorro=" + listaCachorro +
                ", listaServico=" + listaServico +
                '}';
    }
}