package dev.Innocent.Section8.DataBase.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static String ARTIST_INSERT =
            "INSERT INTO music.artists (artist_name) VALUES (?)";
    private static String ALBUM_INSERT =
            "INSERT INTO music.albums (artist_id, album_name) VALUES (?, ?)";
    private static String SONG_INSERT =
            "INSERT INTO music.songs (album_id, track_number, song_title) " +
                    "VALUES (?, ?, ?)";

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");

        try {
            dataSource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = dataSource.getConnection(
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"));
        ) {
            String sql = "SELECT * FROM music.albumview where artist_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "Elf");
            ResultSet resultSet = ps.executeQuery();
//            printRecords(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
