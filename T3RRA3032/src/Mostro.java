public class Mostro {
    /*
     * Classe Mostro con attributi: nome, tipo, abilita', forza, vita,
     * ArrayList<Mostri>
     * + aggiungere nel modello ER l'attributo puntiExpConferiti che il Mostro
     * restituisce
     * al player.
     */

    private String tipo;
    private double forza;
    private int vita;
    private int exp;
    private String[] mosse;

    public Mostro(String tipo, double forza, int vita, int exp, String[] mosse) {
        this.tipo = tipo;
        this.forza = forza;
        this.vita = vita;
        this.exp = exp;
        this.mosse = mosse;
    }

    public Mostro() {

    }

    // Metodo di attacco da parte del mostro
    public void attacca(Personaggio p, int sceltaUtente) {
        double coefficenteForza = (Math.random() * (3.0 - 2.0)) + 2.0;
        int attaccoSubito = (int) Math.round(forza * coefficenteForza);
        int mossaMostro = (int) (Math.random() * (mosse.length - 0)) + 0;
        p.difenditi(mosse[mossaMostro], mosse[sceltaUtente - 1], attaccoSubito);
        if (p.checkMorte()) {
            System.out.println("\nIl " + getTipo() + " ti ha sconfitto!");
            Grafiche graficheObj = new Grafiche();
            graficheObj.gameOver();
        }
    }

    public String stampaMosse() {
        int conta = 1;
        String s = "";
        for (String mossa : mosse) {
            s = s + conta + ". " + mossa + "\n";
            conta++;
        }
        return s;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean checkMorte() {
        return getVita() <= 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getForza() {
        return forza;
    }

    public void setForza(double forza) {
        this.forza = forza;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public String toString() {
        return "\n| TIPO: " + getTipo() + " | FORZA: " + getForza() + " | VITA: " + getVita() + "\n";
    }

    public String[] getMosse() {
        return mosse;
    }

    public int getExp() {
        return exp;
    }
}