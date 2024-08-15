package org.example;

import org.example.Servico;

import java.util.HashMap;

public class ServicoManager {
    private HashMap<Integer, Servico> servicosDisponiveis;

    public ServicoManager() {
        this.servicosDisponiveis = new HashMap<>();
    }

    public void adicionarServico(Servico servico) {
        servicosDisponiveis.put(servico.getId(), servico);
    }

    public Servico buscarServicoPorId(int id) {
        return servicosDisponiveis.get(id); // Retorna null se o ID não existir
    }
}
