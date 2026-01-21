package dev.Innocent.Section8.DataBase.QueryMusic;

import java.sql.*;

public class MusicDML {
    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/music",
                System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"));
            Statement statement = connection.createStatement();
        ){
//            String artist = "Neil Young";
//            String query = "SELECT * FROM artists WHERE artist_name='%s'".formatted(artist);
//            boolean result = statement.execute(query);
//            System.out.println("result = " + result);
//            var rs = statement.getResultSet();
//            boolean found = (rs != null && rs.next());
//            System.out.println("Artist was " + (found ? "found" : "not found"));

            String tableName = "music.artists";
            String columnName = "artist_name";
            String columnValue = "Innocent Udo";
            if(!executeSelect(statement, tableName, columnName, columnValue)){
                System.out.println("Maybe we should add this record");
                insertRecord(statement, tableName, new String[]{columnName}, new String[]{columnValue});

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean printRecords(ResultSet resultSet) throws SQLException{
        boolean foundData = false;
        var meta = resultSet.getMetaData();
        System.out.println("===================");

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
            foundData = true;
        }
        return foundData;
    }

    private static boolean executeSelect(Statement statement, String table,
                                         String columnName, String columnValue) throws SQLException{
        String query = "SELECT * FROM %s WHERE %s='%s'".formatted(table, columnName, columnValue);
        var rs = statement.executeQuery(query);
        if(rs != null){
            return printRecords(rs);
        }
        return false;
    }

    private static boolean insertRecord(Statement statement, String table,
                                        String[] columnNames, String[] columnValues) throws SQLException{
        String colNames = String.join(",", columnNames);
        String colValues = String.join("','", columnValues);
        String query = "INSERT INTO %s (%s) VALUES ('%s')".formatted(table, colNames, colValues);
        System.out.println(query);
        boolean insertResult = statement.execute(query);
        int recordsInserted = statement.getUpdateCount();
        if(recordsInserted > 0){
            executeSelect(statement, table, columnNames[0], columnValues[0]);
        }
        return recordsInserted > 0;
    }

    private static boolean deleteRecord(Statement statement, String table,
                                        String columnName, String columnValue) throws SQLException {
        String query = "DELETE FROM %s WHERE %s='%s'".formatted(table, columnName, columnValue);
        System.out.println(query);
        statement.execute(query);
        int recordsDeleted = statement.getUpdateCount();
        if(recordsDeleted > 0){
            executeSelect(statement, table, columnName, columnValue);
        }
        return recordsDeleted > 0;
    }
}
