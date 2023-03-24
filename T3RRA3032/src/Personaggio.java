import java.util.ArrayList;
import java.util.Random;

public class Personaggio extends Mostro {
    /*
     * Classe Personaggio con attributi: nome, vita, forza, stamina,
     * punti exp
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String nome;
    // Inventario del personaggio dove saranno contenuti gli Item
    private Item[] inventario;

    // I punti exp possono servire per l'acquisto di item nello shop
    // Vengono guadagnati anche durante le battaglie con i mob
    private int stamina;

    // Quando creo un oggetto di tipo personaggio, randomizzo le sue stats e il suo
    // inventario avrà dimensione di 5
    public Personaggio(String nome) {
        this.nome = nome;
        randomStats();
        setExp(0);
        inventario = new Item[5];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Aggiunge un item all'inventario
    public void aggiungiItem(Item m) {
        boolean aggiunto = false;
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) {
                inventario[i] = m;
                setExp(getExp() - m.getPrezzo());
                aggiunto = true;
                break;
            }
        }
        System.out.println(aggiunto ? m.getTipo() + " inserito nell'inventario! Hai speso " + m.getPrezzo() + "EXP!"  : "Inventario pieno!!!");
    }

    // Rimuove un item dall'inventario
    public void rimuoviItem(Item m) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == m) {
                inventario[i] = null;
                break;
            }
        }
    }

    // Attacco corpo a corpo: selezionando 1 si potrà usare il pugno, mentre con 2
    // si usa il calcio. Scegliendo un altra mossa fallisce!
    public void attacca(Mostro m, int sceltaMossa) {
        int danno;
        if (sceltaMossa == 1) {
            danno = (int) Math.round(getForza() * 10);
            m.setVita(m.getVita() - danno);
            System.out.println("Ouch!! Hai sferrato un pugno al " + m.getTipo() + ", danneggiandolo di " + danno);
            setStamina(stamina - 3);
        } else if (sceltaMossa == 2) {
            danno = (int) Math.round(getForza() * 15);
            m.setVita(m.getVita() - danno);
            System.out.println("Ahia!! Hai sferrato un calcio al " + m.getTipo() + ", danneggiandolo di " + danno);
            setStamina(stamina - 5);
        } else {
            System.out.println("Mancato!!!");
        }
        // Controlla se il mostro è morto, in caso positivo stampa la frase (da
        // implementare diversamente in futuro)
        if (m.checkMorte()) {
            System.out.println("L'hai pestato come si deve! Ricevi " + m.getExp() + " EXP");
            setExp(getExp() + m.getExp());
        }
    }

    // Attacco con un arma a scelta
    public void attacca(Mostro m, Arma a) {
        int danno = (int) Math.round((getForza() + a.getForzaArma()) * 10);
        m.setVita(m.getVita() - danno);
        System.out.println("SBAM! Hai sferrato un colpo di " + a.getNome() + " al " + m.getTipo() + ", danneggiandolo di " + danno);
        setStamina(stamina - 10);
        if (m.checkMorte()) {
            System.out.println("Hai affettato il " + m.getTipo() + ", ricevendo " + m.getExp() + " EXP");
            setExp(getExp() + m.getExp());
        }
    }

    // Se si prevede la mossa del mostro si eviterà, in caso contrario viene subito
    // del danno
    public void difenditi(String mossaMostro, String sceltaUtente, int attaccoMostro) {
        if (mossaMostro.equals(sceltaUtente)) {
            System.out.println("Hai schivato la mossa " + sceltaUtente);
        } else {
            setVita(getVita() - attaccoMostro);
            System.out.println("Non sei riuscito a contrastare la mossa, subendo un danno di " + attaccoMostro);
        }
    }

    // In base al tipo di pozione, verranno aggiornate determinate statistiche
    public void beviPozione(Pozione p) {
        if (p.getTipo().equals("VITA")) {
            if (getVita() < 80)
                setVita(getVita() + p.getEffetto());
        } else if (p.getTipo().equals("STAMINA")) {
            stamina = stamina + p.getEffetto();
        }
        // Qua ci andrà l'effetto della pozione sulla forza che è da definire
        else {
        }
        String tipo = p.getTipo().equals("VITA") ? "hp" : "punti";
        System.out.println("Hai assunto una pozione di tipo " + p.getTipo() + " recuperando " + p.getEffetto() + tipo);
        rimuoviItem(p);
    }

    // Trova un tipo di Item, premendo 1 si cercano le Armi, premendo 2 si cercano
    // le Pozioni
    public ArrayList<Item> trovaItem(int scelta) {
        ArrayList<Item> armiPozioni = new ArrayList<Item>();
        if (scelta == 1) {
            for (Item oggetto : inventario) {
                if (oggetto instanceof Arma) {
                    Arma a = (Arma) oggetto;
                    armiPozioni.add(a);
                }
            }
        } else if (scelta == 2) {
            for (Item oggetto : inventario) {
                if (oggetto instanceof Pozione) {
                    Pozione p = (Pozione) oggetto;
                    armiPozioni.add(p);
                }
            }
        }
        return armiPozioni;
    }

    // Vengono stampati gli Item cercati
    public String stampaItem(int scelta) {
        String s = "";
        int conta = 1;
        for (Item oggetto : trovaItem(scelta)) {
            if (scelta == 1) {
                Arma a = (Arma) oggetto;
                s = s + conta + ". " + a.getNome() + "\n";
            } else if (scelta == 2) {
                Pozione p = (Pozione) oggetto;
                s = s + conta + ". Pozione " + p.getTipo() + "\n";
            }
            conta++;
        }
        return s;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    // Randomizza le stats del personaggio
    public void randomStats() {
        setVita((int) (Math.random() * (100 - 50)) + 50); // Randomizzo la vita da 50 a 100
        setForza((Math.random() * (5.0 - 1.0)) + 1.0); // Randomizzo la forza da 1 a 5
        stamina = ((int) (Math.random() * (100 - 50)) + 50); // Randomizzo la stamina da 50 a 100
    }

    public String toString() {
        Grafiche stampaStats = new Grafiche();

         String vita = getVita() >= 60 && getVita() <= 100 ? stampaStats.hpMax(getVita()) : getVita() < 60 && getVita() >= 40 ? stampaStats.hpMedium(getVita()) : stampaStats.hpLow(getVita()) ;
        String forza = getForza() >=4 ? stampaStats.forzaMax(getForza()) : getForza() < 4 && getForza() >= 2.5 ? stampaStats.forzaMedium(getForza()) :  stampaStats.forzaLow(getForza()) ;
        String stamina = getStamina() <= 100 && getStamina() >= 60 ? stampaStats.staminaMax(getStamina()) : getStamina() < 60 && getStamina() >= 40 ? stampaStats.staminaMedium(getStamina()) : stampaStats.staminaLow(getStamina());

       /*  return vita + "\t" + forza + "\t" + stamina; */
        return "\n\t\t\t\t\t     NOME: " + getNome() + "\n\n" + vita + "\t\t" + forza
                + "\t\t" + stamina + "\n\n\t\t\t\t\t        EXP: " + getExp() + "\n";
    }

    public Boolean lancioMoneta(){
        Random result = new Random();
        Boolean risultato = result.nextBoolean();
        System.out.println(ANSI_YELLOW + "La moneta saprà cosa è meglio fare!\n\nDIIIIING..." + ANSI_RESET);
        System.out.println(risultato?"TESTA":"CROCE");
        return risultato;
    }
}