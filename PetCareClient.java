package org.example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PetCareClient {

    public static void main(String[] args) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);
        URL url = new URL("http://127.0.0.1:9876/pet?wsdl");
        QName qname = new QName("http://pet/", "PetCareServerImplService");
        Service ws = Service.create(url, qname);
        PetCareServer pet = ws.getPort(PetCareServer.class);

        boolean continuar = true;

            System.out.println(" | BEM VINDO(A) AO PETCARE! | ");
            System.out.println(" |      CRIAR USUÁRIO       | ");
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite seu telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Digite seu endereço: ");
            String endereco = sc.nextLine();
            System.out.println(pet.cadastrarUsuario(nome, telefone, endereco));

            Usuario usuario = new Usuario(nome, telefone, endereco, pet.cadastrarUsuario(nome, telefone, endereco));

            System.out.println();

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Visualizar Usuário");
            System.out.println("2. Cadastrar Cachorro");
            System.out.println("3. Agendar Serviço");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:

                    System.out.println(" |     VERIFICAR USUÁRIO    |");
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Verificar Informações.");
                    System.out.println("2. Atualizar Telefone e/ou Endereço.");
                    System.out.println("3. Excluir Usuário.");
                    System.out.print("Escolha: ");
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    switch (escolha) {
                        case 1:
                            System.out.println("Informações do Usuário: ");
                            System.out.println(pet.getUsuario(usuario.getId()));
                            break;

                        case 2:
                            System.out.print("Digite o novo número de telefone: ");
                            String novoTelefone = sc.nextLine();
                            pet.atualizarTelefoneUsuario(usuario.getId(), novoTelefone);
                            System.out.println("Novo telefone cadastardo!");
                            break;

                        case 3:
                            System.out.println("Excluindo...");
                            pet.excluirUsuario(usuario.getId());

                    }

                    break;

                case 2:
                    System.out.println(" |     CADASTRAR CACHORRO    | ");
                    System.out.println("Digite seu ID: ");
                    String idDono = sc.nextLine();
                    System.out.println("Digite o nome do cão: ");
                    nome = sc.nextLine();
                    System.out.println("Digite a raça do cão: ");
                    String raca = sc.nextLine();
                    System.out.println("Digite a idade do cão: ");
                    int idade = sc.nextInt();
                    sc.nextLine(); // Consumir a nova linha
                    System.out.println(pet.cadastrarCachorro(idDono, nome, raca, idade));
                    System.out.println();
                    break;

                case 3:
                    System.out.println(" |      AGENDAR SERVIÇO     | ");
                    System.out.println(pet.listarServicos());
                    System.out.println("Digite o ID do serviço desejado: ");
                    String idServico = sc.nextLine();
                    System.out.println("Digite seu ID: ");
                    idDono = sc.nextLine();
                    System.out.println("Digite o ID do cão: ");
                    String idCao = sc.nextLine();
                    System.out.println("Observação: ");
                    String obs = sc.nextLine();
                    System.out.println(pet.agendarServicos(idServico, idDono, idCao, obs));
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
