package org.example;

import java.util.Date;

public class Servico {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private String horario;
    private Usuario listaUsuarios;
    private String status;
    private int limite;

    public Servico(int id, String nome, String descricao, Date data, String horario, Usuario listaUsuarios, String status, int limite) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
        this.listaUsuarios = listaUsuarios;
        this.status = status;
        this.limite = limite;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Usuario getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Usuario listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", horario='" + horario + '\'' +
                ", listaUsuarios=" + listaUsuarios +
                ", status='" + status + '\'' +
                ", limite=" + limite +
                '}';
    }
}
