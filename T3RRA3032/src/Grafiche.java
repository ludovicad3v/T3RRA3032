import java.util.ArrayList;

/* ATTENZIONE! Per effettuare la stampa della giusta stringa (grafica) cambiare l'indice nei rispettivi
 * metodi nella stringa di codice " System.out.println(ambientiList.get(INDICE)); " ALTRIMENTI non stampa e da errore.
 * AGGIUNGERE LE NUOVE STRINGHE CREATE NEL METODO ordinamentoGrafiche()
 * Aggiornamento futuro: Creare un metodo per la generalizzazione della stampa degli item
 */
public class Grafiche {

        protected ArrayList<String> ambientiList; // ArrayList contente tutte le grafiche ambientali
        protected ArrayList<String> mostriList; // ArrayList contente tutte le grafiche mostri
        protected ArrayList<String> armiList; // ArrayList contente tutte le grafiche armi
        protected ArrayList<String> pozioniList; // ArrayList contente tutte le grafiche pozioni
        protected ArrayList<String> scudiList; // TODO: VALUTARE SE IMPLEMENTARE GLI SCUDI IN UNA PROSSIMA VERSIONE

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        String bridgeCity = """
                            ^^
                            ^^      ..                                       ..
                                    []                                       []
                                  .:[]:_          ^^                       ,:[]:.
                                .: :[]: :-.                             ,-: :[]: :.
                              .: : :[]: : :`._                       ,.': : :[]: : :.
                            .: : : :[]: : : : :-._               _,-: : : : :[]: : : :.
                        _..: : : : :[]: : : : : : :-._________.-: : : : : : :[]: : : : :-._
                        _:_:_:_:_:_:[]:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:[]:_:_:_:_:_:_
                        !!!!!!!!!!!![]!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!![]!!!!!!!!!!!!!
                        ^^^^^^^^^^^^[]^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^[]^^^^^^^^^^^^^
                                    []                                       []
                                    []                                       []
                                    []                                       []
                         ~~^-~^_~^~/  \\~^-~^~_~^-~_^~-^~_^~~-^~_~^~-~_~-^~_^/  \\~^-~_~^-~~-
                        ~ _~~- ~^-^~-^~~- ^~_^-^~~_ -~^_ -~_-~~^- _~~_~-^_ ~^-^~~-_^-~ ~^
                           ~ ^- _~~_-  ~~ _ ~  ^~  - ~~^ _ -  ^~-  ~ _  ~~^  - ~_   - ~^_~
                             ~-  ^_  ~^ -  ^~ _ - ~^~ _   _~^~-  _ ~~^ - _ ~ - _ ~~^ -
                                ~^ -_ ~^^ -_ ~ _ - _ ~^~-  _~ -_   ~- _ ~^ _ -  ~ ^-
                                    ~^~ - _ ^ - ~~~ _ - _ ~-^ ~ __- ~_ - ~  ~^_-
                                        ~ ~- ^~ -  ~^ -  ~ ^~ - ~~  ^~ - ~

                                    """;

        String titoloGioco = """
                        TTTTTTT  333333   RRRRRR   RRRRRR      AAA    333333    00000   333333    2222
                          TTT       3333  RR   RR  RR   RR    AAAAA      3333  00   00     3333  222222
                          TTT      3333   RRRRRR   RRRRRR    AA   AA    3333   00   00    3333       222
                          TTT        333  RR  RR   RR  RR    AAAAAAA      333  00   00      333   2222
                          TTT    333333   RR   RR  RR   RR  AA     AA  333333   00000   333333   2222222  *
                              """;

        // Grafica palazzi prima della distruzione della Terra
        String graficaCitta = """
                                 ________            _______
                                 /\\ \\ \\ \\/_______/     ______/\\      \\  /\\ \\/ /\\ \\/ /\\  \\_____________
                                /\\ \\ \\ \\/______ /     /\\    /:\\\\      \\ ::\\  /::\\  /::\\ /____  ____ __
                               /\\ \\ \\ \\/_______/     /:\\\\  /:\\:\\\\______\\::/  \\::/  \\::///   / /   //
                              /\\ \\ \\ \\/_______/    _/____\\/:\\:\\:/_____ / / /\\ \\/ /\\ \\///___/ /___//___
                        _____/___ \\ \\/_______/    /\\::::::\\\\:\\:/_____ / \\ /::\\  /::\\ /____  ____  ____
                                 \\ \\/_______/    /:\\\\::::::\\\\:/_____ /   \\\\::/  \\::///   / /   / /   /
                                  \\/_______/    /:\\:\\\\______\\/______/_____\\\\/ /\\ \\///___/ /___/ /_____
                        \\          \\______/    /:\\:\\:/_____:/\\      \\ ___ /  /::\\ /____  ____  _/\\::::
                        \\\\__________\\____/    /:\\:\\:/_____:/:\\\\      \\__ /_______/____/_/___/_ /  \\:::
                        //__________/___/   _/____:/_____:/:\\:\\\\______\\ /                     /\\  /\\::
                        ///\\          \\/   /\\ .----.\\___:/:\\:\\:/_____ // \\                   /  \\/  \\:
                        ///\\\\          \\  /::\\\\ \\_\\ \\\\_:/:\\:\\:/_____ //:\\ \\                 /\\  /\\  /\\
                        //:/\\\\          \\//\\::\\\\ \\ \\ \\\\/:\\:\\:/_____ //:::\\ \\               /  \\/  \\/+/
                        /:/:/\\\\_________/:\\/:::\\`----' \\\\:\\:/_____ //o:/\\:\\ \\_____________/\\  /\\  / /
                        :/:/://________//\\::/\\::\\_______\\\\:/_____ ///\\_\\ \\:\\/____________/  \\/  \\/+/\\
                        /:/:///_/_/_/_/:\\/::\\ \\:/__  __ /:/_____ ///\\//\\\\/:/ _____  ____/\\  /\\  / /  \\
                        :/:///_/_/_/_//\\::/\\:\\///_/ /_//:/______/_/ :~\\/::/ /____/ /___/  \\/  \\/+/\\  /
                        /:///_/_/_/_/:\\/::\\ \\:/__  __ /:/____/\\  / \\\\:\\/:/ _____  ____/\\  /\\  / /  \\/
                        :///_/_/_/_//\\::/\\:\\///_/ /_//:/____/\\:\\____\\\\::/ /____/ /___/  \\/  \\/+/\\  /\\
                        ///_/_/_/_/:\\/::\\ \\:/__  __ /:/____/\\:\\/____/\\\\/____________/\\  /\\  / /  \\/  \\
                        //_/_/_/_//\\::/\\:\\///_/ /_//::::::/\\:\\/____/  /----/----/--/  \\/  \\/+/\\  /\\  /
                        /_/_/_/_/:\\/::\\ \\:/__  __ /\\:::::/\\:\\/____/ \\/____/____/__/\\  /\\  / /  \\/  \\/_
                        _/_/_/_//\\::/\\:\\///_/ /_//\\:\\::::\\:\\/____/ \\_____________/  \\/  \\/+/\\  /\\  /
                        /_/_/_/:\\/::\\ \\:/__  __ /\\:\\:\\::::\\/____/   \\ _ _ _ _ _ /\\  /\\  / /  \\/  \\/___
                        _/_/_//\\::/\\:\\///_/ /_//\\:\\:\\:\\              \\_________/  \\/  \\/+/\\  /\\  /   /
                        /_/_/:\\/::\\ \\:/__  __ /\\:\\:\\:\\:\\______________\\       /\\  /\\  / /  \\/  \\/___/_
                        _/_//\\::/\\:\\///_/ /_//::\\:\\:\\:\\/______________/      /  \\/  \\/+/\\  /\\  /   /
                        /_/:\\/::\\ \\:/__  __ /::::\\:\\:\\/______________/\\     /\\  /\\  / /  \\/  \\/___/___
                        _//\\::/\\:\\///_/ /_//:\\::::\\:\\/______________/  \\   /  \\/  \\/+/\\  /\\  /   /   /
                        /:\\/::\\ \\:/__  __ /:\\:\\::::\\/______________/    \\ /\\  /\\  / /  \\/  \\/___/___/
                        /\\::/\\:\\///_/ /_//:\\:\\:\\                         \\  \\/\\\\\\/+/\\  /\\  /   /   /+/
                        \\/::\\ \\:/__  __ /:\\:\\:\\:\\_________________________\\ ///\\\\\\/  \\/  \\/___/___/ /_
                        ::/\\:\\///_/ /_//:\\:\\:\\:\\/_________________________////::\\\\\\  /\\  /   /   /+/
                        ::\\ \\:/__  __ /:\\:\\:\\:\\/_________________________/:\\/____\\\\\\/  \\/___/___/ /___
                        /\\:\\///_/ /_//:\\:\\:\\:\\/_________________________/:::\\    /\\/\\  /   /   /+/   /
                        \\ \\:/__  __ /:\\:\\:\\:\\/_________________________/:::::\\  ///  \\/___/___/ /___/_
                        :\\///_/ /_//:\\:\\:\\:\\/_________________________/:\\:::::\\///\\  /   /  __________
                        \\:/__  __ /:\\:\\:\\:\\/_________________________/:::\\:::::\\/  \\/___/__/\\
                        ///_/ /_//:\\:\\:\\:\\/_________________________/:\\:::\\:::::\\  /   /  /::\\
                        /__  __ /\\::\\:\\:\\/_________________________/_____::\\:::::\\/___/__/:/\\:\\
                        /_/ /_//::\\::\\:\\/_____________________/\\/_/_/_/_/\\  \\           /::\\ \\:\\
                        _  __ /:\\::\\:8\\/_____________________/\\/\\   /\\_\\\\/\\  \\ 8       /:/\\:\\ \\:\\
                        / /_//\\     \\|______________________//\\\\/\\::\\/__\\\\/\\  \\|______/::\\ \\:\\ \\:\\
                         __ /  \\  \\                        /:\\/:\\/\\_______\\/\\        /:/\\:\\ \\:\\/::\\
                        /_//    8      -8  --  --  --  -- //\\::/\\/_/_/_/_/_/ --  -- /::\\ \\:\\ \\::/\\:\\
                        _ /     |\\  \\   |________________/:\\/::\\///__/ /__//_______/:/\\:\\ \\:\\/::\\ \\:\\
                        __________\\     \\               //\\::/\\:/___  ___ /       /::\\ \\:\\ \\::/\\:\\ \\:\\
                        ::::::::::\\\\  \\  \\             /:\\/::\\///__/ /__//       /:/\\:\\ \\:\\/::\\ \\:\\ \\:""";

        String piantePrima = """
                                           .,,.
                                    .,v%;mmmmmmmm;%%vv,.
                                 ,vvv%;mmmvv;vvvmmm;%vvvv,    .,,.
                          ,, ,vvvnnv%;mmmvv;%%;vvmmm;%vvvv%;mmmmmmm,
                        ,mmmmmm;%%vv%;mmmvv;%%;vvmmm;%v%;mmmmmmmmmmm
                        mmmmmmmmmmm;%%;mmmvv%;vvmmm;%mmmmmmmmmmmmmm'
                        `mmmmmmmmmmmmmm%;mmv;vmmm;mmmmmmm;%vvvvvv'
                            `%%%%%;mmmmmmmm;v%v;mmmmmm;%vvvnnvv'
                             vvvvvv%%%%;mmmm%;mmmmmm;%vvvnnnnvv
                             `vvnnnnvvv%%%;m;mmmmm;%vvnnmmnnvv'
                              vvnmmnnnnvvv%%mmmm;%vvnnmmmnnnvv
                              `vvnmmmnnvvv%mmm;%vvnnmmmmnnnvv'
                               `vvnmmmmvv%mmm;%vvnnmmmmnnnvv'
                                `vvnmmmvv%mm;%vvvnnmmmnnvvv'
                                  `vvnmmvv%m;%vvvvnmnvvvv'
                                   .;;vvvvvm;%vvvvvvvv'
                                .;;;;;;;;;;;;;;;;;;;;,
                               ;;;;;;';;;;;;;;;;;'`;;;;;,
                              .;;;'    `;;;;;;;;'   `;;;;;.
                             .;;'        `;;;;;'      `;;;;
                             ;'           :`;;'         ;;'
                             ;            : ;'    ,    ,'             .
                              `           :'.:   .;;,.        .,;;;;;;'
                                          ::::   ;;,;;;,     ;;;,;;;;'
                                          ;;;;   `;;;,;;    .,';;;;'
                                          ;;;;      `';; ,;;'
                                        ,;;;;;         .;',.
                                          `;;;;       .;'  ';,.
                                           `;;;.     .;'   ,;;,;;,.
                                            ;;;;    .;'    `;;;;,;;;
                                            ;;;;   .;'       `;;,;;'
                                            `;;;,;;'           `;'
                                             ;;;;
                                             ;;;;.
                                             `;;;;;,.
                                              ;;;;'
                                              ;;;;
                                              ;;;;
                                                    """;

        // Titolo laboratorio
        String textLaboratorio = """
                        _        _______  ______   _______  _______  _______ _________ _______  _______
                        ( \\      (  ___  )(  ___ \\ (  ___  )(  ____ )(  ___  )\\__   __/(  ___  )(  ____ )|\\     /|
                        | (      | (   ) || (   ) )| (   ) || (    )|| (   ) |   ) (   | (   ) || (    )|( \\   / )
                        | |      | (___) || (__/ / | |   | || (____)|| (___) |   | |   | |   | || (____)| \\ (_) /
                        | |      |  ___  ||  __ (  | |   | ||     __)|  ___  |   | |   | |   | ||     __)  \\   /
                        | |      | (   ) || (  \\ \\ | |   | || (\\ (   | (   ) |   | |   | |   | || (\\ (      ) (
                        | (____/\\| )   ( || )___) )| (___) || ) \\ \\__| )   ( |   | |   | (___) || ) \\ \\__   | |
                        (_______/|/     \\||/ \\___/ (_______)|/   \\__/|/     \\|   )_(   (_______)|/   \\__/   \\_/

                            """;

        // Interno del laboratorio, da finire
        String graficaLabInterno = """
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|
                            |x|x|x|x|                                            |            |x|x|x|x|
                            |x|x|x|x|     ^^^^              /**/                 |            |x|x|x|x|
                            |x|x|x|x|     |  |             /****/                |            |x|x|x|x|
                            |x|x|x|x|                      /**/                  |            |x|x|x|x|
                            |x|x|x|x|                                            \\============|x|x|x|x|
                            |x|x|x|x|                                                         |x|x|x|x|
                            |x|x|x|x|                                                         |x|x|x|x|
                            |x|x|x|x|               (                                         |x|x|x|x|
                            |x|x|x|x|                *                                        |x|x|x|x|
                            |x|x|x|x|                  )                           ?1?        |x|x|x|x|
                            |x|x|x|x|                                                         |x|x|x|x|
                            |x|x|x|x|     ?22               ?|EXIT?|?                   ?3?   |x|x|x|x|
                            |x|x|x|x|                           v                             |x|x|x|x|
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x-----x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|-*-*-*-|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|
                            |x|x|x|x|x|x|x||x|x|x|x|x|x|x||x|x-----x|x|x||x|x|x|x|x|x|x||x|x|x|x|x|x|x|

                        """;

        String mostroLaboratorio = """

                              _, - -~~~,
                             .'           `.
                            |              ;
                            |              :
                            /_,-==/        .'
                          /'`\\*=  ;        :
                        :'    `-            :
                        `~*,'     .          :
                           :__.,._  `;      :
                           `\\'    )  '    `,
                               \\-/  '       )
                               :'            \\ _
                                `~---,-~    `,)
                                     \\     /~`\


                              """;

        String mostroNonIdentificato = """

                                 .                                                      .
                                .n                   .                 .                  n.
                          .   .dP                  dP                   9b                 9b.    .
                         4    qXb         .       dX                     Xb       .        dXp     t
                        dX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb
                        9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP
                         9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP
                          `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'
                            `9XXXXXXXXXXXP' `9XX'   NOT    `98v8P'  HUMAN   `XXP' `9XXXXXXXXXXXP'
                                ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~
                                                )b.  .dbo.dP'`v'`9b.odb.  .dX(
                                              ,dXXXXXXXXXXXb     dXXXXXXXXXXXb.
                                             dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb
                                            dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb
                                            9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP
                                             `'      9XXXXXX(   )XXXXXXP      `'
                                                      XXXX X.`v'.X XXXX
                                                      XP^X'`b   d'`X^XX
                                                      X. 9  `   '  P )X
                                                      `b  `       '  d'
                                                       `             '


                                                """;

        String skullMorte = """
                                 _,.-------.,_
                             ,;~'             '~;,
                           ,;                     ;,
                          ;                         ;
                         ,'                         ',
                        ,;                           ;,
                        ; ;      .           .      ; ;
                        | ;   ______       ______   ; |
                        |  `/~"     ~" . "~     "~\\'  |
                        |  ~  ,-~~~^~, | ,~^~~~-,  ~   |
                         |   |        }:{        |     |
                         |   l       / | \\       !   |
                         .~  (__,.--" .^. "--.,__)  ~.
                         |     ---;' / | \\ `;---     |
                          \\__.       \\/^\\/       ._/
                           V| \\                 / |V
                            | |T~\\___!___!___/~T| |
                            | |`IIII_I_I_I_IIII'| |
                            |  \\,III I I I III,/  |
                             \\   `~~~~~~~~~~'    /
                               \\   .       .   /            GAME OVER,
                                 \\.    ^    ./              SEI MORTO.
                                   ^~~~^~~~^
                                     """;

        String pozioneGenerica = """

                         ___
                         )-(
                        (   )
                        |   |
                        |~~~|
                        |___|

                                """;

        String spada1 = """

                           ^
                          / \\
                          | |
                          | |
                          |.|
                          |.|
                          |:|
                          |:|
                        `--|--´
                           |
                           *
                                          """;

        String spada2 = """

                             .
                            /:\\
                            |:|
                            |:|
                            |:|
                            |:|
                            |:|
                            |:|
                            |:|
                            |:|
                            |:|
                        /]  |:|  [\\
                        \\ :-***-: /
                          ""I*I""
                            I*I
                            I*I
                            I*I
                           (___)

                                            """;

        String martello = """

                         ______.==.______
                        |                |
                        |            *   |
                        |  **            |
                        |________________|
                               |  |
                               |  |
                               |  |
                               |  |
                               |  |
                               |  |
                               |  |
                                ==

                                        """;

        // Laboratorio prima della distruzione
        String labOld = """
                                                                                         |
                                                                 |
                                                                 |
                                                                 |
                           _______                   ________    |
                          |ooooooo|      ____       | __  __ |   |
                          |[]+++[]|     [____]      |/  \\/  \\|   |
                          |+ ___ +|     ]()()[      |\\__/\\__/|   |
                          |:|   |:|   ___\\__/___    |[][][][]|   |
                          |:|___|:|  |__|    |__|   |++++++++|   |
                          |[]===[]|   |_|_/\\_|_|    | ______ |   |
                        _ ||||||||| _ | | __ | | __ ||______|| __|
                          |_______|   |_|[::]|_|    |________|   \\
                                      \\_|_||_|_/                 \\
                                        |_||_|                     \\
                                       _|_||_|_                     \\
                              ____    |___||___|                     \\
                             /  __\\          ____                     \\
                             \\( oo          (___ \\                     \\
                             _\\_o/           oo~)/
                            / \\|/ \\         _\\-_/_
                           / / __\\ \\___    / \\|/  \
                           \\ \\|   |__/_)  / / .- \\ \
                            \\/_)  |       \\ \\ .  /_/
                             ||___|        \\/___(_/
                             | | |          | |  |
                             | | |          | |  |
                             |_|_|          |_|__|
                             [__)_)        (_(___]
                                                """;

        // Titolo dello Shop
        String titoloShop = """
                 ____       / __        ___        ___    
                ((   ) )   //   ) )   //   ) )   //   ) ) 
                 \\ \\      //   / /   //   / /   //___/ /  
              //___) )   //   / /   ((___/ /   //    
                        """;

        public Grafiche() {
                this.ambientiList = new ArrayList<>();
                this.mostriList = new ArrayList<>();
                this.armiList = new ArrayList<>();
        }

        public void ordinamentoGrafiche() {
                ambientiList.add(graficaCitta); // 0
                // tramaIniziale non e' una stringa ma e' tutto nel metodo
                ambientiList.add(textLaboratorio); // 1
                ambientiList.add(graficaLabInterno); // 2
                ambientiList.add(titoloGioco); // 3
                ambientiList.add(piantePrima); // 4
                ambientiList.add(pozioneGenerica); // 5
                ambientiList.add(spada1); // 6
                ambientiList.add(spada2); // 7
                ambientiList.add(martello); // 8
                ambientiList.add(mostroLaboratorio); // 9
                ambientiList.add(skullMorte); // 10
                ambientiList.add(mostroNonIdentificato); // 11
                ambientiList.add(bridgeCity); // 12
                ambientiList.add(titoloShop); // 13
                // ambientiList.add(labOld);
                // ambientiList.add(cittaDistrutta);
        }

        // Metodi per la visualizzazione della vita del personaggio
        public String hpMax(int vita) {
                return (ANSI_WHITE + "SALUTE" + ANSI_RESET + ANSI_GREEN + " | <3 <3 <3 <3 <3 | " + vita + ANSI_RESET);
        }

        public String hpMedium(int vita) {
                return (ANSI_WHITE + "SALUTE" + ANSI_RESET + ANSI_YELLOW + " | <3 <3 <3 | " + vita + ANSI_RESET);
        }

        public String hpLow(int vita) {
                return (ANSI_WHITE + "SALUTE" + ANSI_RESET + ANSI_RED + " | <3 | " + vita + ANSI_RESET);
        }

        // Metodi per la visualizzazione della Stamina del personaggio
        public String staminaMax(int stamina) {
                return (ANSI_CYAN + "STAMINA" + ANSI_RESET + ANSI_GREEN + " | * * * * * | " + stamina + ANSI_RESET);
        }

        public String staminaMedium(int stamina) {
                return (ANSI_CYAN + "STAMINA" + ANSI_RESET + ANSI_YELLOW + " | * * * | " + stamina + ANSI_RESET);
        }

        public String staminaLow(int stamina) {
                return (ANSI_CYAN + "STAMINA" + ANSI_RESET + ANSI_RED + " | * | " + stamina + ANSI_RESET);
        }

        // Metodi per la visualizzazione della Forza del personaggio
        public String forzaMax(double forza) {
                return (ANSI_PURPLE + "FORZA" + ANSI_RESET + ANSI_GREEN + " | + + + + + | "
                                + String.format("%.2f", forza) + ANSI_RESET);
        }

        public String forzaMedium(double forza) {
                return (ANSI_PURPLE + "FORZA" + ANSI_RESET + ANSI_YELLOW + " | + + + | " + String.format("%.2f", forza)
                                + ANSI_RESET);
        }

        public String forzaLow(double forza) {
                return (ANSI_PURPLE + "FORZA" + ANSI_RESET + ANSI_RED + " | + | " + String.format("%.2f", forza)
                                + ANSI_RESET);
        }

        public void mainMenu() { /*
                                  * Scenario 0 - Menu Iniziale con nome gioco e scelta INIZIA NUOVA PARTITA,
                                  * ESCI, CREDITI
                                  */
                // Stampa del titolo TEST
                System.out.println(ANSI_GREEN + ambientiList.get(3) + ANSI_RESET + "\n\n");
                System.out.println(ANSI_PURPLE
                                + "\n                  == == == == == == " + ANSI_RESET + ANSI_CYAN + " DIGITA "
                                + ANSI_RESET + ANSI_PURPLE
                                + " == == == == == == \n"
                                + ANSI_RESET);
                System.out.println(ANSI_PURPLE
                                + "                              * [" + ANSI_RESET + ANSI_YELLOW + "+" + ANSI_RESET
                                + ANSI_PURPLE
                                + "] NUOVA PARTITA *\n                             " + ANSI_RESET + ANSI_CYAN
                                + "--------------------" + ANSI_RESET
                                + ANSI_PURPLE + "\n                             * [" + ANSI_RESET + ANSI_GREEN + "#"
                                + ANSI_RESET + ANSI_PURPLE
                                + "] CREDITI DI GIOCO *\n                             " + ANSI_RESET + ANSI_CYAN
                                + "--------------------" + ANSI_RESET
                                + ANSI_PURPLE + "\n                                  * [" + ANSI_RESET + ANSI_RED + "-"
                                + ANSI_RESET + ANSI_PURPLE
                                + "] ESCI *"
                                + ANSI_RESET);
                System.out.println(ANSI_PURPLE
                                + "\n                  == == == == == == == == == == == == == == == \n"
                                + ANSI_RESET);
                System.out.println(ANSI_CYAN + "\n\n                          A *CyberSolutions* Project\n\n"
                                + ANSI_RESET);

        } // la scelta Nuova Partita corrisponde alla stampa di graficaIniziale,
          // graficaIniziale2 e tramaIniziale

        public void creditiDiGioco() {
                System.out.println(ANSI_GREEN + ambientiList.get(3) + ANSI_RESET); // Stampa titolo del gioco
                System.out.println("\nGioco realizzato dal team " + ANSI_CYAN + "CyberSolutions" + ANSI_RESET
                                + " composto da:\nMandis Federico\nPangrazio Maria Antonietta Ludovica\nCesare Federico Sgaramella\nAlcuni degli ASCII per la grafica di gioco sono stati\nmodificati da ASCII preesistenti (www.asciiart.eu\n| www.asciiworld.com)\n\n"
                                + ANSI_CYAN + "Contatti:" + ANSI_RESET + ANSI_YELLOW
                                + "\nmandisfederico@gmail.com\ngithub: FedericoMNDS\n\nludovicapangrazio@gmail.com\ngithub: LudovicaPangrazio\n\nfederico.sgaramella12@gmail.com\ngithub: R3tr0R4ke"
                                + ANSI_RESET);
        }

        public void gameOver() { // Schermata morte
                System.out.println(ANSI_RED + ambientiList.get(10) + ANSI_RESET);

        }

        public void graficaIniziale() // Scenario 1 — Inizio storia con visualizzazione della Terra prima della
                                      // distruzione (Stile glitch)
        {
                // Esempio di stampa del primo ambiente
                System.out.println(ANSI_WHITE + ambientiList.get(0) + ANSI_RESET + "\n");
                System.out.println(
                                ANSI_CYAN + "La Terra, un tempo abitata... Grandi edifici. -%$#3; %$ Circa 1072>.:[{])}]"
                                                + ANSI_RESET);
                System.out.println(ANSI_WHITE + ambientiList.get(12) + ANSI_RESET + "\n");
                System.out.println(ANSI_GREEN
                                + "Ormai... tutto e' stato distrutto... %^7&*(_-_=+/{%@#^})" + ANSI_RESET + ANSI_CYAN
                                + "\nQuesto messaggio e' danneggiato.. Impossibile leggere il contenuto compl3t0%\n"
                                + ANSI_RESET);
        }

        public void graficaIniziale2() {
                System.out.println(ANSI_GREEN + ambientiList.get(4) + ANSI_RESET);
                System.out.println(ANSI_CYAN
                                + "Pi4nt%e e fiori di ogni tipo pop^olavano la Terra... Ormai restano solo piante carnivore, mutanti\n"
                                + ANSI_RESET);
        }

        public void tramaIniziale() { // Inizio del gioco
                System.out.println(ANSI_PURPLE
                                + "==========================================================================================================="
                                + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "░➤ " + ANSI_RESET + ANSI_GREEN
                                + "Questi sono antichi ricordi, framm%6enti di una civilta' perduta... prima della Totale Distruzi1one.\n\nOrmai siamo nel 3032 e infinte batt%aglie hanno stravolto il territorio,\nrendendo il nostro pianeta ostile e tossico.\nTe ne renderai conto presto, appena ti sarai sv&gliato."
                                + ANSI_RESET + ANSI_GREEN
                                + "\n\nSe stai leggendo questo messaggio probabi#lmente stai interagendo con la tua cos#cienza."
                                + ANSI_RESET + ANSI_CYAN
                                + "\nComplimenti, significa che sei uno dei pochi esseri senzienti ancora sulla Te@$rra.\n\nNon sai cosa ti aspetta, ma potrai scoprirlo solo se deciderai di svegl^iarti.\n"
                                + ANSI_RESET + ANSI_PURPLE + "░➤ " + ANSI_RESET + ANSI_CYAN + "Sei pronto, *%$!(=+?"
                                + ANSI_RESET);
                System.out.println(ANSI_PURPLE
                                + "==========================================================================================================="
                                + ANSI_RESET);
                // a questa introduzione grafica segue la scelta del giocatore di creare la
                // partita e impostare il nome del personaggio

        }

        public void Laboratorio() {

                System.out.println(ANSI_YELLOW + ambientiList.get(1) + ANSI_RESET);
                System.out.println(ambientiList.get(2));
                System.out.println(ANSI_GREEN + "Ti trovi nel laboratorio, ricordi? Probabilmente no.\n" + ANSI_RESET
                                + ANSI_CYAN
                                + "Ormai e' tutto distrutto, e l'elettricita' non e' disponibile in questa zona del Pianeta.\n"
                                + ANSI_RESET);
                System.out.println(ANSI_CYAN
                                + "Se vuoi puoi guardarti intorno, magari riuscirai a trovare qualcosa di utile per scappare da qui.\n"
                                + ANSI_RESET + ANSI_GREEN
                                + "Sembra che qualcuno...o qualcosa si stia avvicinando. Meglio fare in fretta.\n"
                                + ANSI_RESET + ANSI_YELLOW + "Scegli un'opzione:\n" + ANSI_RESET);
                // A cio' segue la scelta del giocatore fra Esplora(Trova pozione random), Cerca
                // una via di fuga(Si imbatte in un mostro e parte il combattimento)
        }

        // Metodi da visualizzare quando il giocatore trova un Item pozione
        public void pozioneSaluteTrovata() {
                System.out.println(ANSI_GREEN + ambientiList.get(5) + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Adesso possiedi una Pozione di Rigenerazione! Usala con saggezza."
                                + ANSI_RESET);
        }

        public void pozioneStaminaTrovata() {
                System.out.println(ANSI_CYAN + ambientiList.get(5) + ANSI_RESET);
                System.out.println(
                                ANSI_YELLOW + "Adesso possiedi una Pozione di Incremento Stamina! Usala con saggezza."
                                                + ANSI_RESET);
        }

        public void pozioneForzaTrovata() {
                System.out.println(ANSI_RED + ambientiList.get(5) + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Adesso possiedi una Pozione di Incremento Forza! Usala con saggezza."
                                + ANSI_RESET);
        }

        public void spada1Trovata() { // Metodo da visualizzare quando trova la spada meno forte
                System.out.println(ANSI_WHITE + ambientiList.get(6) + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Adesso possiedi Zweinhander! Usala con attenzione." + ANSI_RESET);

        }

        public void spada2Trovata() { // Metodo da visualizzare quando trova la spada piu' forte
                System.out.println(ANSI_WHITE + ambientiList.get(7) + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Adesso possiedi Broadsword! Usala con attenzione." + ANSI_RESET);
        }

        public void martelloTrovato() {
                System.out.println(ANSI_WHITE + ambientiList.get(8) + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Adesso possiedi il Martello di Smough! Usalo con attenzione."
                                + ANSI_RESET);
        }

        public void combattimentoLab1() {
                System.out.println(ANSI_GREEN + ambientiList.get(9) + ANSI_RESET);
                System.out.println(ANSI_RED + "ATTENZIONE! " + ANSI_RESET + ANSI_YELLOW
                                + "Un mutante si sta avvicinando... Sei costretto a combattere." + ANSI_RESET);
        }

        public void secondoCombattimento() {
                System.out.println(ANSI_RED + ambientiList.get(11) + ANSI_RESET);
                System.out.println(ANSI_RED + "ATTENZIONE! " + ANSI_RESET + ANSI_YELLOW
                                + "Una creatura non identificata si sta avvicinando... Sei costretto a combattere."
                                + ANSI_RESET);

        }

        public void tutorialShop(){
                System.out.print(ANSI_YELLOW + ambientiList.get(13) + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "\n\n********** ********** / == / == / == / == / == / == / == / == / == / == / == / == / ********** **********" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "\n$%^Se pensi di essere invincibile ti sbagli."+ANSI_RESET+ANSI_CYAN+"\nPer fortuna l'ultimo collegamento alla Centrale permette di acquistare degli oggetti che ti saranno utili durante questo viaggio.\nNel menu' dello shop potrai scegliere se visualizzare gli oggetti acquistabili, se visualizzare ed acquistare qualcosa digitando l'ID o uscire dallo Shop.\nSono rimaste armi e pozioni che ti permetteranno di essere piu' forte... O di sopravvivere.\nBuona fortuna. &*%"+ ANSI_RESET);
                System.out.println(ANSI_GREEN +"In seguito alla guerra la valuta ha perso il suo valore, di conseguenza userai i Punti Esperienza per effettuare qualsiasi tipo di acquisto.\n" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "********** ********** / == / == / == / == / == / == / == / == / == / == / == / == / ********** **********" + ANSI_RESET);

        }

        public void fineGiocoContinua(){
                System.out.println(ANSI_PURPLE + "\n\n********** ********** / == / == / == / == / == / == / == / == / == / == / == / == / ********** **********\n" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + """
                          ___        ___         __     __  ___    ( )       __                   ___    
                        //   ) )   //   ) )   //   ) )   / /      / /     //   ) )   //   / /   //   ) ) 
                       //         //   / /   //   / /   / /      / /     //   / /   //   / /   //   / /  
                      ((____     ((___/ /   //   / /   / /      / /     //   / /   ((___( (   ((___( (   . . .
                      
                                """ + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "********** ********** / == / == / == / == / == / == / == / == / == / == / == / == / ********** **********" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "\u2665 Grazie per aver giocato, seguici su GitHub per restare aggiornato e scaricare i nuovi aggiornamenti! \u2665" + ANSI_RESET);
        }
}