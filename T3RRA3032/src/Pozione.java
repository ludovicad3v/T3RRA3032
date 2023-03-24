public class Pozione extends Item {
    /*
     * Classe Pozione (Nel modello ER si chiama Pozioni) con attributi:
     * nome pozione, durata, effetto
     */

    // Viene definito l'effetto che avrà sul Personaggio in termini numerici (es.
    // vita:20, forza:50...)
    private int effetto;

    public Pozione(int id, String tipo, int disponibilita, int prezzo, int effetto) {
        super(tipo, disponibilita, prezzo);
        this.effetto = effetto;
    }

    public int getEffetto() {
        return effetto;
    }
}