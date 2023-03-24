import java.sql.*;

public class CreazioneShopDB 
{
    public static void CreateDB() 
    {
        //Creazione del db shop
        CreateDB(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/", "root", "root"));
        //Creazione delle tabelle nel db shop
        CreateTables(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/shop", "root", "root"));
        //Popolamento della tabella
        InsertRecords(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/shop", "root", "root"));
    }

    
    //Metodo per creare il database shop
    static void CreateDB(Connection connection) 
    {
        if (connection == null)
        {
            return;
        }
            
        try 
        {
            String sql = "CREATE DATABASE IF NOT EXISTS shop";
            
            try(Statement stmt = connection.createStatement()) 
            {
                //Eseguo la query per la creazione del db
                stmt.execute(sql);
                //System.out.println("Database creato con successo."); 
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    static void CreateTables(Connection connection) {
        String query;
     
        query =
        "create table IF NOT EXISTS Item( " +
            "ID int not null, " +
            "nomeItem varchar(250) unique not null, " +
            "tipoOggetto enum('Spada', 'Martello', 'Pozione', 'Materiale') default 'Spada', " +
            "prezzoExp int not null, " +
            "disponibilita int not null, " +
            "potenza int default null, " +
            "descrizione enum ('VITA', 'STAMINA', 'FORZA') default null, " +
            "primary key (ID) " +
        "); ";
        ConnessioneDB.ExecuteQuery(query, connection);
      
        //System.out.println("Inserimento tabelle terminato");      //COMMENTA QUESTA RIGA QUANDO NON SERVE PIU
    }

    static void InsertRecords (Connection connection)
    {
        String query;

        query =
        "insert into item (ID, nomeItem, tipoOggetto, prezzoExp, disponibilita, potenza, descrizione) " +
        "select * " +
        "from " +
        "( " +
            "select * " +
            "from " +
            "( " +
                "select 1 as ID_item, 'Revitalix' as nome_Item, 'Pozione' as tipo_Oggetto, 50 as prezzo_Exp, 15 as disponibilita, null as potenza, 'VITA' as descrizione " +
            ") as temp_1 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 1 " +
            ") " +
            "union all " +
            "select * " +
            "from " +
            "( " +
                "select 2 as ID_item, 'Infuso Proteico' as nome_Item, 'Pozione' as tipo_Oggetto, 150 as prezzo_Exp, 15 as disponibilita, null as potenza, 'FORZA' as descrizione " +
            ") as temp_2 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 2 " +
            ") " +
            "union all " +
            "select * " +
            "from " +
            "( " +
                "select 3 as ID_item, 'EnergyFuel' as nome_Item, 'Pozione' as tipo_Oggetto, 75 as prezzo_Exp, 15 as disponibilita, null as potenza, 'STAMINA' as descrizione " +
            ")as temp_3 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 3 " +
            ") " +
            "union all " +
            "select * " +
            "from " +
            "( " +
                "select 4 as ID_item, 'broadsword' as nome_Item, 'Spada' as tipo_Oggetto, 200 as prezzo_Exp, 5 as disponibilita, 10 as potenza, null as descrizione " +
            ")as temp_4 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 4 " +
            ") " +
            "union all " +
            "select * " +
            "from " +
            "( " +
                "select 5 as ID_item, 'Zweinhander' as nome_Item, 'Spada' as tipo_Oggetto, 250 as prezzo_Exp, 5 as disponibilita, 15 as potenza, null as descrizione " +
            ") as temp_5 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 5 " +
            ") " +
            "union all " +
            "select * " +
            "from " +
            "( " +
                "select 6 as ID_item, 'martello di Smough' as nome_Item, 'Martello' as tipo_Oggetto, 225 as prezzo_Exp, 3 as disponibilita, 17 as potenza, null as descrizione " +
            ") as temp_6 " +
            "where not exists " +
            "( " +
                "select ID_item from item where ID_item = 6 " +
            ") " +
        ") as alias_item_details; ";
        ConnessioneDB.ExecuteQuery(query, connection);

        //System.out.println("Popolamento tabelle completato");       //Commenta questa riga a versione ultimata
    }
}