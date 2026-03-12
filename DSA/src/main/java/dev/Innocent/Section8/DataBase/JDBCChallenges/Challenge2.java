package dev.Innocent.Section8.DataBase.JDBCChallenges;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record OrderDetail(int orderDetailId, String itemDescription, int qty) {

    public OrderDetail(String itemDescription, int qty) {
        this(-1, itemDescription, qty);
    }
}

record Order(int orderId, String dateString, List<OrderDetail> details) {

    public Order(String dateString) {
        this(-1, dateString, new ArrayList<>());
    }

    public void addDetail(String itemDescription, int qty) {
        OrderDetail item = new OrderDetail(itemDescription, qty);
        details.add(item);
    }
}

public class Challenge2 {

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser(System.getenv("MYSQLUSER"));
        dataSource.setPassword(System.getenv("MYSQLPASS"));

        try (Connection conn = dataSource.getConnection()) {

//            String alterString =
//                    "ALTER TABLE storefront.order_details ADD COLUMN quantity INT";
//            Statement statement = conn.createStatement();
//            statement.execute(alterString);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Order> readData() {

        List<Order> vals = new ArrayList<>();

        try (Scanner scanner = new Scanner(Path.of("Orders.csv"))) {

            scanner.useDelimiter("[,\\n]");
            var list = scanner.tokens().map(String::trim).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vals;
    }
}
