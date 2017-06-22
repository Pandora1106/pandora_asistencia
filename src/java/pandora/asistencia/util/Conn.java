/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Ricardo
 */

public class Conn {

    private static String driver = null;
    private static String usuario = null;
    private static String password = null;
    private static String url = null;

    static {
        try {
            ResourceBundle properties = ResourceBundle.getBundle("pandora.asistencia.util.pandoraAsistencia");
            url = properties.getString("URL");
            driver = properties.getString("DRIVER");
            usuario = properties.getString("USER");
            password = properties.getString("PASSWORD");
            Class.forName(driver);
        } catch (Exception e) {

        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {            
            System.out.println("Error:" + e);
        }
        return connection;
    }
}
