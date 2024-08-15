import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Servico {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private HashMap<Integer, Usuario> listaUsuarios;
    private boolean status;
    private int limite;
    private int participantes;

    public Servico(int id, String nome, String descricao, Date data, HashMap<Integer, Usuario> listaUsuarios, boolean status, int limite) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
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

    public HashMap<Integer, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashMap<Integer, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
        for (Integer id : listaUsuarios.keySet()) {
            Usuario u = listaUsuarios.get(id);
            dados += u.toString() + "\n";
        }
        return dados;
    }

    public void removerUsuario(Integer idExcluir) {
        listaUsuarios.remove(idExcluir);
    }
}
