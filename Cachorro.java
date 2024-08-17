public class Cachorro {
    private String id;
    private String nome;
    private String raca;
    private int idade;
    private String porte;

    public Cachorro() {
    }

    public Cachorro(String id, String nome, String raca, int idade, String porte) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", porte='" + porte + '\'' +
                '}';
    }
}