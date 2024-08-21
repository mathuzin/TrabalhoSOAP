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

        System.out.println(" | BEM VINDO(A) AO PETCARE! | ");
        System.out.println();

        System.out.println(" |      CRIAR USUÁRIO       | ");
        System.out.println();

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Digite seu endereço: ");
        String endereco = sc.nextLine();
        System.out.println(pet.cadastrarUsuario(nome, telefone, endereco));
        System.out.println();

        System.out.println(" |     CADASTRAR CACHORRO    | ");
        System.out.println();

        System.out.println("Digite seu ID: ");
        String idDono = sc.nextLine();
        System.out.println("Digite o nome do cão: ");
        nome = sc.nextLine();
        System.out.println("Digite a raça do cão: ");
        String raca = sc.nextLine();
        System.out.println("Digite a idade do cão: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println(pet.cadastrarCachorro(idDono, nome, raca, idade));
        System.out.println();

        System.out.println(" |      AGENDAR SERVIÇO     | ");
        System.out.println();
        System.out.println(pet.listarServicos());
        System.out.println("Digite o ID do serviço desejado: ");
        String idServico = sc.nextLine();
        System.out.println("Digite o ID do cão: ");
        String idCao = sc.nextLine();
        System.out.println("Observação: ");
        String obs = sc.nextLine();
        System.out.println(pet.agendarServicos(idServico, idDono, idCao, obs));


    }
}
