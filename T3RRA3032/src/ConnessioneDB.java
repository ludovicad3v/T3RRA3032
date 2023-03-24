import java.sql.*;

public class ConnessioneDB 
{
    public static Connection CreateConnection(String url, String username, String password)
    {
        try 
        {
            Connection conn;

            conn = DriverManager.getConnection(url, username, password);

            //System.out.println(conn == null ? "Connessione non riuscita\n" : "Connessione avvenuta\n" );       //TODO: COMMENTA QUESTA RIGA QUANDO NELLA VERSIONE FINALE

            return conn;
        } 
        catch (Exception e) 
        {
            //System.out.println("ERRORE di connessione al database");
            return null;
        }
    }

    public static void ExecuteQuery(String query, Connection connection) 
    {
        if (connection == null)
            return;

        try 
        {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } 
        catch (SQLException e) 
        {
            //System.out.println("ERRORE " + e.getMessage());
        }
    }
}