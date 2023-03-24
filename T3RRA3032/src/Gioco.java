import java.sql.SQLException;
import java.util.Scanner;

public class Gioco {
    Negozio n = new Negozio();
    Scanner scanInt = new Scanner(System.in);

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void scontro(Personaggio p, Mostro m) {
        boolean turnoPersonaggio = true;
        while (!p.checkMorte() && !m.checkMorte()) {
            if (turnoPersonaggio) {
                System.out.println(p.toString());
                System.out.println("È il tuo turno! Stai affrontando un " + m.getTipo());
                System.out.print("Scelta della mossa: \n1.Attacco con Arma\n2.Attacco Corpo a Corpo\n3.Bevi una pozione\nScegli cosa fare: ");
                int sceltaAttacco = scanInt.nextInt();
                //Attacco con arma
                if (sceltaAttacco == 1) {
                    if (!p.trovaItem(1).isEmpty()) {
                        System.out.println(p.stampaItem(1));
                        System.out.print("\nSeleziona con quale arma vuoi attaccare: ");
                        int sceltaArma = scanInt.nextInt();
                        p.attacca(m, (Arma) p.trovaItem(1).get(sceltaArma - 1));
                    } else {
                        System.out.println("\nNon sono presenti armi nel tuo inventario!");
                    }
                    System.out.println("");
                }
                //Attacco corpo a corpo 
                else if (sceltaAttacco == 2) {
                    System.out.print("\nCome vuoi attaccare il mostro:\n1.Pugno\n2.Calcio\nScegli: ");
                    int sceltaCorpoaCorpo = scanInt.nextInt();
                    p.attacca(m, sceltaCorpoaCorpo);
                }
                //Bevi pozione che hai nell'inventario 
                else if (sceltaAttacco == 3) 
                {
                    if (!p.trovaItem(2).isEmpty()) {
                        System.out.println(p.stampaItem(2));
                        System.out.print("\nSeleziona quale pozione vuoi assumere: ");
                        try
                        {
                            int sceltaPozione = scanInt.nextInt();
                            p.beviPozione((Pozione) p.trovaItem(2).get(sceltaPozione - 1));
                        }
                        catch (Exception e)
                        {
                            System.out.println("\nInserimento sbagliato... Salti il turno");
                        }
                    } 
                    else {
                        System.out.println("\nNon sono presenti pozioni nel tuo inventario!");
                    }
                } else {
                    System.out.println("\nMossa sprecata!");
                }
                turnoPersonaggio = false;
            } else {
                System.out.println(m.toString());
                System.out.println("\nÈ il turno del " + m.getTipo() + "!\nScegli da cosa vuoi difenderti: ");
                System.out.println(m.stampaMosse());
                try
                {
                    int sceltaMossa = scanInt.nextInt();
                    m.attacca(p, sceltaMossa);
                    turnoPersonaggio = true;
                }
                catch (Exception e)
                {
                    System.out.println("Inserimento errato...");
                }    
            }
        }
        System.out.println("\nFINE SCONTRO!!!");
    }

    public void menuNegozio(Personaggio p) throws SQLException {
        System.out.println("BENVENUTO NELLO SHOP!");
        boolean esciShop = true;
        while (esciShop) {
            System.out.print("\nSeleziona un'opzione:\n1. Visualizza lo shop\n2. Acquista qualcosa\n3. Esci dallo shop\nInserisci opzione: ");
            int scelta = scanInt.nextInt();
            if (scelta == 1) {
                n.restituisciShop();
            } else if (scelta == 2) {
                n.restituisciShop();
                System.out.print("Scegli cosa vuoi acquistare: ");
                try {
                    int sceltaAcquisto = scanInt.nextInt();
                    n.acquistaItem(sceltaAcquisto, p);
                }
                catch (Exception e)
                {
                    System.out.println("Inserimento errato...");
                } 
            } else if (scelta == 3) {
                esciShop = false;
                break;
            } else {
                System.out.println("\nScegli un'opzione corretta e riprova!!!");
            }
        }
        System.out.println("\nSperiamo di rivederti presto!");
    }

    public int inputIntSelezione(String inputMessage) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        try
        {    
            System.out.print(inputMessage);
            num = sc.nextInt();
            sc.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
        catch(Exception e)
        {
            System.out.println(ANSI_RED + "\nInserisci un valore numerico intero\n" + ANSI_RESET);
            inputIntSelezione(inputMessage);
        }
        return num;
    }

    public String inputStringSelezione(String inputMessage) {
        Scanner sc = new Scanner(System.in);
        System.out.print(inputMessage);
        String str = sc.nextLine();
        sc.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        return str;
    }
}