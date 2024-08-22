package pet;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
    private String id;
    private String nome;
    private String telefone;
    private String endereco;
    private ArrayList<Cachorro> listaCachorro;
    private ArrayList<Servico> listaServico;

    public Usuario() {
    }

    public Usuario(String nome, String telefone, String endereco, String id) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.id = id;
        this.listaCachorro = new ArrayList<>();
        this.listaServico = new ArrayList<>();
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

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws IllegalArgumentException {
        if (telefone == null || telefone.isEmpty() || telefone.length() > 11) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws IllegalArgumentException {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
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

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Telefone: " +  telefone + "\n" +
                "Endereço: " + endereco;
    }

    public void cadastrarCachorro(Cachorro cachorro) {
        listaCachorro.add(cachorro);
        System.out.println("Cachorro cadastrado com sucesso!");
    }

    public void removerCachorro(String id) {
        Iterator<Cachorro> iterator = listaCachorro.iterator();
        while (iterator.hasNext()) {
            Cachorro item = iterator.next();
            if (item.getId().equals(id)) {  // Comparando o ID do serviço
                iterator.remove();  // Remoção segura
            }
        }

        System.out.println("Cachorro removido com sucesso!");
    }

    public void cadastrarServico(Servico servico) {
        listaServico.add(servico);
    }

    public void removerServico(String idServico) {
        Iterator<Servico> iterator = listaServico.iterator();
        while (iterator.hasNext()) {
            Servico item = iterator.next();
            if (item.getId().equals(idServico)) {  // Comparando o ID do serviço
                iterator.remove();  // Remoção segura
            }
        }
    }

}
