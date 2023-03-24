import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner myInput = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /* Classe Main */
    public static void main(String[] args) throws SQLException {
        Grafiche graficheObj = new Grafiche();
        Gioco giocoObj = new Gioco();

        graficheObj.ordinamentoGrafiche();

        boolean terminaGioco = false;

        do {
            System.out.print("\n");
            graficheObj.mainMenu();

            System.out.print(ANSI_GREEN + ">> Digita scelta e premi invio: " + ANSI_RESET);
            String sceltaMenuPrincipale = myInput.nextLine();

            // Inizia il gioco
            if (sceltaMenuPrincipale.equals("+")) {
                // Stampo le grafiche iniziali del gioco
                graficheObj.graficaIniziale();
                graficheObj.graficaIniziale2();
                graficheObj.tramaIniziale();

                Personaggio persObj = new Personaggio(null);
                // Chiedo il nome che il personaggio avrà per la storia del gioco
                System.out.print(ANSI_GREEN + ">> Il tuo nome non e' presente nel database. Inserisci nome giocatore: "
                        + ANSI_RESET);
                String nomePersonaggio = myInput.nextLine();
                persObj.setNome(nomePersonaggio);

                System.out.print(ANSI_GREEN + "\n>> Il tuo nome è stato aggiunto in memoria. Ciao " + persObj.getNome()
                        + ANSI_RESET);
                System.out.print("\n");
                System.out.println(ANSI_PURPLE
                        + "==========================================================================================================="
                        + ANSI_RESET);

                boolean sceltaLab = false;
                graficheObj.Laboratorio();

                do {
                    int num = giocoObj
                            .inputIntSelezione(ANSI_GREEN + "1: Esplora\n2: Cerca via di fuga\nScegli: " + ANSI_RESET);

                    // Esplora
                    if (num == 1) {
                        boolean monetaLanciata = false;
                        Mostro secondoMostro = new Mostro("Creatura non indentidicata", 10, 100, 75,
                                new String[] { "PsicoTerrore", "Morso" });

                        do {
                            int scelta = giocoObj.inputIntSelezione(ANSI_CYAN
                                    + "\n>> Il radar rivela oggetti nelle vicinanze. Sono presenti anche creature non identificate, fai attenzione!\nVuoi lanciare la moneta per decidere verso quale direzione inoltrarti? (SI: 1 | NO: 0): "
                                    + ANSI_RESET);

                            // Lancia la moneta
                            if (scelta == 1) {
                                boolean combattimento = persObj.lancioMoneta();
                                Mostro primoMostro = new Mostro("Demone", 15, 100, 50,
                                        new String[] { "Testata", "Cazzotto" });

                                // Primo combattimento contro un mostro
                                if (combattimento) {
                                    // Stampo la grafica del demone
                                    graficheObj.secondoCombattimento();
                                    // Chiamo il metodo per far partire il primo combattimento
                                    giocoObj.scontro(persObj, primoMostro);
                                    graficheObj.fineGiocoContinua();
                                    // TODO: VERSIONI FUTURE AGGIUNGERE ALTRE SCELTE E CONTINUARE LA TRAMA, QUI PER
                                    // ORA VIENE INSERITA LA STAMPA FINALE (FINISCE LA DEMO)
                                }
                                // Trova una pozione
                                else if (!combattimento) {
                                    Item pozioneTrovata = new Pozione(0, "VITA", 0, 0, 20);
                                    // Aggiungo la prima pozione gratis (trovata a terra) nell'inventario
                                    persObj.aggiungiItem(pozioneTrovata);
                                    System.out.println(ANSI_GREEN + "\n>> Ti è andata bene, hai trovato una pozione di "
                                            + pozioneTrovata.getTipo() + ANSI_RESET);
                                    // Per ora parte il primo combattimento dopo che hai trovato la pozione
                                    System.out.println(ANSI_GREEN
                                            + "\n>> Il radar sta rilevando la presenza di una creatura non senziente nelle vicinanze..."
                                            + ANSI_RESET);

                                    boolean sceltaShopInserita = false;

                                    do {
                                        // Richiesta di visualizzazione dello shop
                                        int sceltaShop = giocoObj.inputIntSelezione(ANSI_GREEN
                                                + "\n>> Desideri consultare lo shop? (SI: 1 | NO: 0): " + ANSI_RESET);
                                        // Scelta interazione con lo shop
                                        if (sceltaShop == 1) {
                                            graficheObj.tutorialShop();
                                            giocoObj.menuNegozio(persObj);
                                            sceltaShopInserita = true;
                                        }
                                        // Scelta che salta l'interazione con lo shop
                                        else if (sceltaShop == 0) {
                                            // TODO: TERMINA DEMO
                                            sceltaShopInserita = true;
                                        }
                                        // Inserimento errato
                                        else {
                                            System.out.println("\nInserimento errato...");
                                            sceltaShopInserita = false;
                                        }
                                    } while (sceltaShopInserita == false);

                                    graficheObj.combattimentoLab1();
                                    giocoObj.scontro(persObj, secondoMostro);
                                    // TODO: VERSIONI FUTURE AGGIUNGERE ALTRE SCELTE E CONTINUARE LA TRAMA, QUI PER
                                    // ORA VIENE INSERITA LA STAMPA FINALE (FINISCE LA DEMO)
                                }

                                monetaLanciata = true;
                            }
                            // Non lanciare la moneta
                            else if (scelta == 0) {
                                System.out.print(ANSI_GREEN
                                        + "\n>> Hai scelto di non utilizzare la moneta. Stai proseguendo l'esplorazione basandoti sui segnali del radar danneggiato.\n>> Sembra tu abbia trovato un oggetto\n"
                                        + ANSI_RESET);
                                Item spadaTrovata = new Arma(1, "Zweinhander", "Spada", 1, 0, 8);
                                persObj.aggiungiItem(spadaTrovata);

                                graficheObj.combattimentoLab1();
                                giocoObj.scontro(persObj, secondoMostro);
                                // Termina la demo
                                graficheObj.fineGiocoContinua();
                                monetaLanciata = true;
                            } else {
                                System.out.println(ANSI_RED + "\nOpzione sbagliata. Scegli tra 1 o 0\n" + ANSI_RESET);
                                monetaLanciata = false;
                            }
                        } while (monetaLanciata == false);

                        sceltaLab = true;
                    }
                    // Cerca via di fuga
                    else if (num == 2) {
                        System.out.println(ANSI_GREEN
                                + "\n>> Hai scelto di fuggire dal laboratorio e sei passato per una galleria.\n  A causa di una frana non è possibile tornare indietro%$@...\n  La galleria sta crollando - è consigliato cercare un riparo..."
                                + ANSI_RESET);
                        graficheObj.gameOver();
                        graficheObj.fineGiocoContinua();
                        sceltaLab = true;
                    }
                    // Inserimento out of range
                    else {
                        System.out.println(ANSI_RED + "\nOpzione sbagliata. Scegli tra 1 o 2\n" + ANSI_RESET);
                        sceltaLab = false;
                    }
                } while (sceltaLab == false);

                // Il gioco termina
                terminaGioco = true;
            }
            // Crediti di gioco
            else if (sceltaMenuPrincipale.equals("#")) {
                System.out.print("\n");
                graficheObj.creditiDiGioco();
                System.out.print("\n");
                terminaGioco = false;
            }
            // Termina il gioco
            else if (sceltaMenuPrincipale.equals("-")) {
                System.out.println(ANSI_BLUE + "\n------Grazie per aver giocato al nostro gioco!------" + ANSI_RESET);
                terminaGioco = true;
            }
            // Inserimento errato in input
            else if (!sceltaMenuPrincipale.equals("+") || !sceltaMenuPrincipale.equals("#")
                    || !sceltaMenuPrincipale.equals("-")) {
                System.out.println(ANSI_RED + "\nInserimento errato...\n" + ANSI_RESET);
                terminaGioco = false;
            }
        } while (terminaGioco == false);

        // Esempio di creazione del db shop, creazione tabella Item e popolamento di
        // essa
        // CreazioneShopDB.CreateDB();
        // Esempio stampa item del negozio
        // myShopObj.restituisciShop();
    }
}