import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PetCareServerImpl {

    //------ BANCO DE DADOS ------//

    private int usuarioCounter = 0;
    private int cachorroCounter = 0;
    private int servicoCounter = 0;

    private Servico servico1 = new Servico("SRV1", "Banho", "Terça-Feira, 09:00 ao 12:00");
    private Servico servico2 = new Servico("SRV2", "Tosa", "Terça-Feira, 12:00 ao 15:00");
    private Servico servico3 = new Servico("SRV3", "Passeio", "Sexta-Feira, 09:00 ao 18:00");
    private Servico servico4 = new Servico("SRV4", "Spa", "Sábado, 09:00 ao 12:00");

    HashMap<String, Object> bancoDados = new HashMap<>();

    //------ CRUD USUARIOS ------//

    public String cadastrarUsuario(String nome, String telefone, String enderecoUsuario) {

        String usuarioId = "USR" + usuarioCounter++;
        Usuario usuario = new Usuario(nome, telefone, enderecoUsuario, usuarioId);

        bancoDados.put(usuarioId, usuario);

        return "Usuario cadastrado com o ID: " + usuarioId;
    }

    public String getUsuario(String id) {
        return "Usuario " + id + "\n" + bancoDados.get(id).toString();
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
            return "Usuario removido com sucesso!";
        } else {
            return "Usuario não encontrado.";
        }
    }

    //------ CRUD SERVIÇOS ------//

    public String agendarServicos(String nome, String id, String descricao, Date data, String observacao, boolean status, int limite) {
        String servicoId = "SRV" + servicoCounter++;

        return "Serviço agendado!";
    }

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

    public void removerServico(String servicoId) {
        if (bancoDados.containsKey(servicoId)) {
            System.out.println("O servico foi removido com sucesso!");
            bancoDados.remove(servicoId);
        } else {
            System.out.println("Não foi possivel achar o serviço");
        }
    }

    //------ CRUD CACHORROS ------//

    public String cadastrarCachorro(String idUsuario, String nome, String raca, int idade) {

        String cachorroID = "DOG" + cachorroCounter++;
        Cachorro cachorro = new Cachorro(cachorroID, nome, raca, idade);

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

        if (bancoDados.containsKey(idCachorro)) {
            usuario.removerCachorro(idCachorro);
            bancoDados.remove(idCachorro);
            return "Cachorro removido com sucesso!";
        } else {
            return "Cachorro não encontrado.";
        }
    }

}