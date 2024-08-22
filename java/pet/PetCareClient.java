package pet;

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

        boolean reload = true;

        while (reload) {
            boolean continuar = true;

            System.out.println(" | BEM VINDO(A) AO PETCARE! | ");
            System.out.println(" |      CRIAR USUARIO       | ");
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite seu telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Digite seu endereço: ");
            String endereco = sc.nextLine();
            System.out.println(pet.cadastrarUsuario(nome, telefone, endereco));
            System.out.println();

            while (continuar) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Visualizar Usuário");
                System.out.println("2. Cadastrar Cachorro e Informações");
                System.out.println("3. Agendar Serviço");
                System.out.println("4. Sair");
                System.out.print("Opção: ");
                int opcao = sc.nextInt();
                sc.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:

                        System.out.println(" |     VERIFICAR USUARIO    |");
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Verificar Informações.");
                        System.out.println("2. Atualizar Telefone.");
                        System.out.println("3. Excluir Usuário.");
                        System.out.print("Escolha: ");
                        int escolha = sc.nextInt();
                        sc.nextLine();

                        switch (escolha) {
                            case 1:
                                System.out.println("Informações do Usuario: ");
                                System.out.print("Indira seu ID: ");
                                String idUsuario = sc.nextLine().toUpperCase();
                                System.out.println(pet.getUsuario(idUsuario));
                                System.out.println();
                                break;

                            case 2:
                                System.out.print("Digite seu ID: ");
                                idUsuario = sc.nextLine().toUpperCase();
                                System.out.print("Digite o novo numero de telefone: ");
                                String novoTelefone = sc.nextLine();
                                pet.atualizarTelefoneUsuario(idUsuario, novoTelefone);
                                System.out.println("Novo telefone cadastardo!");
                                System.out.println();
                                break;

                            case 3:
                                System.out.print("Digite seu ID para confirmar: ");
                                idUsuario = sc.nextLine().toUpperCase();
                                pet.excluirUsuario(idUsuario);
                                System.out.println("Excluindo...");
                                continuar = false;
                                System.out.println();
                                break;
                        }

                        break;

                    case 2:
                        System.out.println("Escolha uma das opções: ");
                        System.out.println("1. Cadastrar cachorro.");
                        System.out.println("2. Listar seus cachorros.");
                        System.out.println("3. Alterar idade do cachorro.");
                        System.out.println("4. Excluir cachorro.");
                        System.out.print("Escolha: ");
                        int escolhaCao = sc.nextInt();
                        sc.nextLine();

                        switch (escolhaCao) {
                            case 1:
                                System.out.println(" |     CADASTRAR CACHORRO    | ");
                                System.out.println("Digite seu ID: ");
                                String idDono = sc.next().toUpperCase();
                                System.out.println("Digite o nome do cão: ");
                                nome = sc.next();
                                System.out.println("Digite a raça do cão: ");
                                String raca = sc.next();
                                System.out.println("Digite a idade do cão: ");
                                int idade = sc.nextInt();
                                System.out.println(pet.cadastrarCachorro(idDono, nome, raca, idade));
                                System.out.println();
                                break;

                            case 2:
                                System.out.print("Digite seu ID para confirmar: ");
                                String idUsuario = sc.nextLine().toUpperCase();
                                System.out.println(pet.listarCachorros(idUsuario));
                                System.out.println();
                                break;

                            case 3:
                                System.out.print("Digite o ID do(a) cachorro(a) que será alterado(a): ");
                                String idCachorroIdade = sc.nextLine().toUpperCase();
                                System.out.print("Digite a idade atual do(a) seu cachorro(a)");
                                int novaIdade = sc.nextInt();
                                System.out.println(pet.alterarIdadeCachorro(idCachorroIdade, novaIdade));
                                System.out.println();
                                break;
                            case 4:
                                System.out.print("Digite seu ID para confirmar: ");
                                idUsuario = sc.nextLine().toUpperCase();
                                System.out.print("Digite ID do(a) cachorro(a): ");
                                String idCachorro = sc.nextLine().toUpperCase();
                                System.out.println(pet.removerCachorro(idCachorro, idUsuario));
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                System.out.println();
                        }
                        break;

                    case 3:
                        System.out.println("Escolha uma das opções: ");
                        System.out.println("1. Agendar Serviço.");
                        System.out.println("2. Listar seus serviços.");
                        System.out.println("3. Mudar Obersavação.");
                        System.out.println("4. Excluir um serviço.");
                        System.out.print("Escolha: ");
                        int opcaoSvg = sc.nextInt();
                        switch (opcaoSvg) {
                            case 1:
                                System.out.println(" |      AGENDAR SERVICO     | ");
                                System.out.println(pet.listarServicos());
                                System.out.println("Digite o ID do serviço desejado: ");
                                String idServico = sc.next().toUpperCase();
                                System.out.println("Digite seu ID: ");
                                String idCliente = sc.next().toUpperCase();
                                System.out.println("Digite o ID do cão: ");
                                String idCao = sc.next().toUpperCase();
                                System.out.println("Observação: ");
                                String observation = sc.next();
                                System.out.println(pet.agendarServicos(idServico, idCliente, idCao, observation));
                                System.out.println();
                                break;

                            case 2:
                                System.out.println("Lista de serviço: \n" + pet.listarServicos());
                                System.out.println();
                                break;

                            case 3:
                                System.out.println("Digite o ID do serviço: ");
                                String idSvg = sc.next().toUpperCase();
                                System.out.println("Digite a observação que deseja adicionar: ");
                                String obs = sc.next();
                                System.out.println(pet.mudarObservacao(idSvg, obs));
                                System.out.println();
                                break;

                            case 4:
                                System.out.println("Digite o ID do serviço: ");
                                idSvg = sc.next().toUpperCase();
                                System.out.println("Digite o seu ID: ");
                                String idDono = sc.next().toUpperCase();
                                System.out.println(pet.removerServico(idSvg, idDono));
                                System.out.println();
                                break;

                            default:
                                System.out.println("Não existe a opção digitada!");
                                System.out.println();
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        reload = false;
                        continuar = false;
                        System.out.println();
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                }
            }
        }
        sc.close();
    }
}