import java.util.Date;
import java.util.HashMap;

public class Servico {
    private String id;
    private String nome;
    private String descricao;
    private Date data;
    private String observacao;
    private HashMap<String, Usuario> listaUsuarios;
    private boolean status;
    private int limite;
    private int participantes;

    public Servico() {
    }

    public Servico(String nome, String id, String descricao, Date data, String observacao, boolean status, int limite) {
        this.nome = nome;
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.observacao = observacao;
        this.status = status;
        this.limite = limite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public HashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setParticipantes(int participantes) {
        this.participantes = participantes;
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
                ", listaUsuarios=" + listaUsuarios +
                ", status='" + status + '\'' +
                ", limite=" + limite +
                '}';
    }

    private int getParticipantes() {
        return participantes;
    }

    public String adicionarUsuario(Usuario usuario) {
        if (status) {
            if (participantes < limite) {
                listaUsuarios.put(usuario.getId(), usuario);
                participantes++;
                if (participantes == limite) {
                    mudarStatus();
                }
                return "Usuário adicionado com sucesso \n";
            } else {
                return "O serviço atingiu seu limite de participantes \n";
            }
        } else {
            return "Não é possível adicionar mais participantes \n";
        }
    }

    private void mudarStatus() {
        this.status = participantes < limite;
    }

    public String listarUsuarios() {
        String dados = "";
        for (String id : listaUsuarios.keySet()) {
            Usuario u = listaUsuarios.get(id);
            dados += u.toString() + "\n";
        }
        return dados;
    }

    public void removerUsuario(Integer idExcluir) {
        listaUsuarios.remove(idExcluir);
    }
}