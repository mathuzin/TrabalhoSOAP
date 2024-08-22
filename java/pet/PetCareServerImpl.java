package pet;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "pet.PetCareServer")
public class PetCareServerImpl implements PetCareServer {

    //------ BANCO DE DADOS ------//

    private int usuarioCounter = 0;
    private int cachorroCounter = 0;
    private int servicoCounter = 0;


    HashMap<String, Object> bancoDados = new HashMap<>();

    public PetCareServerImpl() {
        Servico servico1 = new Servico("SRV1", "Banho", "Terça-Feira, 09:00 ao 12:00");
        Servico servico2 = new Servico("SRV2", "Tosa", "Terça-Feira, 12:00 ao 15:00");
        Servico servico3 = new Servico("SRV3", "Passeio", "Sexta-Feira, 09:00 ao 18:00");
        Servico servico4 = new Servico("SRV4", "Spa", "Sábado, 09:00 ao 12:00");

        bancoDados.put(servico1.getId(), servico1);
        bancoDados.put(servico2.getId(), servico2);
        bancoDados.put(servico3.getId(), servico3);
        bancoDados.put(servico4.getId(), servico4);
    }

    //------ CRUD USUARIOS ------//

    public String cadastrarUsuario(String nome, String telefone, String endereco) {

        String usuarioId = "USR" + usuarioCounter++;
        Usuario usuario = new Usuario(nome, telefone, endereco, usuarioId);

        bancoDados.put(usuarioId, usuario);

        return "pet.Usuario cadastrado com o ID: " + usuarioId;
    }

    public String getUsuario(String id) {
        if (!bancoDados.containsKey(id)) {
            return "Usuário não encontrado.";
        }
        return "pet.Usuario " + id + "\n" + bancoDados.get(id).toString();
    }

    public String atualizarTelefoneUsuario(String id, String novoTelefone) {
        if (bancoDados.containsKey(id)) {
            Usuario usuario = (Usuario) bancoDados.get(id);
            usuario.setTelefone(novoTelefone);
            return "Telefone do usuario " + usuario.getId() + " atualizado com sucesso!";
        } else {
            return "Não foi possível atualizar o telefone";
        }
    }

    public String excluirUsuario(String id) {
        if (bancoDados.containsKey(id)) {
            bancoDados.remove(id);
            return "pet.Usuario removido com sucesso!";
        } else {
            return "pet.Usuario não encontrado.";
        }
    }

    //------ CRUD SERVIÇOS ------//

    public String agendarServicos(String idServico, String idUsuario, String idCachorro, String observacao) {
        if (!bancoDados.containsKey(idServico)) {
            return "Serviço não existe";
        }

        Servico servico = (Servico) bancoDados.get(idServico);
        Usuario usuario = (Usuario) bancoDados.get(idUsuario);
        Cachorro cachorro = (Cachorro) bancoDados.get(idCachorro);

        usuario.cadastrarServico(servico);
        servico.cadastrarCachorro(cachorro);

        servico.setObservacao(observacao);

        return "Serviço agendado!";
    }

/*    public String agendarServicos(String idServico, String idUsuario, String idCachorro) {
        if (!bancoDados.containsKey(idServico)) {
            return "Serviço não existe";
        }

        Servico servico = (Servico) bancoDados.get(idServico);
        Usuario usuario = (Usuario) bancoDados.get(idUsuario);
        Cachorro cachorro = (Cachorro) bancoDados.get(idCachorro);

        usuario.cadastrarServico(servico);
        servico.cadastrarCachorro(cachorro);

        return "Serviço agendado!";
    }*/

    public String listarServicos() {
        String listaServicos = "";

        for(Map.Entry<String, Object> servico : bancoDados.entrySet()) {
            if(servico.getValue() instanceof Servico) {
                listaServicos += servico.getValue().toString() + "\n";
            }
        }
        return listaServicos;
    }

    public String mudarObservacao(String id, String observacao) {
        if (bancoDados.containsKey(id)) {
            ((Servico) bancoDados.get(id)).setObservacao(observacao);
            return "A observação do serviço foi mudado com sucesso!";
        } else {
            return "Não foi possivel mudar a observação!";
        }
    }

    public String removerServico(String servicoId, String idUsuario) {
        String dados = "";
        if (bancoDados.containsKey(servicoId)) {
            dados += "O servico foi removido com sucesso!";
            Usuario usuario = (Usuario) bancoDados.get(idUsuario);
            usuario.removerServico(servicoId);
        } else {
            dados += "Não foi possivel achar o serviço";
        }
        return dados;
    }

    //------ CRUD CACHORROS ------//

    public String cadastrarCachorro(String idUsuario, String nome, String raca, int idade) {
        String cachorroID = "DOG" + cachorroCounter++;
        Cachorro cachorro = new Cachorro(cachorroID, nome, raca, idade);

        if (!bancoDados.containsKey(idUsuario)) {
            return "Erro: Usuário com ID " + idUsuario + " não encontrado.";
        }

        Usuario usuario = (Usuario) bancoDados.get(idUsuario);

        usuario.cadastrarCachorro(cachorro);
        bancoDados.put(cachorroID, cachorro);

        return cachorro.getNome() + " cadastrado(a) com ID: " + cachorro.getId();
    }

    public String listarCachorros(String idUsuario) {

        String dados = "";

        if (bancoDados.containsKey(idUsuario)){
            Usuario usuario = (Usuario) bancoDados.get(idUsuario);
            ArrayList<Cachorro> listaCachorros = usuario.getListaCachorro();

            if (listaCachorros.isEmpty()){
                dados += "Não há cachorros cadastardos neste usuário.";
            } else {
                for (Cachorro cachorro : listaCachorros) {
                    dados += cachorro.toString() + "\n";
                }
            }
        } else {
            dados = "Usuário não encontrado.";
        }

        return dados;
    }

    public String alterarIdadeCachorro(String idCachorro, int idadeNova){
        if (bancoDados.containsKey(idCachorro)) {
            ((Cachorro) bancoDados.get(idCachorro)).setIdade(idadeNova);

            return "Idade do " + ((Cachorro) bancoDados.get(idCachorro)).getNome() +
                    " alterada para " + ((Cachorro) bancoDados.get(idCachorro)).getIdade();
        } else {
            return "Animal não encontrado.";
        }
    }

    public String removerCachorro(String idCachorro, String idUsuario) {
        Usuario usuario = (Usuario) bancoDados.get(idUsuario);

        if (usuario == null) {
            return "Usuário não encontrado.";
        }

        if (bancoDados.containsKey(idCachorro)) {
            usuario.removerCachorro(idCachorro);
            bancoDados.remove(idCachorro);
            return "Cachorro removido com sucesso!";
        } else {
            return "Cachorro não encontrado.";
        }
    }


}