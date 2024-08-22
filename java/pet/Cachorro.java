package pet;

public class Cachorro {
    private String id;
    private String nome;
    private String raca;
    private int idade;

    public Cachorro() {
    }

    public Cachorro(String id, String nome, String raca, int idade) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
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
        if (nome.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if (raca.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0){
            throw new IllegalArgumentException();
        }
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                '}';
    }
}