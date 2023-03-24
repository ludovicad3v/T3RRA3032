import java.sql.*;

public class Negozio {
    /*
     * Classe Negozio con attributi: id item, prezzo e collegamento al DB dello Shop
     */
    private static Statement stmt = null;
    Connection connection = ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/shop", "root", "root");

    public void restituisciShop() throws SQLException {
        resistuisciTabella(connection);
    }

    public void acquistaItem(int idItemSceltoUtente, Personaggio p) throws SQLException {
        acquistaItem(connection, idItemSceltoUtente, p);
    }

    public static void acquistaItem(Connection connection, int idItem, Personaggio p) {
        try {
            stmt = connection.createStatement();
            // Scelta dell'item da acquistare

            String queryScelta = "SELECT * FROM shop.item WHERE ID = " + idItem;
        
            ResultSet rsScelta = stmt.executeQuery(queryScelta);
            rsScelta.next();
            String nome = rsScelta.getString("nomeItem");
            String tipo = rsScelta.getString("tipoOggetto");
            int prezzo = rsScelta.getInt("prezzoExp");
            int disponibilita = rsScelta.getInt("disponibilita");
            int potenza = rsScelta.getInt("potenza");
            String descrizione = rsScelta.getString("descrizione");

            // Controllo della disponibilità e aggiornamento dell'inventario
            // AGGIUNGI ANCHE IL CONTROLLO SUL PREZZO DELL'EXP

            if (disponibilita > 0) {
                String query = "UPDATE Item SET disponibilita = disponibilita - 1 WHERE ID = " + idItem;
                stmt.executeUpdate(query);
                //Controllo del exp che ha il personaggio
                if (p.getExp() > prezzo)
                {
                    p.aggiungiItem(new Pozione(1, nome, disponibilita, prezzo, potenza));
                    System.out.println("\nAcquisto effettuato con successo.");
                }
                else
                {
                    System.out.println("\nPunti Exp insufficienti.");
                }
            } 
            else {
                System.out.println("\nElemento non disponibile.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resistuisciTabella(Connection connection) {
        try {
            stmt = connection.createStatement();
            // Indico la tabella da prendere
            String query = "SELECT * FROM shop.item WHERE disponibilita > 0;";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int colonne = meta.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= colonne; i++) {
                    System.out.println(meta.getColumnName(i) + ": " + rs.getString(i));
                }
                System.out.println("__________________\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}