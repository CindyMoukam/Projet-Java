package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.collections;
import java.util.List;


public class DAOTest {
    static String URL = "jdbc:postgresql://localhost:5432/boulderdash";
    static String LOGIN = "postgres";
    static String PASSWORD = "Jin800##";
    Connection connection;
    Statement statement;


    public DAOTest(){
        this.connection = null;
        this.statement = null;
    }

    public List<Tuile> open(){

        System.out.println("Initialize the conection at the database");
        List<Tuile> tuiles = new ArrayList<>();
        List<Tuile> tuiles2 = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DAOTest.URL, DAOTest.LOGIN, DAOTest.PASSWORD);
            this.statement = this.connection.createStatement();
            String requete = "SELECT * FROM maps WHERE level = '1'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Stocker les données récupérées dans une liste
                    while (resultSet.next()) {
                        int posX = resultSet.getInt("posx");
                        int posY = resultSet.getInt("posy");
                        String type = resultSet.getString("type");

                        Sprite sprite = new Sprite();
                        BufferedImage image = null;

                        image = sprite.getImage(type);

                        //Sprite sprite = new Sprite(type,"");

                        Tuile tuile = new Tuile(posX, posY, type);
                        tuiles.add(tuile);
                        Tuile tuile2 = new Tuile(posX, posY, image);
                        tuiles2.add(tuile2);
                    }
                }
            }

        }
        catch(final ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }

        for (Tuile tuile : tuiles) {
            System.out.printf("On the position (%d, %d) : %s\n", tuile.getPosx(), tuile.getPosy(), tuile.getType());
        }
        System.out.println("Connection is Ok... All of the data are loaded");
        return tuiles2;
    }

    private void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Gérer ou logger l'exception de fermeture de la connexion
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOTest dao = new DAOTest();
        dao.open();
    }

}
