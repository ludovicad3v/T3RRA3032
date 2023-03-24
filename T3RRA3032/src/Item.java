abstract class Item {
    /* Classe astratta Item con attributi: tipo, disponibilita, prezzo
     * Definisce un Item generico che sarà presente nello shop e nell'inventario di Personaggio
     */

    private String tipo;
    private int disponibilita;
    private int prezzo;


    public Item(String tipo, int disponibilita, int prezzo) {
        this.tipo = tipo;
        this.disponibilita = disponibilita;
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
}