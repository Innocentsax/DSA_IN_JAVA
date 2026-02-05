package dev.Innocent.Section8.DataBase.JDBCChallenges;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static String USE_SCHEMA = "USE storefront";

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser(System.getenv("MYSQLUSER"));
        dataSource.setPassword(System.getenv("MYSQLPASS"));

        try(Connection conn = dataSource.getConnection()){

            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println(metaData.getSQLStateType());

            if(!checkSchema(conn)){
                System.out.println("storefront schema does not exist");
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static boolean checkSchema(Connection conn){
        try(Statement statement = conn.createStatement()){
            statement.execute(USE_SCHEMA);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            return false;
        }
        return true;
    }
}
