package org.example;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private int telfone;
    private String endereco;
    private ArrayList<Cachorro> listaCachorro;
    private ArrayList<Servico> listaServico;

    public Usuario(int id, String nome, int telfone, String endereco, ArrayList<Cachorro> listaCachorro, ArrayList<Servico> listaServico) {
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

    public ArrayList<Cachorro> getListaCachorro() {
        return listaCachorro;
    }

    public void setListaCachorro(ArrayList<Cachorro> listaCachorro) {
        this.listaCachorro = listaCachorro;
    }

    public ArrayList<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }
}