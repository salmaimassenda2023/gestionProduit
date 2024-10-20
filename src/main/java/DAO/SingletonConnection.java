package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class SingletonConnection {
    private static Connection connection;
    static {

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //etablir la connection a la base de donnees
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduit","root","Salma@imassenda123");
            System.out.println("la connection est etablie avec succes !!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static Connection getConnection(){ return connection ;}

}
