package org.example;

import java.util.HashMap;
import java.util.Map;

public class ServicoManager {
    private HashMap<Integer,Servico> servicosDisponiveis;

    public ServicoManager() {
        this.servicosDisponiveis = new HashMap<>();
    }

    public void adicionarServico(Servico servico) {
        servicosDisponiveis.put(servico.getId(),servico);
    }

    public Servico buscarServicoPorId(int id) {

        for (Integer m : servicosDisponiveis.keySet()) {
            if (m ==  id){
                return
            }
        }
        }

    public String imprimirEstoque() {
        String s = "";

        for (String livro : estoque.keySet()) {
            s += livro.toString() + "\n";
        }

        return s;
    }
    }