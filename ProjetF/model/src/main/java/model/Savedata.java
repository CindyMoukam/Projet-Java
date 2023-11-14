package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Savedata {

    static String URL = "jdbc:mysql://localhost:3306/projet?serverTimezone=UTC&autoReconnect=true&useSSL=false";
    static String LOGIN = "root";
    static String PASSWORD = "cindy";


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {


            String filePath = "C:\\Users\\SOFT\\Desktop\\Projet Java\\ProjetF\\MAP1.txt";


            int x = 0;
            int y = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                int currentChar;
                while ((currentChar = reader.read()) != -1) {
                    char character = (char) currentChar;
                    saveToDatabase(connection, x, y, character);

                    // Incrémenter les coordonnées
                    x++;
                    if (character == '\n') {
                        x = 0;
                        y++;
                    }
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void saveToDatabase(Connection connection, int x, int y, char character) throws SQLException {
        String query = "INSERT INTO level (posx, posy, type, niveau_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, x);
            preparedStatement.setInt(2, y);
            preparedStatement.setString(3, String.valueOf(character));
            preparedStatement.setInt(4, 1); // Vous pouvez ajuster le niveau_id en fonction de vos besoins
            preparedStatement.executeUpdate();
        }
    }
}


