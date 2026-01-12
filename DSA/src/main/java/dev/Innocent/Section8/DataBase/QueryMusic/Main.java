package dev.Innocent.Section8.DataBase.QueryMusic;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();
        try{
            prop.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        String albumName = "Tapestry";

//        String query = "SELECT * FROM music.artists";

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("port")));
        dataSource.setDatabaseName(prop.getProperty("databaseName"));
        try {
            dataSource.setMaxRows(10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an Artist Id: ");
//        String artistId = scanner.nextLine();
//        int artistid = Integer.parseInt(artistId);
        String query = "SELECT * FROM music.artists limit 10";

        try(var connection = dataSource.getConnection(prop.getProperty("user"),
                System.getenv("MYSQL_PASS")); Statement statement = connection.createStatement();)
        {

            ResultSet resultSet = statement.executeQuery(query);

            var meta = resultSet.getMetaData();
//            for(int i = 1; i <= meta.getColumnCount(); i++){
//                System.out.printf("%d %s %s%n",
//                        i,
//                        meta.getColumnName(i),
//                        meta.getColumnTypeName(i));
//            }
            System.out.println("================================");


            BigDecimal a = BigDecimal.valueOf(1000);

            for(int i = 1; i <= meta.getColumnCount(); i++){
                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
            }
            System.out.println();
            while (resultSet.next()){
//                System.out.printf("%d %s %s %n",
//                        resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title"));

                for(int i = 1; i <= meta.getColumnCount(); i++){
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
