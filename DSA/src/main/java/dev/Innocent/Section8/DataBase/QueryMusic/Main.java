package dev.Innocent.Section8.DataBase.QueryMusic;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();
        try{
            prop.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String albumName = "Tapestry";
        String query = "SELECT * FROM music.albumview WHERE album_name='%s'".formatted(albumName);
//        String query = "SELECT * FROM music.artists";

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("port")));
        dataSource.setDatabaseName(prop.getProperty("databaseName"));

        try(var connection = dataSource.getConnection(prop.getProperty("user"),
                System.getenv("MYSQL_PASS")); Statement statement = connection.createStatement();)
        {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.printf("%d %s %s %n",
                        resultSet.getInt("track_number"),
                        resultSet.getString("artist_name"),
                        resultSet.getString("song_title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
