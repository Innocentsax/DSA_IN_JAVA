package dev.Innocent.Section8.DataBase.QueryMusic;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();
        try{
            prop.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("port")));
        dataSource.setDatabaseName(prop.getProperty("databaseName"));
    }
}
