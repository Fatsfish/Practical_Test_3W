/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author User-PC
 */
public class DBUtils {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FoodManagement", "sa", "210618");
    }

    public static boolean checkFormat(String ID) {
        boolean check = false;
        if (ID.startsWith("F-")) {
            if (isNumber(ID.charAt(2)) && isNumber(ID.charAt(3)) && isNumber(ID.charAt(4))) {
                check = true;
            }
        }
        return check;

    }
}
