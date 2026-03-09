package dev.Innocent.Section8.DataBase.JDBCChallenges;

import com.mysql.cj.jdbc.MysqlDataSource;


public class Challenge2 {

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser(System.getenv("MYSQLUSER"));
        dataSource.setPassword(System.getenv("MYSQLPASS"));
    }
}
