
public class Arma extends Item {
    /* Classe Arma con attributi: nome Arma e potenza attacco */
    
    //ID per Database
    private int id;
    //Nome arma (es. Spada Bastarda)
    private String nome;
    //Forza dell'arma
    private double forzaArma;

    public Arma(int id, String nome, String tipo, int disponibilita, int prezzo, double forzaArma) {
        super(tipo, disponibilita, prezzo);
        this.id = id;
        this.nome = nome;
        this.forzaArma = forzaArma;
    } 

    public int getIdArma() {
        return id;
    }

    public void setIdArma(int idArma) {
        this.id = idArma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getForzaArma() {
        return forzaArma;
    }

    public void setForzaArma(double forzaArma) {
        this.forzaArma = forzaArma;
    }
}